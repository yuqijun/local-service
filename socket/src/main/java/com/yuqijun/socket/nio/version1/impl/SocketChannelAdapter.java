package com.yuqijun.socket.nio.version1.impl;

import com.yuqijun.socket.nio.version1.core.IoArgs;
import com.yuqijun.socket.nio.version1.core.Receiver;
import com.yuqijun.socket.nio.version1.core.Sender;

import java.io.Closeable;
import java.io.IOException;

public class SocketChannelAdapter implements Receiver, Sender, Closeable {
    @Override
    public boolean receiveAsync(IoArgs.IoArgsEventListener listener) {
        return false;
    }

    @Override
    public boolean sendAsync(IoArgs.IoArgsEventListener listener) {
        return false;
    }

    @Override
    public void close() throws IOException {

    }
}
