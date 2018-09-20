package com.github.tcwloy.designpattern.singleton;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Singleton5Test {

    @Test
    public void testSingleton(){
        Singleton5 rel1 = Singleton5.getInstance();
        Singleton5 rel2 = Singleton5.getInstance();
        System.out.println(rel1 == rel2);
    }

    @Test
    public void testSingletonThread() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Singleton5.getInstance());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }
}
