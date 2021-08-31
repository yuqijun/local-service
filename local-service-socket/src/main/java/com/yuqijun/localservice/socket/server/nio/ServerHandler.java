////package com.yuqijun.socket.server;
////
////
////import lombok.SneakyThrows;
////import lombok.extern.slf4j.Slf4j;
////
////import java.io.*;
////import java.net.Socket;
////import java.util.Map;
////
/////**
//// * @author yuqijun
//// * TCP服务端处理程序
//// */
////
////@Slf4j
////public class ServerHandler extends Thread{
////
//////    private static Thread listenerToForward ;
////    private Socket client ;
////    public ServerHandler(Socket socket){
////        this.client = socket;
////    }
////
////    @SneakyThrows
////    @Override
////    public void run() {
////        super.run();
////
////        /* 监听客户端发送的消息并转发给其他客户端 */
//////        listenerToForward(client);
////
////        boolean exit = false;
////        do {
////            InputStream inputStream = client.getInputStream();
////            int i;
////            ByteArrayOutputStream baos = new ByteArrayOutputStream();
////            while ((i = inputStream.read()) != -1) {
////                baos.write(i);
////            }
////            String receiveMsg = baos.toString();
////            String parseAfterMsg = MessageFormat.parser(receiveMsg);
////
////            if ("-1".equals(parseAfterMsg)) {
////                continue;
////            }else{
////                if("bye".equals(parseAfterMsg)){
////                    /* 客户端已退出，将在线客户列表中的记录删除 */
////                    SocketServer.inLineUserList.remove(MessageFormat.parserFunction(receiveMsg)[0]);
////                    exit = true;
////                    continue;
////                }
////                /* 得到用户发送的有效信息,然后给每个客户端进行发送*/
////                for(Map.Entry<String,Socket> client : SocketServer.inLineUserList.entrySet()){
////                    //排除自身
////
////
////                    /* 得到用户端的输出流，然后将 parseAfterMsg输出到用户端的输出流里面 */
////                    PrintStream ps = new PrintStream(client.getValue().getOutputStream());
////                    ps.print(receiveMsg);
////                }
////            }
////        }while(!exit);
////    }
////
////
////    /**
////     * 监听客户端并转发
////     */
////    public static void listenerToForward(Socket client){
////        Thread listenerToForwardThread  = new Thread(){
////            @SneakyThrows
////            @Override
////            public void run() {
////                super.run();
////
////                boolean exit = false;
////                do {
////                    log.info("服务端监听开启");
////                    InputStream inputStream = client.getInputStream();
////                    int i;
////                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
////                    while ((i = inputStream.read()) != -1) {
////                        baos.write(i);
////                    }
////                    String receiveMsg = baos.toString();
////                    String parseAfterMsg = MessageFormat.parser(receiveMsg);
////
////                    if ("-1".equals(parseAfterMsg)) {
////                        continue;
////                    }else{
////                        if("bye".equals(parseAfterMsg)){
////                            /* 客户端已退出，将在线客户列表中的记录删除 */
////                            SocketServer.inLineUserList.remove(MessageFormat.parserFunction(receiveMsg)[0]);
////                            exit = true;
////                            continue;
////                        }
////                        /* 得到用户发送的有效信息,然后给每个客户端进行发送*/
////                        for(Map.Entry<String,Socket> client : SocketServer.inLineUserList.entrySet()){
////                            //排除自身
////
////
////                            /* 得到用户端的输出流，然后将 parseAfterMsg输出到用户端的输出流里面 */
////                            PrintStream ps = new PrintStream(client.getValue().getOutputStream());
////                            ps.print(receiveMsg);
////                        }
////                    }
////                }while(!exit);
////            }
////        };
////        listenerToForwardThread.start();
////    }
////
////}
//
//
//
//package com.yuqijun.localservice.socket.server.nio;
//
//import ch.qos.logback.core.util.CloseUtil;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.nio.ByteBuffer;
//import java.nio.channels.*;
//import java.util.Iterator;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * @author yuqijun
// * TCP服务端处理程序
// */
//
//@Slf4j
//public class ServerHandler extends Thread{
//
//    public ServerHandler(ServerSocketChannel serverSocketChannel,Selector selector){
//        this.selector = selector;
//        this.serverSocketChannel = serverSocketChannel;
//    }
//    private ServerSocket server ;
//
//    private final String PARSER_ERROR = "-1";
//
//    private final String EXIT = "exit";
//
//    private Selector selector;
//
////    public ServerHandler(ServerSocket client){
////        this.client = client;
////    }
//
//
//    private  ServerSocketChannel serverSocketChannel;
//    @SneakyThrows
//    @Override
//    public void run() {
//        super.run();
//        boolean exitFlag = false;
//        BufferedReader bf = null;
//        InputStream clientInputStream = null;
//        Socket client  = server.accept();
//
//        /* 服务器信息  */
//        log.info("服务器信息："+server.getLocalSocketAddress());
//
//
//        do{
//            if(selector.select()==0){
//                if(exitFlag){
//                    break;
//                }
//            }
//
//
//            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
//            while(iterator.hasNext()){
//                if(exitFlag){
//                    break;
//                }
//                SelectionKey key = iterator.next();
//                iterator.remove();
//                /* 检查当前key的状态是否是我们关注的状态 */
//                /* 这里为 客户端到达状态 */
//                if(key.isAcceptable()){
//                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
//                    SocketChannel clientChannel = channel.accept();
//
//                    /* 构建异步处理 */
//                    clientChannel.configureBlocking(false);
//
//                    /* 得到读selector  并且设置监听事件*/
//                    Selector readSelector = Selector.open();
//                    clientChannel.register(readSelector,SelectionKey.OP_READ);
//                    ClientReadHandler clientReadHandler = new ClientReadHandler(readSelector);
//                    clientReadHandler.start();
//
//                    /* 得到写selector 并且设置监听事件 */
//                    Selector writeSelector = Selector.open();
//                    clientChannel.register(writeSelector,SelectionKey.OP_WRITE);
//
//
//
//
//
//                    /* 关闭所有流后要 selector.wakeup() */
//                }
//            }
//
//
//
//
////            /* 得到客户端输入流 */
////            clientInputStream = client.getInputStream();
////
////
////            /* 将输入流转换成字符串 */
////            bf = new BufferedReader(new InputStreamReader(clientInputStream));
////            String receiveMsg = bf.readLine();
////
////
////            /* 判断信息是否格式正确 */
////            if(null  == receiveMsg || "".equals(receiveMsg)){
////                continue;
////            }
////            String parserReceiveMsg = MessageFormat.parser(receiveMsg);
////
////            switch (parserReceiveMsg){
////                case "-1":
////                    log.info("非localService 通信，以丢弃该 Msg");
////                    break;
////                case "exit":
////                    log.info("【"+client.getInetAddress()+"】已退出聊天室");
////                    exitFlag = true;
////                    break;
////                default:
////                    log.info("向所有在线用户推送Msg："+parserReceiveMsg);
////                    /* 遍历在线客户端列表，对每个用户都输出当前信息<除了信息发送方> */
////                    for(Socket client : SocketServer.inLineUserList){
////                        PrintStream printStream = new PrintStream(client.getOutputStream());
////                        printStream.println(MessageFormat.format(parserReceiveMsg,"192.168.3.142"));
////
////                    }
////
////                    break;
////            }
//
//
//        }while(!exitFlag);
//
//
//        bf.close();
//        clientInputStream.close();
//        client.close();
//
//    }
//
//    class ClientReadHandler extends Thread{
//
//        private Selector selector;
//
//        private final ByteBuffer buffer;
//
//        private boolean exitFlag = false;
//
//        public ClientReadHandler(Selector writeSelector){
//            this.selector = writeSelector;
//            buffer = ByteBuffer.allocate(256);
//        }
//        @SneakyThrows
//        @Override
//        public void run() {
//            super.run();
//
//            try{
//                do{
//                    /* 如果selector中的就绪状态的 channel为0 则表示没有任何需要处理 */
//                    if(selector.select() ==0){
//                        if(exitFlag){
//                            break;
//                        }
//                        continue;
//                    }
//
//                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
//                    while(iterator.hasNext()){
//                        /* 如果退出标记为真值则无需继续往下处理 */
//                        if(exitFlag){
//                            break;
//                        }
//                        SelectionKey key = iterator.next();
//                        iterator.remove();
//
//
//                        SocketChannel client = (SocketChannel) key.channel();
//                        buffer.clear();
//                        /* 保证buffer是空的， read是从0开始读取的 */
//                        int read = client.read(buffer);
//                        if(read>0){
//                            String msg = new String(buffer.array(),0,read-1);
//                            client.write(ByteBuffer.wrap(msg.getBytes()));
//                        }else{
//                            log.info("当前无法读取数据");
//                            break;
//                        }
//                    }
//
//                }while(!exitFlag);
//            }catch (Exception e){
//                log.info("服务器执行监听时发生异常:",e);
//            }
//
//            /* 关闭各种流*/
//            selector.wakeup();
//            selector.close();
//        }
//    }
//
//    class ClientWriteHandler extends Thread{
//
//        private SocketChannel channel;
//
//        private final  Selector selector;
//
//        private final ByteBuffer buffer;
//
//        private boolean exitFlag = false;
//
//        private final String msg ;
//
//        private final ExecutorService executorService;
//
//        public ClientWriteHandler(Selector selector,SocketChannel channel,String msg){
//            this.selector = selector;
//            buffer = ByteBuffer.allocate(256);
//            executorService = Executors.newSingleThreadExecutor();
//            this.msg = msg;
//            this.channel = channel;
//        }
//        @SneakyThrows
//        @Override
//        public void run() {
//            super.run();
//
//
////            do{
////                /* 进行事件监听 */
////                if(selector.select()>0){
////                    if(exitFlag){
////                       break;
////                    }
////
////                }
////                continue;
////            }while (!exitFlag);
//
//            buffer.clear();
//            buffer.put(msg.getBytes());
//            buffer.flip();
//            while(!exitFlag && buffer.hasRemaining()){
//
//                int write = channel.write(buffer);
//                while(write<0){
//                    log.info("服务器无法向客户端发送数据");
//                    exitFlag = true;
//                    break;
//                }
//            }
//
//
//            selector.wakeup();
//            selector.close();
//            /*关闭各种流*/
//        }
//    }
//}