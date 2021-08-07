package com.yuqijun.socket.nio.version1.core;

import java.io.Closeable;

public interface Receiver extends Closeable {
    boolean receiveAsync(IoArgs.IoArgsEventListener listener);
}
