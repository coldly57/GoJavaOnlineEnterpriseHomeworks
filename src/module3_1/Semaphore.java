package module3_1;

/**
 * Created by Konstantin A. on 04.04.2016.
 */
public interface Semaphore {

    void acquire() throws InterruptedException;
    void acquire(int permits) throws InterruptedException;
    void release();
    void release(int permits);
    int getAvailablePermits();

}
