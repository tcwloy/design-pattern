package com.github.tcwloy.designpattern.singleton;

/**
 * 静态内部类方式
 * 优点：线程安全 延迟加载 实现简单
 */
public class Singleton5 {

    private static class Singleton5Holder{
        private static Singleton5 instance = new Singleton5();
    }

    private Singleton5(){
        System.out.println("Singleton5 init");
    }

    public static Singleton5 getInstance() {
        System.out.println("Singleton5 getInstance");
        return Singleton5Holder.instance;
    }
}
