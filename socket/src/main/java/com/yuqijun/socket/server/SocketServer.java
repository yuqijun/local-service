package com.yuqijun.socket.server;

import model.LsUser;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuqijun
 * TCP服务端
 *  接收客户端的连接、转发客户端的信息给其他客户端
 * */

@Component
public class SocketServer {

    private List<LsUser> inLineUserList = new ArrayList<>();

    @Bean
    public void startTcpServerSocket () throws IOException {
        /* 创建socket */
        ServerSocket server = new ServerSocket(9000);
        /* 遍历监听连接客户端 */
        for(;;){
            Socket client = server.accept();
            /* 将客户端信息存入在线用户列表里面 */
        }
        /* 当有客户端连接时将客户端添加至客户端列表中 <集合> */
        /* 当收到客户端信息时，校验消息的合法性<消息的传输协议（格式）>，通过后遍历客户端列表将信息发送给除了消息发送方以外的所有客户端 */
        /* 当有客户端断开连接时将其从客户端列表移出 */
    }
}
