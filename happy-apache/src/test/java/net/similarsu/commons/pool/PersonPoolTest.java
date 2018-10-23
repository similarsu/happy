package net.similarsu.commons.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class PersonPoolTest {
    GenericObjectPool<Person> personGenericObjectPool =null;

    @Before
    public void setup(){
        PersonFactory personFactory = new PersonFactory();
        GenericObjectPoolConfig<Person> genericObjectPoolConfig = new GenericObjectPoolConfig<>();
        genericObjectPoolConfig.setMaxTotal(10);
        genericObjectPoolConfig.setMaxWaitMillis(5);
        personGenericObjectPool =new GenericObjectPool<>(personFactory,genericObjectPoolConfig);
    }


    @Test
    public void test(){
        CountDownLatch countDownLatch = new CountDownLatch(100);
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.rangeClosed(1,100).forEach((i) ->{
            executorService.execute(() -> {
                Person person = null;
                try {
                    person = personGenericObjectPool.borrowObject();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if( null != person){
                        personGenericObjectPool.returnObject(person);
                    }
                    countDownLatch.countDown();
                }
            });
        });

        executorService.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
