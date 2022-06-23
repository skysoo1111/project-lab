package com.study.javabasic.effective3;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class ConcurrencyExample {

    private static boolean basicStopRequested;
    private static volatile boolean volatileStopRequested;

    private static synchronized void requestStop() {
        basicStopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return basicStopRequested;
    }

    /*
    *  synchronized 메서드를 통해서 동기화를 보장할 수 있다.
    * */
    @Test
    public void synchronizedTest() throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while(!stopRequested()) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }

    /*
    * volatile은 메모리 동기화 or 통신 동기화 라고 하며, 원자성을 보장해주지는 않는다.
    * */
    @Test
    public void volatileTest() throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
           int i = 0;
           while(!volatileStopRequested) {
               i++;
           }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        volatileStopRequested = true;
    }

}
