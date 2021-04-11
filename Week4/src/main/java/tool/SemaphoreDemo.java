package tool;

import sun.tools.jconsole.Worker;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        int N = 8;
        Semaphore semaphore = new Semaphore(N);
        for (int i=1; i<N; i++) {
            new Worker(i, semaphore).start();
        }
    }


    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一台机器在生产");
                Thread.sleep(1000);
                System.out.println("工人" + this.num + "释放机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
