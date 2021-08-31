//package com.yuqijun.localservice.socket.nio.version2;
//
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import sun.misc.BASE64Encoder;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.ServerSocketChannel;
//import java.nio.channels.SocketChannel;
//import java.security.NoSuchAlgorithmException;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//@Component
//@Slf4j
//public class Handler {
//
//    private Selector selector;
//
//    private ByteBuffer buffer =  ByteBuffer.allocate(256);
//
//    /* 在线客户列表 */
//    public static Map<String,SocketChannel> clientInLine = new HashMap<>();
//
//    @Bean
//    private void start() {
//        try {
//            Thread thread = new Thread(getTask());
//            thread.start();
//            log.info("服务端 SOCKET 开启");
//        }catch (IOException e){
//            log.error("客户端处理TCP通信发生异常:",e);
//        }
//    }
//
//
//    private Runnable getTask() throws IOException {
//
//
//        selector  = ClientSelector.getInstance();
//
//        Connector.initServerSocketChannel(selector);
//        log.info("初始化服务端ServerSocketChannel");
//
//        Runnable task = new Runnable() {
//            @SneakyThrows
//            @Override
//            public void run() {
//
//                while(true){
//                    /* 判断是否有就绪事件 */
//                    if(selector.select() == 0){
//                        continue;
//                    }
//
//                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
//                    while(iterator.hasNext()){
//                        SelectionKey next = iterator.next();
//
//                        /* 处理事件 */
//                        handlerAdepter(next);
//                        iterator.remove();
//                    }
//                }
//            }
//        };
//        return task;
//    }
//
//    private void handlerAdepter(SelectionKey key){
//            if (key.isAcceptable()) {
////                log.info("「 客户端 」" + ((ServerSocketChannel) key.channel()).accept().getRemoteAddress() + " 尝试连接服务端");
//                acceptHandler(key);
//            } else if (key.isReadable()) {
////                log.info("「 客户端 」" + ((ServerSocketChannel) key.channel()).accept().getRemoteAddress()  + " 发送至服务端一条数据");
//                readHandler(key);
//            }
//
//
//    }
//
//    private void acceptHandler(SelectionKey key){
//        try {
//            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
//            SocketChannel accept = serverSocketChannel.accept();
//
////            accept.setOption(StandardSocketOptions.SO_KEEPALIVE,Boolean.TRUE);
//
//
//            log.info("「 客户端 」" + accept.getLocalAddress() + " 尝试连接服务端");
//
//            accept.configureBlocking(false);
//            accept.register(selector,SelectionKey.OP_READ);
//
//            /* 将Ip为key， SocketChannel为value 存入 clientInLine */
//            clientInLine.put(accept.getRemoteAddress().toString(),accept);
//
//
//            boolean b = accept.finishConnect();
//
//            log.info("「 客户端 」"+accept.getLocalAddress()+" 已加入在线客户列表 , 结束连接？ {} , 是否KEEP-ALIVE",b,accept.socket().getKeepAlive());
//        }catch (IOException e){
//            log.error("服务端处理连接时发生异常:",e);
//        }
//
//    }
//
//    private void readHandler(SelectionKey key){
//
////        ByteBuffer buffer = ByteBuffer.allocate(256);
//
//        try {
//            /* 获取SocketChannel */
//            SocketChannel socketChannel = (SocketChannel) key.channel();
//            /* 读取信息 */
//            int flag;
//            if (0 < (flag = socketChannel.read(buffer))) {
//                buffer.flip();
//                byte [] bytes = new byte[buffer.remaining()];
//                buffer.get(bytes);
//
//                String str = new String (bytes);
//                log.info("receiveMsg:"+str);
//
//
//                /* 解析出 sec-key */
//
////                version1
//                if(str.startsWith("ket")||str.startsWith("\nOrigin")) {
////                    log.info("开始建立websocket握手 接收到的握手信息：{} ",str);
////                    socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE,Boolean.TRUE);
////                    Map<String, Object> requestInfo = getRequestInfo(str);
////                    String parse = requestInfo.get("Sec-WebSocket-Key").toString().trim();
////                    String guid = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
////                    String secKey = parse + guid;
////                    secKey  = secKey.replaceAll("\\r","").replaceAll("\\n","");
////                    log.info("secKey :"+secKey);
////                    String s = DigestUtils.shaHex(secKey);
////                    log.info("SHA1:"+s);
////                    final Base64.Encoder encoder = Base64.getEncoder();
////                    String encodedText = encoder.encodeToString(s.getBytes());
////                    String update = "HTTP/1.1 101 Switching Protocols\r\n" +
////                            "Upgrade: websocket\r\n" +
////                            "Sec-WebSocket-Version: 13\r\n" +
////                            "Connection: Upgrade\r\n" +
////                            "Sec-WebSocket-Accept: " + encodedText + "\r\n";
//////                            "Sec-WebSocket-Protocol: chat\r\n\r\n";
////
////                    ByteBuffer buffer = ByteBuffer.allocate(1024);
////                    buffer.put(update.getBytes());
////                    socketChannel.write(buffer);
////
////                    log.info("响应了客户端:"+update);
//
//
////
//                    log.info("开始建立websocket握手 接收到的握手信息：{} ",str);
//                    String responseHeader = getResponseHeader(str.getBytes());
//                    log.info("响应了客户端：\r\n"+responseHeader);
//                    ByteBuffer buffer = ByteBuffer.allocate(1024);
//                    buffer.clear();
//                    buffer.put(responseHeader.getBytes());
//                    socketChannel.socket().setKeepAlive(true);
//                    socketChannel.write(buffer);
//
//
//
//
//
//                }
//
//
//
//
//
//
//                /* 解析信息 */
//               String receiveIp = FormatMsg.getReceiveMsg(str);
//               if(null == receiveIp){
//                   log.warn("无效信息扔出"+str);
//                   buffer.clear();
//                }
////               String realContent = FormatMsg.getMsg(str);
//
//                /* 转发信息 */
////                SocketChannel receiveSocketChannel = clientInLine.get(receiveIp);
////                buffer.clear();
////                buffer.put(bytes);
////                receiveSocketChannel.write(buffer);
//
//
//
//                /* 将消息投递到 Rabbit MQ 队列
//                *
//                *
//                * */
//
//
//
//            }
//
//        }catch (IOException e){
//            log.error("服务端在处理读取socketChannel信息时发生异常：",e);
//        }
//
//    }
//
//    private Map<String,Object> getRequestInfo(String content){
//        content = content.replaceAll("\\n","");
//        String [] temp  = content.split("\\r");
//        Map<String,Object> map = new HashMap<>();
//        for(int i= 0 ; i < temp.length ; i++){
//            String [] itemp = temp[i].split(":");
//            if(itemp.length>1) {
//                map.put(itemp[0], itemp[1]);
//            }
//        }
//        return  map;
//    }
//
//    public static void main(String [] args){
//        String s = " Ow5JH1q7vOKmdTWq4Lu01Q==258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
//        String s1 = DigestUtils.shaHex(s);
//        System.out.println("加密："+s1);
//
//    }
//
//    public static String base64Encode(byte[] input) {
//        BASE64Encoder encoder = new BASE64Encoder();
//        String base64 = encoder.encode(input);
//        return base64;
//    }
//
//
//
//     public String getResponseHeader (byte [] data ) {
//
//
//         String requestHeader = new String ( data ) ;
//         requestHeader = requestHeader . substring ( 0 , requestHeader . indexOf ( "\r\n\r\n" ) ) ;
//         String [ ] reqarr = requestHeader . split ( "\r\n" ) ;
//         Map<String,String> reqHeader = new HashMap < String , String > ( ) ;
//         for ( int i = 0 ; i < reqarr . length ; i ++ ) {
//             String requestHeaderLine = reqarr [ i ] ;
//             if ( requestHeaderLine . toUpperCase ( ) . startsWith ( "GET" ) || requestHeaderLine . toUpperCase ( ) . startsWith ( "POST" ) ) {
//                 String [ ] first = requestHeaderLine . split ( " " ) ;
//                 if ( first . length == 3 ) {
//                     String method = first [ 0 ] ;
//                     String location = first [ 1 ] . replaceAll ( "\\s" , "" ) ;
//                     String protocol = first [ 2 ] . split ( "/" ) [ 0 ] ;
//                     String protocolVersion = first [ 2 ] . split ( "/" ) [ 1 ] ;
//                     reqHeader . put ( "Method" , method ) ;
//                     reqHeader . put ( "Location" , location ) ;
//                     reqHeader . put ( "Protocol" , protocol ) ;
//                     reqHeader . put ( "ProtocolVersion" , protocolVersion ) ;
//                 }
//             } else {
//                 String [ ] reqlinearr = requestHeaderLine . split ( ":" ) ;
//                 if ( reqlinearr . length == 2 ) {
//                     String key = reqlinearr [ 0 ] ;
//                     String value = reqlinearr [ 1 ] . replaceAll ( "\\s" , "" ) ;
//                     reqHeader . put ( key , value . replaceAll ( "\\s" , "" ) ) ;
//                 }
//             }
//         }
//
//
//
//        String originKey = reqHeader.get ( "Sec-WebSocket-Key" ) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11" ;
//        java . security . MessageDigest alga = null ;
//        byte [ ] digesta = null ;
//        try {
//            alga = java . security . MessageDigest . getInstance ( "SHA-1" ) ;
//            alga . update ( originKey . getBytes ( ) ) ;
//            digesta = alga . digest ( ) ;
//            } catch ( NoSuchAlgorithmException e ) {
//                e . printStackTrace ( ) ;
//            }
//        byte [ ] respKey = org.apache .commons.codec.binary.Base64.encodeBase64 ( digesta ) ;
//         String header = "HTTP/1.1 101 Switching Protocols\r\n" +
//            "Upgrade: Websocket\r\n" +
//            "Connection: Upgrade\r\n" +
//            "Sec-WebSocket-Accept: " + new String ( respKey ) + "\r\n\r\n" ;
//             return header ;
//    }
//
//}
