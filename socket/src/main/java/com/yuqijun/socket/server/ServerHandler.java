package com.yuqijun.socket.server;


import java.net.Socket;

/**
 * @author yuqijun
 * TCP服务端处理程序
 */
public class ServerHandler extends Thread{
    private Socket client ;
    public ServerHandler(Socket socket){
        this.client = socket;
    }

    @Override
    public void run() {
        super.run();

    }
}
