package com.yuqijun.socket.server;


import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuqijun
 * 消息传输格式
 */

@ApiModel(value = "MessageFormat",description = "消息传输格式")
@Slf4j
public class MessageFormat {
    /* 格式化 */
    public static String format(String msg,String senderAddress){
        return senderAddress +":-:"+msg;
    }

    public static String parser(String msg){
        if( msg.split(":-:").length>1){
            return msg.split(":-:")[1];
        }
        return "-1";
    }

    public static String [] parserFunction(String msg){
        return  msg.split(":-:");
    }

}
