//package com.yuqijun.localservice.config;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
//import org.elasticsearch.action.bulk.BulkRequest;
//import org.elasticsearch.action.delete.DeleteRequest;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.client.indices.CreateIndexRequest;
//import org.elasticsearch.client.indices.CreateIndexResponse;
//import org.elasticsearch.client.indices.GetIndexRequest;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.reindex.DeleteByQueryRequest;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * @ClassName ESUtil
// * @Description TODO
// * @Author zhujun
// * @Date 2019/8/27 3:56 PM
// * @Version v1.0
// **/
//@Slf4j
//@Component
//public class EsUtil {
//
//    public static RestHighLevelClient client = null;
//    @Value("${spring.es.host}")
//    public String host;
//    @Value("${spring.es.port}")
//    public int port;
//    @Value("${spring.es.username:#{null}}")
//    public String username;
//    @Value("${spring.es.password:#{null}}")
//    public String password;
//
//    @PostConstruct
//    public void init() {
//        try {
//            if (client != null) {
//                client.close();
//            }
//            String[] hosts = host.split(",");
//            HttpHost[] httpHosts = new HttpHost[hosts.length];
//            for (int i = 0; i < hosts.length; i++) {
//                httpHosts[i] = new HttpHost(hosts[i], port, HttpHost.DEFAULT_SCHEME_NAME);
//            }
//                RestClientBuilder builder = RestClient.builder(httpHosts)
//                        .setMaxRetryTimeoutMillis(5 * 60 * 1000); //超时时间设为5分钟
//
//
//            if (password != null) {
//                CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//                credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
//                builder.setHttpClientConfigCallback(f -> f.setDefaultCredentialsProvider(credentialsProvider));
//            }
//            client = new RestHighLevelClient(builder);
//        } catch (Exception e) {
//            log.error("ES 配置类初始化错误！", e);
//            System.exit(0);
//        }
//    }
//
//
//
//    @Bean
//    public RestHighLevelClient getRHLClient() {
//        return client;
//    }
//
//    /**
//     * Description: 判断某个index是否存在
//     *
//     * @param index index名
//     * @return boolean
//     */
//    public boolean indexExist(String index) throws Exception {
//        GetIndexRequest request = new GetIndexRequest(index);
//        request.local(false);
//        request.humanReadable(true);
//        request.includeDefaults(false);
//        return client.indices().exists(request, RequestOptions.DEFAULT);
//    }
//
//
//
//    /*
//     * 创建索引
//     * */
//    private boolean addIndex(String index) throws IOException {
//        CreateIndexRequest request = new CreateIndexRequest(index);
//        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
//        if(log.isDebugEnabled()){
//            log.debug("消费者记录耗时创建 ES 索引:{} ", JSONObject.toJSONString(createIndexResponse));
//        }
//
//        return true;
//    }
//
//    /**
//     * Description: 批量插入数据 无id
//     * 插入空list 会报  Validation Failed: 1: no requests added
//     * @param list  带插入列表
//     */
//
//
//
//    /**
//     * Description: 批量删除
//     *
//     * @param index  index
//     * @param idList 待删除列表
//     */
//
//
//    /**
//     * Description: 搜索
//     *
//     * @param index   index
//     * @param builder 查询参数
//     * @param c       结果类对象
//     * @return java.util.ArrayList
//     */
//    public <T> List<T> search(String index, SearchSourceBuilder builder, Class<T> c) {
//        SearchRequest request = new SearchRequest(index);
//        request.source(builder);
//        try {
//            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//            SearchHit[] hits = response.getHits().getHits();
//            List<T> res = new ArrayList<>(hits.length);
//            for (SearchHit hit : hits) {
//                res.add(JSON.parseObject(hit.getSourceAsString(), c));
//            }
//            return res;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * Description: 删除index
//     *
//     * @param index index
//     * @return void
//     */
//    public void deleteIndex(String index) {
//        try {
//            client.indices().delete(new DeleteIndexRequest(index), RequestOptions.DEFAULT);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * Description: delete by query
//     *
//     * @param index   index
//     * @param builder builder
//     */
//    public void deleteByQuery(String index, QueryBuilder builder) {
//        DeleteByQueryRequest request = new DeleteByQueryRequest(index);
//        request.setQuery(builder);
//        //设置批量操作数量,最大为10000
//        request.setBatchSize(10000);
//        request.setConflicts("proceed");
//        try {
//            client.deleteByQuery(request, RequestOptions.DEFAULT);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
