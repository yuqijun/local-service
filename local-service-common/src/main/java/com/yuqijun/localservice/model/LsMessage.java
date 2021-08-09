package com.yuqijun.localservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LsMessage {

    /* 消息id(编号)唯一主键 */
    private String id ;

    /* 消息发送者身份标示的唯一id */
    private String senderId;

    /*  消息接受者身份标示的唯一id */
    private String receiveId;

    /* 消息发送者的昵称 */
    private String senderNickname;

    /* 消息接受者的昵称 */
    private String receiveNickName;

    /* 消息发送的时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime sendTime;
}
