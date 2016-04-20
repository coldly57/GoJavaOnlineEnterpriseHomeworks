package module3_1;

/**
 * Created by Konstantin A. on 18.04.2016.
 */
public class SemaphoreImpl implements Semaphore {

    private int counter;
    private final Object lock = new Object();

    public SemaphoreImpl(int counter) {
        this.counter = counter;
    }

    @Override
    public void acquire() throws InterruptedException {
        synchronized (lock) {
            if (counter > 0) {
                counter--;
            } else {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                Thread.sleep(1000);
                lock.wait();
            }
        }

    }

    @Override
    public void acquire(int permits) throws InterruptedException {

        synchronized (lock) {
            while (counter < permits) {
                System.out.println("Special " + Thread.currentThread().getName() + " is waiting...");
                lock.wait();
            }
            counter -= permits;
        }
    }

    @Override
    public void release() {
        synchronized (lock) {
            if (counter >= 0) {
                lock.notifyAll();
            }
            counter++;
        }
    }

    @Override
    public void release(int permits) {
        synchronized (lock){
            if (counter >= 0){
                lock.notifyAll();
            }
            counter += permits;
        }
    }

    @Override
    public int getAvailablePermits() {
        return counter;
    }
}
