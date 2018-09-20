package com.github.tcwloy.designpattern.singleton;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class Singleton6Test {

    @Test
    public void testSingleton6(){
        Singleton6 rel1 = Singleton6.INSTANCE;
        Singleton6 rel2 = Singleton6.INSTANCE;
        System.out.println(rel1 == rel2);
    }

    @Test
    public void testSingleton6Thread() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Singleton6.INSTANCE);
                Singleton6.INSTANCE.execute();
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }
}
