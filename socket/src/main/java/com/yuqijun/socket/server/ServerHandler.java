//package com.yuqijun.socket.server;
//
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.*;
//import java.net.Socket;
//import java.util.Map;
//
///**
// * @author yuqijun
// * TCP服务端处理程序
// */
//
//@Slf4j
//public class ServerHandler extends Thread{
//
////    private static Thread listenerToForward ;
//    private Socket client ;
//    public ServerHandler(Socket socket){
//        this.client = socket;
//    }
//
//    @SneakyThrows
//    @Override
//    public void run() {
//        super.run();
//
//        /* 监听客户端发送的消息并转发给其他客户端 */
////        listenerToForward(client);
//
//        boolean exit = false;
//        do {
//            InputStream inputStream = client.getInputStream();
//            int i;
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            while ((i = inputStream.read()) != -1) {
//                baos.write(i);
//            }
//            String receiveMsg = baos.toString();
//            String parseAfterMsg = MessageFormat.parser(receiveMsg);
//
//            if ("-1".equals(parseAfterMsg)) {
//                continue;
//            }else{
//                if("bye".equals(parseAfterMsg)){
//                    /* 客户端已退出，将在线客户列表中的记录删除 */
//                    SocketServer.inLineUserList.remove(MessageFormat.parserFunction(receiveMsg)[0]);
//                    exit = true;
//                    continue;
//                }
//                /* 得到用户发送的有效信息,然后给每个客户端进行发送*/
//                for(Map.Entry<String,Socket> client : SocketServer.inLineUserList.entrySet()){
//                    //排除自身
//
//
//                    /* 得到用户端的输出流，然后将 parseAfterMsg输出到用户端的输出流里面 */
//                    PrintStream ps = new PrintStream(client.getValue().getOutputStream());
//                    ps.print(receiveMsg);
//                }
//            }
//        }while(!exit);
//    }
//
//
//    /**
//     * 监听客户端并转发
//     */
//    public static void listenerToForward(Socket client){
//        Thread listenerToForwardThread  = new Thread(){
//            @SneakyThrows
//            @Override
//            public void run() {
//                super.run();
//
//                boolean exit = false;
//                do {
//                    log.info("服务端监听开启");
//                    InputStream inputStream = client.getInputStream();
//                    int i;
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    while ((i = inputStream.read()) != -1) {
//                        baos.write(i);
//                    }
//                    String receiveMsg = baos.toString();
//                    String parseAfterMsg = MessageFormat.parser(receiveMsg);
//
//                    if ("-1".equals(parseAfterMsg)) {
//                        continue;
//                    }else{
//                        if("bye".equals(parseAfterMsg)){
//                            /* 客户端已退出，将在线客户列表中的记录删除 */
//                            SocketServer.inLineUserList.remove(MessageFormat.parserFunction(receiveMsg)[0]);
//                            exit = true;
//                            continue;
//                        }
//                        /* 得到用户发送的有效信息,然后给每个客户端进行发送*/
//                        for(Map.Entry<String,Socket> client : SocketServer.inLineUserList.entrySet()){
//                            //排除自身
//
//
//                            /* 得到用户端的输出流，然后将 parseAfterMsg输出到用户端的输出流里面 */
//                            PrintStream ps = new PrintStream(client.getValue().getOutputStream());
//                            ps.print(receiveMsg);
//                        }
//                    }
//                }while(!exit);
//            }
//        };
//        listenerToForwardThread.start();
//    }
//
//}



package com.yuqijun.socket.server;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author yuqijun
 * TCP服务端处理程序
 */

@Slf4j
public class ServerHandler extends Thread{
    private Socket client ;

    private final String PARSER_ERROR = "-1";

    private final String EXIT = "exit";

    public ServerHandler(Socket client){
        this.client = client;
    }

    @SneakyThrows
    @Override
    public void run() {
        super.run();
        boolean exitFlag = false;
        BufferedReader bf = null;
        InputStream clientInputStream = null;
        do{

            /* 得到客户端输入流 */
            clientInputStream = client.getInputStream();

            /* 将输入流转换成字符串 */
            bf = new BufferedReader(new InputStreamReader(clientInputStream));
            String receiveMsg = bf.readLine();


            /* 判断信息是否格式正确 */
            if(null  == receiveMsg || "".equals(receiveMsg)){
                continue;
            }
            String parserReceiveMsg = MessageFormat.parser(receiveMsg);

            switch (parserReceiveMsg){
                case "-1":
                    log.info("非localService 通信，以丢弃该 Msg");
                    break;
                case "exit":
                    log.info("【"+client.getInetAddress()+"】已退出聊天室");
                    exitFlag = true;
                    break;
                default:
                    log.info("向所有在线用户推送Msg："+parserReceiveMsg);
                    /* 遍历在线客户端列表，对每个用户都输出当前信息<除了信息发送方> */
                    for(Socket client : SocketServer.inLineUserList){
                        PrintStream printStream = new PrintStream(client.getOutputStream());
                        printStream.println(MessageFormat.format(parserReceiveMsg,"192.168.3.142"));

                    }

                    break;
            }


        }while(!exitFlag);


        bf.close();
        clientInputStream.close();
        client.close();

    }
}