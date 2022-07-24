package com.yuqijun.localservice.store.service.impl;


//import com.yuqijun.localservice.store.dao.EsMessageRecordMapper;
import com.yuqijun.localservice.store.entity.EsMessageEntity;
import com.yuqijun.localservice.store.entity.EsMessageEntityQuery;
import com.yuqijun.localservice.store.service.IEsMessageRecordService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value = "esMessageRecordServiceImpl")
@Component
public class EsMessageRecordServiceImpl implements IEsMessageRecordService {

//    @Autowired
//    private EsMessageRecordMapper esMessageRecord;

//    @Override
//    public Iterable<EsMessageEntity> getRecord(EsMessageEntityQuery query) {
//
//        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
//        if(null  != query.getId()){
//            queryBuilder.must(QueryBuilders.termQuery("id", query.getId()));
//        }
//
//        if(null != query.getMsgId()){
//            queryBuilder.must(QueryBuilders.termQuery("msgId", query.getMsgId()));
//        }
//
//        if(null != query.getSender()){
//            queryBuilder.must(QueryBuilders.termQuery("sender", query.getSender()));
//        }
//
//        if(null != query.getReceiver()){
//            queryBuilder.must(QueryBuilders.termQuery("receiver", query.getReceiver()));
//        }
//
//        if(null != query.getStatus()){
//            queryBuilder.must(QueryBuilders.termQuery("status",query.getStatus()));
//        }
//
//        if(null != query.getMsgContent()){
//            queryBuilder.must(QueryBuilders.termQuery("msgContent",query.getMsgContent()));
//        }
//
//        if(null != query.getError()){
//            queryBuilder.must(QueryBuilders.termQuery("error",query.getError()));
//        }
//
//        if(null != query.getRemark()){
//            queryBuilder.must(QueryBuilders.termQuery("remark",query.getRemark()));
//        }
//
//        return esMessageRecord.search(queryBuilder);
//    }

//    @Override
//    public EsMessageEntity insert(EsMessageEntity entity) {
//        return esMessageRecord.save(entity);
//    }

    @Bean
    public void tippppppppp(){
        log.info("es 服务层被扫入容器");
    }
}
