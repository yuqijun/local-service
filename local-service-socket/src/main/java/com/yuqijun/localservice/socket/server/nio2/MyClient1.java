//package com.yuqijun.localservice.socket.server.nio2;
//
//
//import lombok.extern.slf4j.Slf4j;
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.nio.ByteBuffer;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.SocketChannel;
//import java.util.Iterator;
//
///* nio 客户端 SocketChanel  */
//@Slf4j
//public class MyClient1 {
//
//    /* 客户端事件调度器 */
//    private static Selector selector;
//
//    /* 客户端退出标记 */
//    private static boolean stop = false;
//
//    private static SocketChannel clientChannel = null;
//
//    private final static String EXIT = "EXIT";
//
//    public static void main(String [] args){
//
//        /* 初始化Selector */
//        initSelector();
//        /* 连接服务端 */
//        initClientChannel();
//
//        /* 发送信息 */
//        PushInfo push = new PushInfo(clientChannel,stop);
//        push.start();
//
////        /* 获取SocketChannel 将SocketChannel与OP_READ事件注册到Selector 中 */
////        registerEvent();
//        /* 监听处理事件(程序) */
//        run();
//
//    }
//
//    private static void initClientChannel(){
//        try {
//            /* 从缓存中获取客户端通道 */
//            clientChannel = SocketChannel.open();
//            /* 配置客户端通道为非阻塞模式 */
//            clientChannel.configureBlocking(false);
//            /* 将客户端绑定到服务端 */
//            clientChannel.connect(new InetSocketAddress("127.0.0.1",9000));
//            clientChannel.register(selector,SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE);
//        }catch (Exception e){
//            log.error("初始化客户端channel时发生异常:",e);
//        }
//    }
//
//    private static void initSelector(){
//        try {
//            selector = Selector.open();
//        }catch (Exception e){
//            log.error("客户端获取事件调度器时发生异常:",e);
//        }
//    }
//
//    private static void registerEvent(){
//        try {
//            clientChannel.register(selector, SelectionKey.OP_CONNECT);
//        }catch (Exception e){
//            log.error("客户端注册关心事件时发生异常:",e);
//        }
//    }
//
//    private static void run(){
//        while(!stop){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            try {
//                /*  等待就绪事件 */
//                if(selector.select() == 0){
//                    continue;
//                }
//
//                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
//                while(keys.hasNext()){
//                    SelectionKey key = keys.next();
//                    /* 防止重复处理 */
//                    keys.remove();
//                    /* 处理key */
//                    selectionKeyHandler(key);
//                }
//            }catch (Exception e){
//                log.error("客户端监听(处理)事件时发生异常即将退出程序:",e);
//            }
//        }
//        log.info("客户端即将退出程序...");
//    }
//
//    private static void selectionKeyHandler(SelectionKey key){
//        /* 根据key的事件类型使用不同的 事件类型处理器 */
//
//        if(key.isConnectable()){
//            connectServerHandler(key);
//        }else
//        if(key.isReadable()){
//            readMessageHandler(key);
//        }
//
//        if(key.isWritable()){
//            writeMessageHandler(key);
//        }
//    }
//
//
//    /* 连接服务端处理器 */
//    private static void connectServerHandler(SelectionKey key){
//        try {
//            SocketChannel clientChannel = (SocketChannel) key.channel();
//            clientChannel.register(selector,SelectionKey.OP_READ);
//
//            if(clientChannel.finishConnect()) {
//                byte[] bytes = "client request connection...".getBytes();
//                ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
//                byteBuffer.put(bytes);
//                byteBuffer.flip();
//                clientChannel.write(byteBuffer);
//                log.info("客户端发起连接请求信息:".concat(new String(bytes)));
//            }
//        }catch (Exception e){
//            log.error("客户端在连接服务器时发生异常:",e);
//        }
//    }
//
//    /* 发送消息处理器 */
//    private static void writeMessageHandler(SelectionKey key){
//        log.info("客户端暂未实现发送消息功能");
//    }
//
//    /* 读取消息处理器 */
//    private static void readMessageHandler(SelectionKey key){
//        try {
//            SocketChannel clientChannel = (SocketChannel) key.channel();
//            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//            int readByte;
//            if (0 < (readByte = clientChannel.read(byteBuffer))) {
//                byteBuffer.flip();
//                byte [] bytes = new byte[byteBuffer.remaining()];
//                byteBuffer.get(bytes);
//                String message = new String(bytes);
//                log.info("接收消息："+message);
//            }
//        }catch (IOException e){
//            log.info("客户端读取消息时发生异常:",e);
//        }
//    }
//
//}
//
