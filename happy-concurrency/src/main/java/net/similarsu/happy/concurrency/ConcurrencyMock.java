package net.similarsu.happy.concurrency;

import lombok.extern.slf4j.Slf4j;
import net.similarsu.happy.core.annotations.NoThreadSafe;

import java.util.concurrent.*;

/**
 * a tools for mock concurrency environment
 * @author similarsu(similarsu@qq.com)
 * @version 1.0.0
 * @since 2018
 */
@NoThreadSafe
@Slf4j
public class ConcurrencyMock {
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
                    log.error("{}",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executor.shutdown();
        log.info("count={}",count);

    }

    public static void add(){
        count ++;
    }
}
