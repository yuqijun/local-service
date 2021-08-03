package com.yuqijun.socket.server.nio2;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* nio 服务端 */
@Slf4j
public class MyServer {


    /* 服务器端调度器 */
    private static Selector selector = null ;

    /* 服务器端停止服务标记 */
    private static boolean stop = false;

    private static ServerSocketChannel serverSocketChannel = null;

    public static void main(String [] args){

        /* 初始化Selector */
        initSelector();
        /* 初始化ServerSocketChannel */
        initServerSocketChannel();
        /* 进行事件监听 */
        run();

    }

    /* 初始化选择器 */
    private static void initSelector(){
        try {
            selector = Selector.open();
        }catch (Exception e){
            log.info(" 服务端初始化 Selector失败 ");
        }
    }


    /* 初始化ServerSocketChannel */
    private static void initServerSocketChannel(){
        try {
            serverSocketChannel = ServerSocketChannel.open();
            /* 配置channel */
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            serverSocketChannel.bind(new InetSocketAddress(9000));
        }catch (Exception e){
            log.info("初始化ServerSocketChannel时发生异常:",e);
        }
    }

    /* 进行事件(处理)监听 */
    public static void run()  {
        log.info("服务端开启服务");
        while(true){
            try {
                /* selector.select()方法是阻塞的，当有关心的事件就绪时才会继续实行下一步（进行下一行代码），否则触发新一轮 while循环 */
                selector.select();
                /* 得到就绪的事件集合 */
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    /* 得到key */
                    SelectionKey key = iterator.next();
                    /* 防止重复处理 */
                    iterator.remove();

                    /* 根据key的事件类型进行事件处理 */
                    if (key.isAcceptable()) {
                        acceptHandler(key);

                    } else if (key.isReadable()) {

                        /* 获取客户端channel读取数据转换成字符串在控制台打印 */
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int readByte;
                        if (0 < (readByte = clientChannel.read(byteBuffer))) {
                            byteBuffer.flip();
                            byte[] bytes = new byte[byteBuffer.remaining()];
                            byteBuffer.get(bytes);
                            String msg = new String(bytes);
                            log.info("客户端1：" + msg);

                        }
                    }

                }
            }catch (Exception e){
                log.error("服务端轮询监听事件时发生异常：",e);
            }
            log.info("服务端将中断程序...");
            /* 关闭ServerSocketChannel、Selector */

        }

    }

    private static void acceptHandler(SelectionKey key) {
        try {
            /* 得到客户端channel，将客户端channel注册到selector上， */
            ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
            SocketChannel clientChannel = serverChannel.accept();

            /* 配置客户端channel为非阻塞模式 */
            clientChannel.configureBlocking(false);
            /* 将客户端channel注册到Selector 上 */
            clientChannel.register(selector, SelectionKey.OP_READ);

            /* 向客户端推送 已经连接上服务器的提示小消息 */
            String tips = "yqj的服务器：您已成功连接服务器...";
            byte[] bytes = tips.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            clientChannel.write(byteBuffer);
        }catch (Exception e){
            log.info("服务端接收连接时发生异常:",e);
        }
    }
}
