package com.yuqijun.socket.nio.version1.impl;

import com.yuqijun.socket.nio.version1.core.IoProvider;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public class IoSelectorProvider implements IoProvider {
    @Override
    public boolean registerInput(SocketChannel socketChannel, HandlerInputCallback handlerInputCallback) {
        return false;
    }

    @Override
    public boolean registerOutput(SocketChannel socketChannel, HandlerOutputCallback handlerOutputCallback) {
        return false;
    }

    @Override
    public void unRegisterInput(SocketChannel socketChannel) {

    }

    @Override
    public void unRegisterOutput(SocketChannel socketChannel) {

    }

    @Override
    public void close() throws IOException {


    }
}
