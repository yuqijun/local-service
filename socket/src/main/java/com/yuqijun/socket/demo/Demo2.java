package com.yuqijun.socket.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockMultipartFile;
import java.io.*;
import java.util.*;
import org.apache.http.entity.ContentType;
import org.springframework.web.multipart.MultipartFile;


/*
* @AUTHOR  yuqijun
* @DESCRIPTION 分片上传文件DEMO
*  */
@Slf4j
public class Demo2 {
    public static void main(String [] args) throws IOException, InterruptedException {

        RandomAccessFile readRaf = new RandomAccessFile("/Users/yuqijun/yuqijun/temp/one.txt", "rw");
        readRaf.seek(10);

        /* readRaf 每次读取两个字母然后 发送给writeRaf */

        byte [] readBuff = new byte[2];

        String id = "123456789";

        int hashRaf ;

        log.info("readRaf.length:"+(readRaf.length()-10));

        int sendNumber = 0;

        while( (hashRaf = readRaf.read(readBuff))>0){



            sendNumber = sendNumber +2 ;

            if(26 == sendNumber){
                sendNumber = -1;
            }
            log.info(new String(readBuff,0,hashRaf));
            InputStream inputStream = new ByteArrayInputStream(readBuff);
            MockMultipartFile mockMultipartFile = new MockMultipartFile( ContentType.APPLICATION_OCTET_STREAM.toString(),inputStream);


            sendFile(mockMultipartFile,id,sendNumber);
        }
        log.info("程序运行完成");






    }



    private static  Map<String, LinkedList<Map<Integer,MultipartFile>>> listMap = new HashMap<>();


    public static void sendFile(MultipartFile multipartFile,String id , int number ) throws IOException {

        /* 创建1个线程 */

        /* 判断是否是最后一个数据片 */
        HashMap<Integer,MultipartFile> item = new HashMap<>();
        item.put(number,multipartFile);

        if(number!=-1){
            if(null == listMap.get(id)){
                LinkedList list = new LinkedList();
                list.add(item);
                listMap.put(id,list);
            }else{
                listMap.get(id).add(item);
            }
        }else{
            /* 区集合里面将 该id的所有 multipartfile 取出来，按照顺序转换成byte 并且转换成输出流 */
            LinkedList<Map<Integer,MultipartFile>> mapList =  listMap.get(id);

            long totalByteSize = 0 ;

            /* 重新排序  获取总字节大小 */
            for(int i = 0 ; i < mapList.size() ; i++){
                MultipartFile m =(MultipartFile) mapList.get(i).values().toArray()[0];

                totalByteSize = totalByteSize + m.getSize();
                for(int j = i ; j < mapList.size()-1; j++ ){
                    Map<Integer,MultipartFile> temp = null;
                    if(Integer.valueOf(mapList.get(j).keySet().toArray()[0].toString()) > Integer.valueOf(mapList.get(j+1).keySet().toArray()[0].toString())){
                        temp = mapList.get(j);

                        Integer preKey = Integer.valueOf(mapList.get(j+1).keySet().toArray()[0].toString());
                        MultipartFile preMultipartFile = mapList.get(j+1).get(preKey);

                        mapList.get(j).clear();
                        mapList.get(j).put(preKey,preMultipartFile);


                        Integer nextKey = Integer.valueOf(temp.keySet().toArray()[0].toString());
                        MultipartFile nextMultipartFile = temp.get(preKey);
                        mapList.get(j+1).clear();
                        mapList.get(j+1).put(nextKey,nextMultipartFile);

                    }

                }
            }
            Map<Integer, MultipartFile> last = new HashMap<>();
            last.put(-1,multipartFile);
            mapList.addLast(last);
            log.info("排序后的linkedList :"+mapList.toString());
            File outFile = new File("/Users/yuqijun/yuqijun/temp/write.txt");
            OutputStream out = new FileOutputStream(outFile,true);

            log.info("开始写数据到write.txt中");

            for(int i = 1 ; i < mapList.size() ; i ++){
                /* 循环 */
                byte[] bytes = (mapList.get(i).values().toArray()[0].toString()).getBytes();
                InputStream in = new ByteArrayInputStream(bytes);
                int read;
                while(-1!=(read = in.read())){
                    out.write(read);
                }
            }

            log.info("写数据完成");
        }
    }
}
