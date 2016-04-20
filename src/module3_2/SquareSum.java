package module3_2;

import java.util.concurrent.ExecutionException;

/**
 * Created by Konstantin A. on 20.04.2016.
 */
public interface SquareSum {

    long getSquareSum(int[] values, int numberOfThreads) throws ExecutionException, InterruptedException;
}
