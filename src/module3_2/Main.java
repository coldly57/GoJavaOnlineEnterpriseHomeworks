package module3_2;

import java.util.concurrent.ExecutionException;

/**
 * Created by Konstantin A. on 20.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        long sum = 0;

        try {
            sum = new SquareSumImpl().getSquareSum(values, 13);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total sum: " + sum);
    }

}
