import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyClass {
    public static void main(String [] args) throws ExecutionException, InterruptedException {
        System.out.println("Thread Name - " +  Thread.currentThread().getName());
        HelloWorldPrinter hwp = new HelloWorldPrinter();
        
        Thread th1 = new Thread(hwp);
        th1.start();
        
        Thread th2 = new Thread(hwp);
        th2.start();

        /* 
            **
                Generate Numbers from 1..100 By using 100 Threads
            **
        */
        for(int i = 1; i <= 100; i++) {
            NumberPrinter np = new NumberPrinter(i);
            Thread th = new Thread(np);
            th.start();
        }

        /* 
            **
                Generate Numbers from 1..100 By using 10 Threads in Thread Pool
            **
        */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 1; i <= 100; i++) {
            NumberPrinter np = new NumberPrinter(i);
            executorService.submit(np);
        }

         /* 
            **
                Callable Interface to Generate Random Number and Adding them
            **
        */
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        RandomNumberGenerator randomNumberGenerator1 = new RandomNumberGenerator();
        RandomNumberGenerator randomNumberGenerator2 = new RandomNumberGenerator();
        Future<Integer> randomNumber1 = executorService1.submit(randomNumberGenerator1);
        Future<Integer> randomNumber2 = executorService1.submit(randomNumberGenerator2);
        //Blocking IO
        Integer sumOfRandomNumber = randomNumber1.get() + randomNumber2.get();
        System.out.println("Sum of 2 Numbers - " + sumOfRandomNumber + 
                           " Thread Name " + Thread.currentThread().getName());
    }
}
