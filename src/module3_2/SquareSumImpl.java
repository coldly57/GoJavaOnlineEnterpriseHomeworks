package module3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Konstantin A. on 20.04.2016.
 */
public class SquareSumImpl implements SquareSum {

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) throws ExecutionException, InterruptedException {

        if (values.length < numberOfThreads) {
            return 0;
        }

        Phaser phaser = new Phaser();
        List<Callable<Long>> callables = new ArrayList<>();

        int initialArrayLength = values.length;

        int majorPartsArrayLength = initialArrayLength / numberOfThreads;
        int lastPartArrayLength = initialArrayLength % numberOfThreads + majorPartsArrayLength;

        System.out.println("Array length: " + initialArrayLength + ", major parts length: " + majorPartsArrayLength +
                ", last part length: " + lastPartArrayLength);

        for (int i = 0; i < numberOfThreads; i++) {
            if (i == numberOfThreads - 1) {
                int[] temp = new int[lastPartArrayLength];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = values[i * majorPartsArrayLength + j];
                }

                callables.add(new Sum(phaser, temp));

            } else {
                int[] temp = new int[majorPartsArrayLength];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = values[i * majorPartsArrayLength + j];
                }

                callables.add(new Sum(phaser, temp));
            }
        }

        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Long>> results = executor.invokeAll(callables);

        long sum = 0;

        for (Future<Long> f : results){
            System.out.println("Result: " + f.get());
            sum += f.get();
        }

        executor.shutdown();

        return sum;
    }

    private class Sum implements Callable<Long> {

        private Phaser phaser;

        private int[] calculateArray;
        private Long sum = 0L;

        Sum(Phaser phaser, int[] calculateArray) {
            this.calculateArray = calculateArray;
            this.phaser = phaser;
            this.phaser.register();
        }

        @Override
        public Long call() throws Exception {

            System.out.println(Thread.currentThread().getName() + " started phase #" + phaser.getPhase());
            for (int i = 0; i < calculateArray.length; i++) {
                calculateArray[i] = (int) Math.pow((double) calculateArray[i], 2);
            }
            System.out.println(Thread.currentThread().getName() + " finished phase #" + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + " started phase #" + phaser.getPhase());
            for (int element : calculateArray) {
                sum += element;
            }
            System.out.println(Thread.currentThread().getName() + " finished phase #" + phaser.getPhase());

            phaser.arriveAndDeregister();

            return sum;
        }
    }
}


