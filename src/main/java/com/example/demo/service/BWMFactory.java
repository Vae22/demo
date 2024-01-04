package com.example.demo.service;

/**
 * 汽车生产工厂接口（抽象工厂）
 * @author liminghao.
 * @date 2021/11/30
 * @time 16:19
 */
public interface BWMFactory {
    BWM productBWM();
}

/**
 * 实现具体的车型的生产工厂（具体工厂）
 */
class BWM3Factory implements BWMFactory {

    @Override
    public BWM productBWM() {
        System.out.println("生产宝马3系车");
        System.out.println("改造3系车，定名为BWM3i型号");
        return new BWM3i();
    }
}

class BWM5Factory implements BWMFactory {

    @Override
    public BWM productBWM() {
        System.out.println("生产宝马5系车");
        return new BWM5();
    }
}

class BWM7Factory implements BWMFactory {

    @Override
    public BWM productBWM() {
        System.out.println("生产宝马7系车");
        return new BWM7();
    }
}
