import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumberGenerator implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);
        System.out.println("Random Number Generated - " + randomNumber
                + " Thread Name - " + Thread.currentThread().getName());
        /*To Check Blocing IO made Thread to Sleep*/
        Thread.sleep(1000);
        return randomNumber;
    }
}
