package com.yuqijun.localservice.model;

public class BaseController<T> {

    public ResponseResult Success(){
        ResponseResult result = new ResponseResult();
        result.setCode(1);
        result.setMsg("请求成功");
        return result;
    }

    public ResponseResult Success(String msg){
        ResponseResult result = new ResponseResult();
        result.setCode(1);
        result.setMsg(msg);
        return result;
    }

    public ResponseResult<T>Success(T t){
        ResponseResult<T> result = new ResponseResult<T>();
        result.setData(t);
        result.setCode(1);
        result.setMsg("请求成功");
        return  result;
    }

    public ResponseResult Fail(){
        ResponseResult result = new ResponseResult();
        result.setCode(0);
        result.setMsg("-系统发生异常");
        return result;
    }

    public ResponseResult Fail(String msg){
        ResponseResult result = new ResponseResult();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }
}
