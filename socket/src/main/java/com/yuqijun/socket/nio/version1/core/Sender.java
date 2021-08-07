package com.yuqijun.socket.nio.version1.core;

import java.io.Closeable;

public interface Sender extends Closeable {
    boolean sendAsync(IoArgs.IoArgsEventListener listener);
}
