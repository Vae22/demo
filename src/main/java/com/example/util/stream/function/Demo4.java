package com.example.util.stream.function;

import java.util.function.Supplier;

/**
 * @author liminghao.
 * @date 2022/7/10
 * @time 12:25
 */
public class Demo4 {
    public static void main(String[] args) {
//        Supplier<Integer> supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                System.out.println("get()");
//                return 1024;
//            }
//        };

        Supplier<Integer> supplier = () -> {return 1024;};
        System.out.println(supplier.get());
    }
}
