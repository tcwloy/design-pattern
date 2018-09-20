package com.github.tcwloy.designpattern.singleton;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Singleton3Test {

    @Test
    public void testSingleton(){
        Singleton3 rel1 = Singleton3.getInstance();
        Singleton3 rel2 = Singleton3.getInstance();
        System.out.println(rel1 == rel2);
    }

    @Test
    public void testSingletonThread() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Singleton3.getInstance());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }
}
