package app;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {

    private final Lock lock = new ReentrantLock();


    public void handleData(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " wants to acquire the lock");
            lock.lock();
            try {
                System.out.println(threadName + " acquired the lock");
                numbers[i] = numbers[i] * 3;
            } finally {
                System.out.println(threadName + " wants to release the lock");
                lock.unlock();
                System.out.println(threadName + " released the lock");
            }
        }
    }
}
