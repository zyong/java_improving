package example.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExceptionDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        try {
            Future<Double> future = executorService.submit(() ->{
                throw new RuntimeException("executorService .submit()");
            });

            Double b = future.get();
            System.out.println(b);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Exception catch");
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("Main Thread End!");
    }
}
