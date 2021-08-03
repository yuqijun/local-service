package com.yuqijun.socket.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.collections.ConcurrentCache;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

@Slf4j
/* java四种引用Demo
*  JVM 参数 -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails
 * */
public class Demo3 {
//    /* 强引用 */
//    public static void main(String [] args){
//        /* list存储对象为21M超过JVM设定的20M最大对内存(新生代和老年代都被挤满且无法回收)，所以会抛出OOM。 需要注意的是运行一个最简单的java程序本身也会占用一定的内存 */
//        log.info("Demo3...");
//        List<Object> list = new LinkedList<>();
//        for(int i = 0 ; i < 21 ; i++){
//            list.add(new byte[1024*1024]);
//        }
//    }

    /* 软引用 */
    public static void main(String [] args) throws InterruptedException {
        Thread.sleep(10000);
        /* 理论上当进行到第11个的时候会进行一次 GC将前面的软引用对象回收，这样就有空间容纳第11个，依次类推，所以没有抛出OOM */
        List<Object>list = new LinkedList<>();
        for(int i = 0 ; i < 21 ; i ++){
            Thread.sleep(10000);
            SoftReference<byte[]> sf = new SoftReference<>(new byte[1024*1024]);
            list.add(sf);
        }
    }

}
