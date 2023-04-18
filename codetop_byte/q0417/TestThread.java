package codetop_byte.q0417;

import java.util.concurrent.*;

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


    }
}
