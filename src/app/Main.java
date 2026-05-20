package app;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        DataHandler handler = new DataHandler();
        int[] numbers = new DataRepository().getData();

        try (ExecutorService executor = Executors.newWorkStealingPool()){
            for (int i = 0; i < 2; i++) {
                executor.execute(() -> handler.handleData(numbers));
            }
        }

        System.out.println("Result: " + Arrays.toString(numbers));
        System.out.println();
    }
}
