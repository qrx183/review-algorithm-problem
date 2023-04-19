package codetop_byte.q0417;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestThread {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,100, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                // 待处理的任务
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        Lock reentrantLock = new ReentrantLock();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        CountDownLatch count = new CountDownLatch(2);



    }
}
