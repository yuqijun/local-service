package com.yuqijun.socket.server.nio;

import lombok.SneakyThrows;

import java.io.*;
import java.net.Socket;

/**
 * @author yuqijun
 * TCP 客户端处理程序
 */
public class ClientHandler extends Thread{
    private Socket client;

//    private static Thread senderThread;
    public ClientHandler (Socket socket){
        this.client = socket;
    }

    @SneakyThrows
    @Override
    public void run() {
        super.run();
        /* 发送消息 */
        pushMsg(client);


        /* 接收消息 */
    }

    /* 客户端向服务器端发送消息 */
    private static void pushMsg(Socket client) throws IOException {
        OutputStream clientOutputStream = client.getOutputStream();
        Thread pushMsgThread = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                boolean writeExit = true;
                super.run();
                while(writeExit) {
                    InputStream in = System.in;
                    BufferedReader bf = new BufferedReader(new InputStreamReader(in));
                    String sendMsg = bf.readLine();
                    if("bye".equals(sendMsg)){
                        writeExit = false;
                        continue;
                    }
                    int i;
                    while ((i = in.read()) != -1) {
                        clientOutputStream.write(i);
                    }
                    clientOutputStream.flush();
                }
            }

        };
        pushMsgThread.start();
    }
}
