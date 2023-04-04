package com.example.demo.function;

import java.util.function.Predicate;

/**
 * @author liminghao.
 * @date 2022/7/10
 * @time 11:31
 */
public class Demo2 {
    public static void main(String[] args) {
        // 判断字符串是否为空
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };

        // 一个输入参数，返回一个 boolbean值
        Predicate<String> predicate = p -> p.isEmpty();
        System.out.println(predicate.test("123"));
    }
}
