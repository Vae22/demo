package com.example.demo.function;

import java.util.function.Consumer;

/**
 * @author liminghao.
 * @date 2022/7/10
 * @time 12:12
 */
public class Demo3 {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        // 一个输入参数，无返回值
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("12345");
    }
}
