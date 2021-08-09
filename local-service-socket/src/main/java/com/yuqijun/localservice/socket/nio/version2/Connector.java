package com.yuqijun.localservice.socket.nio.version2;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

@Slf4j
public class Connector {

    /* 多路复用器 */
    private static Selector selector;

//    public static void connect(){
//        try {
//            /* 初始化多路复用器， */
//            selector = ClientSelector.getInstance();
//            /* 尝试连接服务端,并且监听连接成功与否 */
//            initSocketChannel();
//        }catch (IOException e){
//            log.error("客户端进行连接时发生异常:",e);
//        }
//    }

    public static void initServerSocketChannel(Selector selector){
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(9000));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (IOException e){
            log.error("初始化服务端套接字(ServerSocketChannel)时发生异常:",e);
        }
    }

}
