//package com.yuqijun.localservice.socket.server.nio2;
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.ByteBuffer;
//import java.nio.channels.SocketChannel;
//
//@Slf4j
//public  class PushInfo extends Thread{
//
//    private final static String EXIT = "EXIT";
//
//    private SocketChannel clientChannel;
//
//    private boolean stop;
//
//    public PushInfo(SocketChannel clientChannel,boolean stop){
//        this.clientChannel = clientChannel;
//        this.stop = stop;
//    }
//
//    @SneakyThrows
//    @Override
//    public void run() {
//        super.run();
//        while(!stop){
//            /* 读取键盘输入 */
//            InputStream in = System.in;
//
//
//
//
//            /* 没有输入自继续下一轮循环 */
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//            String s = bufferedReader.readLine();
////            log.info("s :"+s);
//
//            /* 读取键盘输入然后通过clientChannel输出 */
//
//            ByteBuffer byteBuffer = ByteBuffer.wrap(s.getBytes());
//            clientChannel.write(byteBuffer);
//
//
//            if(EXIT.equals(s)){
//                stop = true;
//            }
//        }
//        log.info("客户端请求退出程序...");
//        clientChannel.close();
//    }
//}
