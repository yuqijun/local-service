package com.yuqijun.socket.nio.version1.core;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/* io工具类 */
public class IoArgs {

    private byte [] byteBuffer = new byte[256];

    private ByteBuffer buffer = ByteBuffer.wrap(byteBuffer);

    /* 将通道中的数据读入buffer */
    public int read (SocketChannel socketChannel)throws IOException {
        buffer.clear();
        return socketChannel.read(buffer);
    }

    /* 将buffer 写入通道 */
    public int write(SocketChannel socketChannel) throws IOException{
        return socketChannel.write(buffer);
    }

    /* 丢弃换行符 */
    public String bufferString(){
        return new String(byteBuffer,0,buffer.position()-1);
    }

    public interface IoArgsEventListener{
        void onStarted(IoArgs ioArgs);

        void onCompleted(IoArgs ioArgs);
    }
}
