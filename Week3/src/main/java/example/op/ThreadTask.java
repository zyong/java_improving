package example.op;

public class ThreadTask {
    public static void main(String[] args) throws InterruptedException {
//        Runnable task = new Runnable() {
        Runnable task = () -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Thread t = Thread.currentThread();
                System.out.println("当前线程:" + t.getName());
        };

        Thread thread =  new Thread(task);
        thread.setName("Test-thread-1");
//        thread.setDaemon(true);
        thread.start();
//        Thread.sleep(5000);
    }
}
