package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        DataHandler handler = new DataHandler();
        int[] numbers = new DataRepository().getData();

        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            tasks.add(() -> {
                handler.handleData(numbers);
                return null;
            });
        }

        try (ExecutorService executor = Executors.newWorkStealingPool()) {
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Result: " + Arrays.toString(numbers));
    }
}