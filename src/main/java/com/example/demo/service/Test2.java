package com.example.demo.service;

/**
 * @author liminghao.
 * @date 2021/11/30
 * @time 16:34
 */
public class Test2 {
    public static void main(String[] args) {
        //这是开发人员B的工作
        BWM b3 = new BWM3Factory().productBWM();
        b3.showInfo();

        BWM b5 = new BWM5Factory().productBWM();
        b5.showInfo();

        BWM b7 = new BWM7Factory().productBWM();
        b7.showInfo();



    }
}
