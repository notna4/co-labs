package bench;

import java.util.Arrays;
import java.util.Random;

public class DummyBenchmark implements IBenchmark {

    private int[] arr;

    @Override
    public void initialize(Object... params) {

    }

    @Override
    public void warmUp() {

    }

    @Override
    public void run() {
//        Arrays.sort(arr);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        for(int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + ", ");
//        }
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialize(int size) {
        Random rand = new Random();
        arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmup() {

    }
}
