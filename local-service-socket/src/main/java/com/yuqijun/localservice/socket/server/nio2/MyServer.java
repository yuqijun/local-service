//package com.yuqijun.localservice.socket.server.nio2;
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.IOUtils;
//import sun.tools.jinfo.JInfo;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.InetSocketAddress;
//import java.nio.ByteBuffer;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.ServerSocketChannel;
//import java.nio.channels.SocketChannel;
//import java.util.Iterator;
//
///* nio 服务端 */
//@Slf4j
//public class MyServer {
//
//    private final static String EXIT = "EXIT";
//
//    /* 服务器端调度器 */
//    private static Selector selector = null ;
//
//    /* 服务器端停止服务标记 */
//    private static boolean stop = false;
//
//    private static ServerSocketChannel serverSocketChannel = null;
//
//    public static void main(String [] args){
//
//        /* 初始化Selector */
//        initSelector();
//        /* 初始化ServerSocketChannel */
//        initServerSocketChannel();
//        /* 进行事件监听 */
//        run();
//    }
//
//    /* 初始化选择器 */
//    private static void initSelector(){
//        try {
//            selector = Selector.open();
//        }catch (Exception e){
//            log.info(" 服务端初始化 Selector失败 ");
//        }
//    }
//
//
//    /* 初始化ServerSocketChannel */
//    private static void initServerSocketChannel(){
//        try {
//            serverSocketChannel = ServerSocketChannel.open();
//            /* 配置channel */
//            serverSocketChannel.configureBlocking(false);
//            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//            serverSocketChannel.bind(new InetSocketAddress(9000));
//        }catch (Exception e){
//            log.info("初始化ServerSocketChannel时发生异常:",e);
//        }
//    }
//
//    /* 进行事件(处理)监听 */
//    public static void run()  {
//        log.info("服务端开启服务");
//        while(!stop){
//            try {
//                Thread.sleep(1000);
//                /* selector.select()方法是阻塞的，当有关心的事件就绪时才会继续实行下一步（进行下一行代码），否则触发新一轮 while循环 */
//                if(selector.select() == 0 ){
//                    continue;
//                }
//                /* 得到就绪的事件集合 */
//                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
//                while (iterator.hasNext()) {
////                    log.info("服务端进入处理事件循环");
//                    /* 得到key */
//                    SelectionKey key = iterator.next();
//
//                    /* 根据key的事件类型进行事件处理 */
//                    if (key.isAcceptable()) {
//                        log.info("有客户端请求连接");
//                        log.info("服务端发生accept事件");
//                        acceptHandler(key);
//                    }
//                    if (key.isReadable()) {
////                        log.info("服务端发生read事件");
//
//                        /* 获取客户端channel读取数据转换成字符串在控制台打印 */
//                        SocketChannel clientChannel = (SocketChannel) key.channel();
//                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//                        int readByte;
//                       try {
//                           if (0 < (readByte = clientChannel.read(byteBuffer))) {
//                               byteBuffer.flip();
//                               byte[] bytes = new byte[byteBuffer.remaining()];
//                               byteBuffer.get(bytes);
//                               String msg = new String(bytes);
//                               log.info("客户端1：" + msg);
//
//                           } else {
//                               throw new Exception("客户端非正常关闭，将手动关闭socketChannel");
//                           }
//                       }catch (Exception e){
//                           key.cancel();
//                           if(clientChannel != null){
//                               clientChannel.close();
//                           }
//                       }
//
//
//
//
//                    }
//                    iterator.remove();
//                }
//            }catch (Exception e){
//
//                log.error("服务端轮询监听事件时发生异常：",e);
//            }
//        }
//        log.info("服务端将中断程序...");
//        /* 关闭ServerSocketChannel、Selector */
//
//    }
//
//    private static void acceptHandler(SelectionKey key) {
//        try {
//            /* 得到客户端channel，将客户端channel注册到selector上， */
//            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
//            SocketChannel clientChannel = ssc.accept();
//            /* 配置客户端channel为非阻塞模式 */
//            clientChannel.configureBlocking(false);
//            /* 将客户端channel注册到Selector 上 */
//            clientChannel.register(selector, SelectionKey.OP_READ );
//
//            ByteBuffer readBytebuffer = ByteBuffer.allocate(1024);
//            int read ;
//            if(  0<(read=clientChannel.read(readBytebuffer)) ){
//                readBytebuffer.flip();
//                byte [] readBytes  = new byte[readBytebuffer.remaining()];
//                readBytebuffer.get(readBytes);
//                String readmsg = new String(readBytes);
//                log.info("客户端请求连接时附带的信息：".concat(readmsg));
//            }
//            /* 向客户端推送 已经连接上服务器的提示小消息 */
//            String tips = "yqj的服务器：您已成功连接服务器...";
//            log.info("服务端向客户端发送连接成功 tips");
//            byte[] bytes = tips.getBytes();
//            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
//            byteBuffer.put(bytes);
//            byteBuffer.flip();
//            clientChannel.write(byteBuffer);
//        }catch (Exception e){
//            log.info("服务端接收连接时发生异常:",e);
//        }
//    }
//
//
//    private byte [] inputStreamToBytes(InputStream input) throws IOException {
//
//        byte [] bytes = new byte[256];
//        int j ;
//        while( 0< (j= input.read()) ){
//            input.read(bytes);
//        }
//        return bytes;
//    }
//}
//
//
