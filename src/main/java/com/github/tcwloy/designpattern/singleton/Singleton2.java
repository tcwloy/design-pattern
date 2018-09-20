package com.github.tcwloy.designpattern.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 懒汉式（非线程安全）
 * 优点：实现简单 可延迟加载
 * 缺点：非线程安全
 */
public class Singleton2 {
    private static Singleton2 ourInstance;

    public static Singleton2 getInstance() {
        System.out.println("Singleton2 getInstance");
        try {
            TimeUnit.SECONDS.sleep(1);//方便多线程访问时测试
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (null == ourInstance){
            ourInstance = new Singleton2();
        }
        return ourInstance;
    }

    private Singleton2() {
        System.out.println("Singleton2 init");
    }
}
