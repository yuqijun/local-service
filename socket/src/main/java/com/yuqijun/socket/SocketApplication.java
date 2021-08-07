package com.yuqijun.socket;


import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableApolloConfig
@MapperScan( "com.yuqijun.socket.dao")
public class SocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(SocketApplication.class, args);
    }
}
