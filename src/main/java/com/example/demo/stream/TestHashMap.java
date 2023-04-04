package com.example.demo.stream;

import java.util.HashMap;

/**
 * @author liminghao.
 * @date 2022/7/13
 * @time 15:40
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        String s = hashMap.put("张三", "123");
//        String s1 = hashMap.put("李四", "123");
        String s2 = hashMap.put("张三", "123456");

        hashMap.forEach((k,v)->{
            System.out.println("键为:" + k + " 值为:" + v);
        });
    }
}
