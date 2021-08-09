package com.yuqijun.localservice.socket.server.nio;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

/**
 * @author yuqijun
 * TCP客户端
 */
@Slf4j
public class SocketClient2 {

    private  static Thread pushMsgThread ;

    private static final String  PARSER_ERROR = "-1";

    private static final int  port = 9000;

    public static void main (String [] args) throws IOException {
        /* 创建客户端socket */
        Socket client = new Socket("192.168.3.142",port);

        boolean exitFlag = false;
        PrintStream pr = null;
        InputStream in = null;

        /* 开启消息监听 */
        ListenerThread listener = new ListenerThread(client);
        listener.start();


        while(!exitFlag){
            /*拿到客户端输出流然后将键盘的字符传给输出流*/
            in = System.in;
            pr = new PrintStream(client.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String userScannerData = bufferedReader.readLine();
            pr.println(MessageFormat.format(userScannerData,"192.168.3.142"));
            pr.flush();
        }

        pr.close();
        in.close();
        client.close();

        /*  监听消息 */

    }

    public static class ListenerThread extends Thread{
        private Socket client;

        public ListenerThread(Socket client){
            this.client = client;
        }

        @SneakyThrows
        @Override
        public void run() {
            super.run();

            log.info("开启消息监听");
            boolean exitFlag = false;
            do{
                /* 获取客户端输入流 */
                InputStream clientInputStream = client.getInputStream();
                /* 转换成字符串 */
                BufferedReader br = new BufferedReader(new InputStreamReader(clientInputStream));
                /* 检查消息合法性 */
                String parserAfterMessage = MessageFormat.parser(br.readLine());
                if(PARSER_ERROR.equals(parserAfterMessage)){
                    continue;
                }
                /* 输出在屏幕 */
                log.info(parserAfterMessage);

            }while (!exitFlag);
        }
    }

}
