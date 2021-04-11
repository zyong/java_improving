package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Calla {
    public static void main(String[] args) throws Exception {
        Callable func = new Callable() {
            @Override
            public Object call() throws Exception {
                return 9;
            }
        };
        FutureTask futureTask = new FutureTask(func);
        Thread t = new Thread(futureTask);
        t.start();

        System.out.println(futureTask.get().toString());

    }
}
