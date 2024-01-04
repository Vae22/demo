package com.example.demo.service;

/**
 * 宝马车的产品接口（抽象产品）
 * @author liminghao.
 * @date 2021/11/30
 * @time 16:14
 */
public interface BWM {
    //产品的信息介绍
    //车的发动方式
    void showInfo();
}

/**
 * 构建具体车的类（具体产品）
 */
class BWM3i implements BWM {

    @Override
    public void showInfo() {
        System.out.println("这个是宝马3系车喔");
    }
}


class BWM5 implements BWM {

    @Override
    public void showInfo() {
        System.out.println("这个是宝马5系车");
    }
}

class BWM7 implements BWM {

    @Override
    public void showInfo() {
        System.out.println("这个是宝马7系车");
    }
}
