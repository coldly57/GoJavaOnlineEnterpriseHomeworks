package module3_1;

/**
 * Created by Konstantin A. on 18.04.2016.
 */
public class SemaphoreTest {

    private Semaphore semaphore;

    public static void main(String[] args) throws InterruptedException {
        new SemaphoreTest().test();
    }

    public void test() {
        semaphore = new SemaphoreImpl(1);

        for (int i = 0; i < 10; i++) {
            new Thread(new Worker()).start();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

                int permits = 3;

                try {
                    System.out.println("Current number of permissions: " + semaphore.getAvailablePermits());
                    System.out.println("Special " + Thread.currentThread().getName() + " acquiring permission");
                    semaphore.acquire(permits);
                    System.out.println("Special " + Thread.currentThread().getName() + " started to work");
                    semaphore.release(permits);
                    System.out.println("Special " + Thread.currentThread().getName() + " released");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private class Worker implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Current number of permissions: " + semaphore.getAvailablePermits());
                System.out.println(Thread.currentThread().getName() + " acquiring permission");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " started to work");
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " released");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
