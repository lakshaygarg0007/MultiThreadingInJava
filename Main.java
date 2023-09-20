import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyClass {
    public static void main(String [] args) {
        System.out.println("Thread Name - " +  Thread.currentThread().getName());
        HelloWorldPrinter hwp = new HelloWorldPrinter();
        
        Thread th1 = new Thread(hwp);
        th1.start();
        
        Thread th2 = new Thread(hwp);
        th2.start();

        for(int i = 1; i <= 100; i++) {
            NumberPrinter np = new NumberPrinter(i);
            Thread th = new Thread(np);
            th.start();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 1; i <= 100; i++) {
            NumberPrinter np = new NumberPrinter(i);
            executorService.submit(np);
        }
    }
}
