package com.github.tcwloy.designpattern.singleton;

import java.util.concurrent.TimeUnit;

/**
 * 双检锁方式
 * 还有一种变种，代码块加锁
 * 优点：线程安全 延迟加载
 * 缺点：实现繁琐
 */
public class Singleton4 {
    private static Singleton4 ourInstance;

    public static Singleton4 getInstance() {
        System.out.println("Singleton4 getInstance");
        if (null == ourInstance) {
            synchronized(Singleton4.class) {
                try {
                    TimeUnit.SECONDS.sleep(1);//方便多线程访问时测试
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (null == ourInstance) {
                    ourInstance = new Singleton4();
                }
            }
        }
        return ourInstance;
    }

    private Singleton4() {
        System.out.println("Singleton4 init");
    }
}
