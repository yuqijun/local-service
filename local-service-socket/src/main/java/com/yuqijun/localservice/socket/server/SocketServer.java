//package com.yuqijun.localservice.socket.server;
//
//
//import lombok.extern.slf4j.Slf4j;
//import java.io.*;
//import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author yuqijun
// * TCP服务端
// *  接收客户端的连接、转发客户端的信息给其他客户端
// * */
//
//@Slf4j
////@Component
//public class SocketServer {
//
//    private static final  int port = 9000;
//
//
//    public static List<Socket> inLineUserList = new ArrayList<>();
//
////    @Bean
//    public static void  main (String [] args) throws IOException {
//        log.info("服务端开启："+ InetAddress.getLocalHost() +":"+port);
//        /* 创建socket */
//        ServerSocket server = new ServerSocket(port);
//        /* 遍历监听连接客户端 */
//        for(;;){
//            Socket client = server.accept();
//            inLineUserList.add(client);
//            log.info(client.getInetAddress()+"请求连接服务器");
//            ServerHandler serverHandler = new ServerHandler(client);
//            serverHandler.start();
//        }
//
//        /* 当收到客户端信息时，校验消息的合法性<消息的传输协议（格式）>，通过后遍历客户端列表将信息发送给除了消息发送方以外的所有客户端 */
//        /* 当有客户端断开连接时将其从客户端列表移出 */
//    }
//
//}
