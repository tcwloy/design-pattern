package com.github.tcwloy.designpattern.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 饿汉方式（线程安全）
 * 还有一种变种，静态代码块方式
 * 优点：实现简单 线程安全
 * 缺点：如果实例化对象包含耗时操作，会影响启动时长
 */
public class Singleton1 {
    private static Singleton1 ourInstance = new Singleton1();

    public static Singleton1 getInstance() {
        System.out.println("Singleton1 getInstance");
        try {
            TimeUnit.SECONDS.sleep(1);//方便多线程访问时测试
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ourInstance;
    }

    private Singleton1() {
        System.out.println("Singleton1 init");
    }
}
