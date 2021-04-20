package example.threadpool;

import java.util.concurrent.*;

public class NewScheduledThreadExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        for (int i=0; i<100; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Start:" + no);
                        Thread.sleep(1000L);
                        System.out.println("End:" + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.schedule(runnable, 10, TimeUnit.SECONDS);
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");

    }
}
