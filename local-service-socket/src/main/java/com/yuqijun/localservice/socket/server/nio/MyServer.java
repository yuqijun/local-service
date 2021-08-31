//package com.yuqijun.localservice.socket.server.nio;
//
//import lombok.extern.slf4j.Slf4j;
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.nio.ByteBuffer;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.ServerSocketChannel;
//import java.nio.channels.SocketChannel;
//import java.util.Iterator;
//
///* nio  ServerSocket */
//@Slf4j
//public class MyServer {
//
//    private static Selector selector = null;
//
//    public static void main(String [] args) throws IOException {
//        init();
//    }
//
//
//    public static void init () throws IOException {
//        /* 创建Selector */
//        selector = Selector.open();
//        /* 初始化SocketChannel */
//        initSocketChannel();
//        /* 轮训Selector */
//        run();
//
//    }
//
//    public static void initSocketChannel() {
//        ServerSocketChannel serverSocketChannel = null;
//        try {
//            /* 从缓存中获取一个ServerSocketChannel */
//            serverSocketChannel = ServerSocketChannel.open();
//            /* 服务端地址 */
//            serverSocketChannel.socket().bind(new InetSocketAddress(9000),1024);
//            /* 配置为非阻塞模式 */
//            serverSocketChannel.configureBlocking(false);
//            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//        } catch (IOException e) {
//            log.info("初始化SocketChannel时发生异常:",e);
//        }
//
//    }
//
//    public static void run() {
//        /* 轮训监听selector */
//        while(true){
//            try {
//                if(selector.select()==0){
//                    continue;
//                }
//                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
//                while(iterator.hasNext()){
//                    SelectionKey key = iterator.next();
//                    handle(key);
//                    iterator.remove();
//                }
//            } catch (IOException e) {
//                log.info("监听selector时发生异常:",e);
//            }
//        }
//    }
//
//
//    public static void handle(SelectionKey key){
//        try{
//            /* 准备就绪 */
//            if(key.isAcceptable()){
//                log.info("有客户端连接");
//                acceptHandler(key);
//            }
//
//            /* 读就绪 */
//            if(key.isReadable()){
//                readHandler(key);
//            }
//        }catch (Exception e){
//            log.info("服务器在进行处理 SelectionKey时发生异常:",e);
//        }
//    }
//
//    public static void acceptHandler(SelectionKey key){
//
//           try {
//
//               /* 获取服务端channel */
//               ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
//               /* 从服务端channel中获取客户端channel */
//               SocketChannel clientChannel = ssc.accept();
//
//               /* 设置客户端channel配置 */
//               clientChannel.configureBlocking(false);
//               clientChannel.register(selector, SelectionKey.OP_READ);
//
//
//               /* 没看懂 */
//               key.interestOps(SelectionKey.OP_ACCEPT);
//
//           } catch (Exception e) {
//               log.info("服务器在处理 接收请求时发生异常:", e);
//           }
//
//    }
//
//    public static void readHandler(SelectionKey key){
//        try{
//
//            SocketChannel channel = (SocketChannel) key.channel();
//
//
////            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
////            SocketChannel channel = ssc.accept();
//
//
//            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//            String content = "服务端返回了";
//            int readBytes = channel.read(byteBuffer);
//            if(readBytes>0){
//                byteBuffer.flip();
//                byte [] bytes = new byte[byteBuffer.remaining()];
//                byteBuffer.get(bytes);
//                content = content+ new String(bytes);
//                content += "_______";
//                doWrite(channel,content);
//            }
//        }catch (Exception e){
//            log.info("服务器在处理读取数据时发生异常:",e);
//        }
//    }
//
//    public static void doWrite(SocketChannel channel , String content) throws IOException {
//        byte[] req = content.getBytes();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(req.length);
//        byteBuffer.put(req);
//        byteBuffer.flip();
//        channel.write(byteBuffer);
//        if(!byteBuffer.hasRemaining()){
//            log.info("服务器已完成数据回显："+content);
//        }
//    }
//}
