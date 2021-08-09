package com.yuqijun.localservice.consumer.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.yuqijun.localservice.model.LsMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.io.IOException;
import  com.yuqijun.localservice.consumer.service.*;
import javax.annotation.Resource;

//@RabbitListener()
@Slf4j
@Component
public class SaveMessageConsumer {

    @Resource
    private ILsMessageService messageService;

    @RabbitListener(queuesToDeclare =@Queue("saveMessageQueue"),concurrency = "100")
    public void onMessage(Message message , Channel channel) {

        log.info("进入消息队列");

        try {
            /* 反序列化message为Java对象 */
            LsMessage msg = getMessage(message);

            /* 执行sql保存记录 */
            messageService.save(msg);

        }catch (IOException e){
            log.error("通信记录入库时发生异常：",e);
        }
    }

    /* 反序列化方法 */
    private LsMessage getMessage(Message message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        LsMessage msg  =(LsMessage)objectMapper.readValue(new String(message.getBody()).getBytes(),LsMessage.class);
        return msg;
    }
}
