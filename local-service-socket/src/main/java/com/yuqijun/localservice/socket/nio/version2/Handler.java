package com.yuqijun.localservice.socket.nio.version2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
@Slf4j
public class Handler {

    private Selector selector;

    private ByteBuffer buffer =  ByteBuffer.allocate(256);

    /* 在线客户列表 */
    public static Map<String,SocketChannel> clientInLine = new HashMap<>();

    @Bean
    private void start() {
        try {
            Thread thread = new Thread(getTask());
            thread.start();
            log.info("服务端 SOCKET 开启");
        }catch (IOException e){
            log.error("客户端处理TCP通信发生异常:",e);
        }
    }


    private Runnable getTask() throws IOException {


        selector  = ClientSelector.getInstance();

        Connector.initServerSocketChannel(selector);
        log.info("初始化服务端ServerSocketChannel");

        Runnable task = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

                while(true){
                    /* 判断是否有就绪事件 */
                    if(selector.select() == 0){
                        continue;
                    }

                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while(iterator.hasNext()){
                        SelectionKey next = iterator.next();

                        /* 处理事件 */
                        handlerAdepter(next);
                        iterator.remove();
                    }
                }
            }
        };
        return task;
    }

    private void handlerAdepter(SelectionKey key){
            if (key.isAcceptable()) {
//                log.info("「 客户端 」" + ((ServerSocketChannel) key.channel()).accept().getRemoteAddress() + " 尝试连接服务端");
                acceptHandler(key);
            } else if (key.isReadable()) {
//                log.info("「 客户端 」" + ((ServerSocketChannel) key.channel()).accept().getRemoteAddress()  + " 发送至服务端一条数据");
                readHandler(key);
            }


    }

    private void acceptHandler(SelectionKey key){
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel accept = serverSocketChannel.accept();

            log.info("「 客户端 」" + accept.getLocalAddress() + " 尝试连接服务端");

            accept.configureBlocking(false);
            accept.register(selector,SelectionKey.OP_READ);

            /* 将Ip为key， SocketChannel为value 存入 clientInLine */
            clientInLine.put(accept.getRemoteAddress().toString(),accept);


            boolean b = accept.finishConnect();

            log.info("「 客户端 」"+accept.getLocalAddress()+" 已加入在线客户列表 , 结束连接？ {}",b);
        }catch (IOException e){
            log.error("服务端处理连接时发生异常:",e);
        }

    }

    private void readHandler(SelectionKey key){

//        ByteBuffer buffer = ByteBuffer.allocate(256);

        try {
            /* 获取SocketChannel */
            SocketChannel socketChannel = (SocketChannel) key.channel();
            /* 读取信息 */
            int flag;
            if (0 < (flag = socketChannel.read(buffer))) {
                buffer.flip();
                byte [] bytes = new byte[buffer.remaining()];
                buffer.get(bytes);

                String str = new String (bytes);
                /* 解析信息 */
                String receiveIp = FormatMsg.getReceiveMsg(str);
                if(null == receiveIp){
                    log.warn("无效信息扔出");
                    buffer.clear();
                    return ;
                }
//                String realContent = FormatMsg.getMsg(str);

                /* 转发信息 */
                SocketChannel receiveSocketChannel = clientInLine.get(receiveIp);
                buffer.clear();
                buffer.put(bytes);
                receiveSocketChannel.write(buffer);



                /* 将消息投递到 Rabbit MQ 队列
                *
                *
                * */



            }

        }catch (IOException e){
            log.error("服务端在处理读取socketChannel信息时发生异常：",e);
        }

    }


}
