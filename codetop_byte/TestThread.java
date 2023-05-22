package codetop_byte;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
class Service1 {

    public void process(String name) {
        User user = new User("超哥");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {

    public void process()  {
        User user = UserContextHolder.holder.get();
        ThreadSafeFormatter.dateFormatThreadLocal.get();
        System.out.println("Service2拿到用户名：" + user.name);
        new Service3().process();
        Runnable a = new Runnable() {
            @Override
            public void run(){
                System.out.println("aaa");
            }
        };
        Callable<Integer> c = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        };

    }
}

class ThreadSafeFormatter {

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal2 = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
}

class Service3 {

    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名：" + user.name);
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {

    public static ThreadLocal<User> holder = new ThreadLocal<>();


}

class User {

    String name;

    public User(String name) {
        this.name = name;
    }
}
public class TestThread {
    static int cnt = 0;
    static final Object object = new Object();
    static final CountDownLatch count = new CountDownLatch(10);
    // 这个方法相当于是建立一个具有初始值的ThreadLocal. 实际上是通过多态的向上转型,调用的initValue是SuppliedThreadLocal中的方法
    static final ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "qiuruixiang");

    class A extends B {
        int b = a;

    }

    class B {
        int a;
    }

    public static void main(String[] args) {
        new Service1().process("");

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
