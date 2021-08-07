package com.yuqijun.socket.nio.version1.core;

import java.io.Closeable;
import java.nio.channels.SocketChannel;

public interface IoProvider extends Closeable {

    /* Description 注册输入流
    *  return boolean
    * */
    boolean registerInput(SocketChannel socketChannel,HandlerInputCallback handlerInputCallback);

    /* Description 注册输出流
    *  return boolean
    *  */
    boolean registerOutput(SocketChannel socketChannel , HandlerOutputCallback handlerOutputCallback);

    /* Description 取消注册输入流
    *  return void
    * */
    void unRegisterInput(SocketChannel socketChannel);

    /* Description 取消注册输出流
    *  return void
    * */
    void unRegisterOutput(SocketChannel socketChannel);

    /* Description 注册输入流的回调类
    *  return
    * */
    abstract class HandlerInputCallback implements Runnable{
        /* Description 回调方法实现
        *  return
        * */
        @Override
        public void run() { canProviderInput();}
        abstract void canProviderInput();
    }

    /* */
    abstract class HandlerOutputCallback implements Runnable{
        /* 附加值 */
        private Object data;

        /* Description 回调方法实现
        *  return
        * */
        @Override
        public void run() { canProviderOutput(data); }
        abstract void canProviderOutput(Object data);
    }

}
