package app;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {

    private final Lock lock = new ReentrantLock();


    public void handleData(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " хоче взяти лок");
            lock.lock();
            try {
                System.out.println(threadName + " взяв лок");
                numbers[i] = numbers[i] * 3;
            } finally {
                System.out.println(threadName + " хоче віддати лок");
                lock.unlock();
                System.out.println(threadName + " віддав лок");
            }
        }
    }
}
