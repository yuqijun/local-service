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
@Document(indexName = "message_record_20220510")
public class EsMessageEntity implements Serializable {
    /**
     * 唯一主键
     */
    @Id
    @Field(type = FieldType.Text)
    private String id;

    /**
     * 消息id
     */
    @Field(type = FieldType.Text)
    private String msgId;

    /**
     * 消息类型
     */
    @Field(type = FieldType.Text)
    private String msgType;

    /**
     * 发送者
     */
    @Field(type = FieldType.Text)
    private String sender;

    /**
     * 接收者
     */
    @Field(type = FieldType.Text)
    private String receiver;

    /**
     * 接收时间
     */
    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String receiveTime;

    /**
     * 发送时间
     */
    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String sendTime;

    /**
     * 消息状态，0 未发送，1 已发送
     */
    @Field(type = FieldType.Integer)
    private Integer status;

    /**
     * 消息体json字符串
     */
    @Field(type = FieldType.Text)
    private String msgContent;

    /**
     * 消息发送错误信息
     */
    @Field(type = FieldType.Text)
    private String error;

    /**
     * 其它信息，比如第三方响应信息
     */
    @Field(type = FieldType.Text)
    private String remark;
}
