package com.yuqijun.socket.demo;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class Demo {
    public static void main(String [] args){
        String str1 = "dsfafa";
        String str2 = ".dfafdf";
        String str3 = ".fasf.afdasdf";


        String [] array1  = str1.split("\\.");
        System.out.println("str1 :");


        String [] array2 = str2.split("\\.");
        System.out.println("str2 :");

        String [] array3 = str3.split("\\.");
        System.out.println("str3 :");

    }

    public static void addHeap(){
        byte [] bytes = new byte[1024*1024*5];

    }
}
