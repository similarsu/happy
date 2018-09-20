package net.similarsu.happy.concurrent;

import net.similarsu.happy.core.annotations.NoThreadSafe;

import java.util.concurrent.*;

/**
 * a tools for mock concurrent environment
 * @author similarsu(similarsu@qq.com)
 * @version 1.0.0
 * @since 2018
 */
@NoThreadSafe
public class ConcurrentMock {
    private static int clientNums = 2000;
    private static int threadNums = 20;
    private static int count = 0 ;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(clientNums);
        Semaphore semaphore = new Semaphore(threadNums);
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i=0;i<clientNums;i++){
            executor.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executor.shutdown();
        System.out.println(count);

    }

    public static void add(){
        count ++;
    }
}
