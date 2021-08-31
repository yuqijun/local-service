package com.yuqijun.localservice.model;

//import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@ApiModel(value = "ResponseResult",description = "Api响应实体")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ResponseResult <T>{

    private int code;

    private String msg;

    private T data;

}
