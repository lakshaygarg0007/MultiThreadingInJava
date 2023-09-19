public class MyClass {
    public static void main(String [] args) {
        System.out.println("Thread Name - " +  Thread.currentThread().getName());
        HelloWorldPrinter hwp = new HelloWorldPrinter();
        
        Thread th1 = new Thread(hwp);
        th1.start();
        
        Thread th2 = new Thread(hwp);
        th2.start();
    }
}
