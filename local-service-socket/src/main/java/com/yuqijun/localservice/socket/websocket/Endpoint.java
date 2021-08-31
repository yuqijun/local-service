//package com.yuqijun.localservice.socket.websocket;
//
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArraySet;
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//
///**
// * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
// * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
// * 每次请求，都会创建一个实例
// */
//@Slf4j
//@Component
//@ServerEndpoint("/websocket")
//public class Endpoint {
//    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
//    private static int onlineCount = 0;
//
//    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
//    private static CopyOnWriteArraySet<Endpoint> webSocketSet = new CopyOnWriteArraySet<Endpoint>();
//    private ConcurrentHashMap<String,Endpoint> webSocketMap = new ConcurrentHashMap<>();
//
//    //与某个客户端的连接会话，需要通过它来给客户端发送数据
//    private Session session;
//
//    public static ConcurrentHashMap<String, List<Endpoint>>  group = new ConcurrentHashMap<>();
//
//
//    /**
//     * 连接建立成功调用的方法
//     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
//     */
//    @OnOpen
//    public void onOpen(Session session){
////        log.info("用户：{} 登陆",userId);
////        this.session = session;
////        webSocketMap.put(userId,this);
//
//        webSocketSet.add(this);
//        addOnlineCount();           //在线数加1
//        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
//    }
//
//    /**
//     * 连接关闭调用的方法
//     */
//    @OnClose
//    public void onClose(){
////        webSocketMap.remove(userId);  //从set中删除
//        subOnlineCount();           //在线数减1
//        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
//    }
//
//    /**
//     * 收到客户端消息后调用的方法
//     * @param message 客户端发送过来的消息
//     * @param session 可选的参数
//     */
//    @OnMessage
//    public void onMessage(String message, Session session) {
//
//        /*
//        *  一对一
//        *  一对多
//        *  */
//
//        /* 解析message 判断消息是否是消息协议的消息
//        *  如果是 Otm 则是一对多
//        *  如果是 OOO 则是一对一
//        *
//        *  */
//
////        Map<String, Object> msgCheck = Agreement.msgCheck(message);
////        /* 不符合消息协议的消息不处理 */
////        if(null  == msgCheck){ return; }
////        /* 优化空间： 责任链模式 */
////        String msg = msgCheck.get(Agreement.MSG_HEAD_CONTENT).toString();
////        if(msgCheck.get(Agreement.MSG_HEAD_FORWORDTYPE).equals(1)){
////            /* 1对1 */
////            String receiveId = msgCheck.get(Agreement.MSG_HEAD_OOO).toString();
////            Endpoint endpoint = webSocketMap.get(receiveId);
////            try {
////                endpoint.sendMessage(msg);
////            }catch (Exception e){
////                log.error("发送消息时发生异常 ",e);
////            }
////        }else if(msgCheck.get(Agreement.MSG_HEAD_FORWORDTYPE).equals(2)){
////            /* 优化空间：群组关系持久化 */
////            /* 1对多 */
////            String groupId = msgCheck.get(Agreement.MSG_HEAD_OTM).toString();
////            List<Endpoint> endpoints = group.get(groupId);
////            for(Endpoint e: endpoints){
////                try {
////                    e.sendMessage(msg);
////                }catch (Exception e1){
////                    log.error("发送群组消息时发生异常",e1);
////                }
////            }
////
////        }
//
//        for(Endpoint endpoint:webSocketSet){
//            try{
//                endpoint.sendMessage(message);
//            }catch (Exception e){
//                log.error("发消息时发生异常：{}",e);
//            }
//        }
//
//    }
//
//    /**
//     * 发生错误时调用
//     * @param session
//     * @param error
//     */
//    @OnError
//    public void onError(Session session, Throwable error){
//        System.out.println("发生错误");
//        error.printStackTrace();
//    }
//
//    /**
//     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
//     * @param message
//     * @throws IOException
//     */
//    public void sendMessage(String message) throws IOException{
//        this.session.getBasicRemote().sendText(message);
//    }
//
//
//
//
//    public static synchronized int getOnlineCount() {
//        return onlineCount;
//    }
//
//    public static synchronized void addOnlineCount() {
//        Endpoint.onlineCount++;
//    }
//
//    public static synchronized void subOnlineCount() {
//        Endpoint.onlineCount--;
//    }
//}







package com.yuqijun.localservice.socket.websocket;



import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 * 每次请求，都会创建一个实例
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{userId}")
public class Endpoint {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<Endpoint> webSocketSet = new CopyOnWriteArraySet<Endpoint>();
    private ConcurrentHashMap<String,Endpoint> webSocketMap = new ConcurrentHashMap<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    public static ConcurrentHashMap<String, List<Endpoint>>  group = new ConcurrentHashMap<>();


    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session , @PathParam("userId")String userId){


        log.info("用户：{} 登陆",userId);
        this.session = session;
        webSocketMap.put(userId,this);

//        webSocketSet.add(this);
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
//        webSocketMap.remove(userId);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */


    @OnMessage
    public void onMessage(String message, Session session) {

        /*
         *  一对一
         *  一对多
         *  */

        /* 解析message 判断消息是否是消息协议的消息
         *  如果是 Otm 则是一对多
         *  如果是 OOO 则是一对一
         *
         *  */

//        Map<String, Object> msgCheck = Agreement.msgCheck(message);
//        /* 不符合消息协议的消息不处理 */
//        if(null  == msgCheck){ return; }
//        /* 优化空间： 责任链模式 */
//        String msg = msgCheck.get(Agreement.MSG_HEAD_CONTENT).toString();
//        if(msgCheck.get(Agreement.MSG_HEAD_FORWORDTYPE).equals(1)){
//            /* 1对1 */
//            String receiveId = msgCheck.get(Agreement.MSG_HEAD_OOO).toString();
//            Endpoint endpoint = webSocketMap.get(receiveId);
//            try {
//                endpoint.sendMessage(msg);
//            }catch (Exception e){
//                log.error("发送消息时发生异常 ",e);
//            }
//        }else if(msgCheck.get(Agreement.MSG_HEAD_FORWORDTYPE).equals(2)){
//            /* 优化空间：群组关系持久化 */
//            /* 1对多 */
//            String groupId = msgCheck.get(Agreement.MSG_HEAD_OTM).toString();
//            List<Endpoint> endpoints = group.get(groupId);
//            for(Endpoint e: endpoints){
//                try {
//                    e.sendMessage(msg);
//                }catch (Exception e1){
//                    log.error("发送群组消息时发生异常",e1);
//                }
//            }
//
//        }

        for(Endpoint endpoint:webSocketSet){
            try{
                endpoint.sendMessage(message);
            }catch (Exception e){
                log.error("发消息时发生异常：{}",e);
            }
        }

    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }




    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        Endpoint.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        Endpoint.onlineCount--;
    }
}