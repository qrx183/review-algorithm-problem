package codetop_byte;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestThread {
    static int cnt = 0;
    static final Object object = new Object();
    static final CountDownLatch count = new CountDownLatch(10);
    // 这个方法相当于是建立一个具有初始值的ThreadLocal. 实际上是通过多态的向上转型,调用的initValue是SuppliedThreadLocal中的方法
    static final ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->"qiuruixiang");

    class A extends B{
        int b = a;

    }
    class B{
       int a;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(1000);
        Thread t = new Thread(() -> {
            threadLocal.set("qiurui");
            String ans = threadLocal.get();
            System.out.println(ans + Thread.currentThread().getName());
        });
        Thread t2 = new Thread(() -> {
            String ans = threadLocal.get();
            System.out.println(ans + Thread.currentThread().getName());
        });
        t.start();
        t2.start();
        t.join();
        t2.join();
        threadLocal.remove();
    }

    public static void main2(String[] args) throws Exception {
        class MyThread extends Thread {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 0; i < 10000; i++) {
                        cnt++;
                    }
                    count.countDown();
                }
            }
        }
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                synchronized (object) {
                    for (int i = 0; i < 50000; i++) {
                        cnt++;
                    }
                    count.countDown();
                }
            }
        }

        class MyCallable implements Callable<Integer> {
            @Override
            public Integer call() throws Exception {
                synchronized (object) {
                    for (int i = 0; i < 20000; i++) {
                        cnt++;
                    }
                    count.countDown();
                    return cnt;
                }
            }
        }
//        for(int i = 0; i < 10; i++) {
//            MyThread myThread = new MyThread();
//            myThread.start();
//        }
//        for(int i = 0; i < 10; i++) {
//            MyRunnable myRunnable = new MyRunnable();
//            myRunnable.run();
//        }
        for (int i = 0; i < 10; i++) {
            MyCallable myCallable = new MyCallable();
            System.out.println(myCallable.call());
        }
        count.await();
        System.out.println(cnt);

    }

    public static void main1(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 100, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
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
        Thread t = new Thread() {
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
        }, 100);
        System.out.println(a);
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        ThreadLocal<Integer> tt = new ThreadLocal<>();
    }
}
