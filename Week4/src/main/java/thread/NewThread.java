package thread;

import java.util.concurrent.atomic.AtomicLong;

public class NewThread extends Thread {
    AtomicLong atomicLong = new AtomicLong();

    public static void main(String[] args) {
        NewThread t = new NewThread();
        t.start();
    }

    @Override
    public void run() {
        super.run();
        for (int i=0; i<100; i++) {
            System.out.println(atomicLong.incrementAndGet());
        }
    }
}
