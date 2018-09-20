package com.github.tcwloy.designpattern.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 懒汉式方法加锁
 * 还有一种变种，代码块加锁
 * 优点：实现简单 线程安全 延迟加载
 * 缺点：并发效率低
 */
public class Singleton3 {
    private static Singleton3 ourInstance;

    public static synchronized Singleton3 getInstance() {
        System.out.println("Singleton3 getInstance");
        try {
            TimeUnit.SECONDS.sleep(1);//方便多线程访问时测试
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (null == ourInstance){
            ourInstance = new Singleton3();
        }
        return ourInstance;
    }

    private Singleton3() {
        System.out.println("Singleton3 init");
    }
}
