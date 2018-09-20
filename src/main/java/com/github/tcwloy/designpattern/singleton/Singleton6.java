package com.github.tcwloy.designpattern.singleton;

/**
 * 枚举方式
 * 优点：线程安全 实现简单
 * 缺点：非延迟加载
 */
public enum Singleton6 {
    INSTANCE;
    private Singleton6(){
        System.out.println("Singleton6 init");
    }
    public void execute(){
        System.out.println("Singleton6 execute");
    }
}
