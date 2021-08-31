//package com.yuqijun.localservice.socket.nio.version2;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class  FormatMsg {
//
//    private final static String PACKAMSG = "receiveIp";
//
//    private final static String MSG = "MSG";
//
//    private final static String division1 = ":-:";
//
//    /* 键值对分隔符 */
//    private final static String division2 = ":--:";
//
//
//    /* 解析接收到的信息 */
//    public static String getMsg(String content){
//        Map<String,Object> map = covers(content);
//        return map.get(MSG).toString();
//    }
//
//    /* 包装要发送的信息 */
//    public static String packMsg(String content,String receiveIp){
//        String data = PACKAMSG.concat(division1).concat(receiveIp).concat(division2).concat(MSG).concat(division1).concat(content);
//        return data;
//    }
//
//    public static Object getMsgType(String content){
//        return null;
//    }
//
//    /* 获取消息接受者的信息 */
//    public static String getReceiveMsg(String content){
//        Map<String, Object> covers = covers(content);
//        if(covers.size()<1){
//            return null;
//        }
//        return covers.get(PACKAMSG).toString();
//    }
//
//    private static Map<String,Object> covers(String content){
//        List<String> list = Arrays.asList(content.split(division2));
//        Map<String,Object> map = new HashMap<>();
//        for(String str : list){
//            String [] temp = str.split(division1);
//            if(temp.length<2){
//                continue;
//            }
//            map.put(temp[0],temp[1]);
//        }
//        return map;
//    }
//
//}
