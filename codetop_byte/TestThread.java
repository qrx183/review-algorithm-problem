package codetop_byte;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
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
                System.out.println("hh");
            }
        });
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };
        Lock reentrantLock = new ReentrantLock();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        CountDownLatch count = new CountDownLatch(2);
        Semaphore semaphore = new Semaphore(10);
        AtomicInteger atomicInteger = new AtomicInteger(10);
        int a = atomicInteger.addAndGet(1);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hh");
            }
        },100);
        System.out.println(a);
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ThreadLocal<Integer> tt = new ThreadLocal<>();
    }
}
