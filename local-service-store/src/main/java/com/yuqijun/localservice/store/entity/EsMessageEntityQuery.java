package com.yuqijun.localservice.store.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.util.Date;

@Data

public class EsMessageEntityQuery implements Serializable {
    /**
     * 唯一主键
     */
    private String id;

    /**
     * 消息id
     */
    private String msgId;

    /**
     * 消息类型
     */
    private String msgType;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String receiver;

    /**
     * 接收时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date receiveTime;

    /**
     * 开始发送时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startSendTime;


    /**
     * 结束发送时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endSendTime;



    /**
     * 消息状态，0 未发送，1 已发送
     */
    private Integer status;

    /**
     * 消息体json字符串
     */
    private String msgContent;

    /**
     * 消息发送错误信息
     */
    private String error;

    /**
     * 其它信息，比如第三方响应信息
     */
    private String remark;
}
