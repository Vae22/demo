package com.example.util.stream.function;

import java.util.function.Function;

/**
 * @author liminghao.
 * @date 2022/7/9
 * @time 16:02
 */
public class Demo1 {
    public static void main(String[] args) {
        // 工具类：输出输入的值
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };

        // 一个输入参数，一个返回值
        Function<String, String> function = s -> {return s;};
        System.out.println(function.apply("路明非"));
    }
}
