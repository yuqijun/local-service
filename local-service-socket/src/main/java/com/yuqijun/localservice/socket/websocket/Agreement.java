package com.yuqijun.localservice.socket.websocket;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Agreement {

    public final static String MSG_HEAD_OOO = "ooo";  //1

    public final static String MSG_HEAD_OTM = "otm";  //2

    public final static String MSG_HEAD_CONTENT  = "content";

    public final static String MSG_HEAD_FORWORDTYPE = "forwardType";

    /* 协议头分隔符 */
    public static String  HEAD_SEPARATOR  = ":@SEPARATOR@:";

    /* 协议头键值对分隔符 */
    public static String K_V_SEPARATOR = ":-SEPARATOR-:";


    /*
    * 必须有 content并且有值
    * 必须有 MSG_HEAD_OOO 或者 MSG_HEAD_OTM 并且value必须有值
    * */
    public static Map<String,Object> msgCheck(String content){
        Map<String, Object> parse = parse(content);
        if(parse.get(MSG_HEAD_CONTENT)!=null && parse.get(MSG_HEAD_CONTENT).toString().length()>0
                && (null != parse.get(MSG_HEAD_OOO ) ||  null != parse.get(MSG_HEAD_OTM))
        ){
            if(null != parse.get(MSG_HEAD_OOO)){
                parse.put(MSG_HEAD_FORWORDTYPE,1);
            }else{
                parse.put(MSG_HEAD_FORWORDTYPE,2);
            }
            return parse;
        }

        return null;

    }

    public static String getMessage(String content){
        if("".equals(content)){
            return null;
        }
        return getMsgHead(MSG_HEAD_CONTENT,content);
    }




    private static String getMsgHead(String headName,String content){
        Map<String, Object> heads = parse(content);
        return heads.get(headName)==null?null:heads.get(headName).toString();
    }


    /*
    *  返回消息头 键值对
    * */
    private static Map<String,Object>  parse (String content){
        Map<String,Object> map = new HashMap<>();
        String  [] temp = content.split(HEAD_SEPARATOR);
        if(temp.length < 2){
            return null;
        }

        for(int i = 0 ; i < temp.length ; i++ ){
            String [] temp2 = temp[i].split(K_V_SEPARATOR);
            if(temp2.length<2){
                map.put(temp2[0],null);
            }else if(temp2.length == 2){
                map.put(temp2[0],temp2[1]);
            }else{
                log.warn("解析消息协议时发现异常： 消息头键值对 :{}",temp[i]);
            }
        }
        return map;
    }
}
