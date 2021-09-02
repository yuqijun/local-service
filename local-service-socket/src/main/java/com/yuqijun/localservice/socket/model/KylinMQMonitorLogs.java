//package com.yuqijun.localservice.socket.model;
//
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//@Data
//@Document(indexName = "template",type = "kylinmqmonitorlogs")
////@ApiModel(value = "KylinMQMonitorLogs",description = "RabbitMQ 消费者简要日志实体类")
//public class KylinMQMonitorLogs {
//
//    @Id
////    @ApiModelProperty(name = "id",value = "唯一编号")
//    private String id;
//
//    @Field(type = FieldType.Keyword)
////    @ApiModelProperty(name = "queueName",value = "队列名称")
//    private String queueName;
//
//    @Field(type = FieldType.Long)
////    @ApiModelProperty(name ="cost",value = "消费者执行耗时")
//    private Long cost;
//
//    @Field(type = FieldType.Date)
////    @ApiModelProperty(name = "createTime",value = "开始消费信息的时间点")
//    private Long createTime;
//
//    @Field(type = FieldType.Keyword)
////    @ApiModelProperty(name = "appId",value = "系统编号")
//    private String appId;
//
//    @Field(type = FieldType.Keyword)
////    @ApiModelProperty(name = "state",value = "消费状态")
//    private String state;
//}
