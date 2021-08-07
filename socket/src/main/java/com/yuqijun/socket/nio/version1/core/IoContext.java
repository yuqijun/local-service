package com.yuqijun.socket.nio.version1.core;

import java.io.Closeable;
import java.io.IOException;

/* io上下文，单例模式 */
public class IoContext implements Closeable {

    /* io单例对象 */
    private static IoContext INSTANCE;

    private final IoProvider ioProvider;

    public IoContext(IoProvider ioProvider){
        this.ioProvider = ioProvider;
    }

    public static IoContext get(){
        return INSTANCE;
    }

    public IoProvider getIoProvider(){return ioProvider;}

    public static StartedBoot setup(){return new StartedBoot();}
    @Override
    public void close() throws IOException {
        ioProvider.close();
    }

    /*  ??
    * */
    public static class StartedBoot {

        private IoProvider ioProvider;

        private StartedBoot(){}

        public StartedBoot(IoProvider ioProvider){
            this.ioProvider = ioProvider;
        }

        public IoContext start(){
            INSTANCE = new IoContext(ioProvider);
            return INSTANCE;
        }
    }
}
