package com.github.tcwloy.designpattern.singleton;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Singleton1Test {

    @Test
    public void testSingleton1(){
        Singleton1 rel1 = Singleton1.getInstance();
        Singleton1 rel2 = Singleton1.getInstance();
        System.out.println(rel1 == rel2);
    }

    @Test
    public void testSingleton1Thread() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Singleton1.getInstance());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }
}
