public class NumberPrinter implements Runnable {
    int number;
    
    NumberPrinter(int n) {
        number = n;
    }
    
    
    @Override
    public void run() {
        System.out.println("Number - " + number + " Thread - " + Thread.currentThread().getName());
    }
}
