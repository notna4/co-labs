package bench;

import java.util.Arrays;
import java.util.Random;

public class DummyBenchmark implements IBenchmark {

    private int[] arr;

    @Override
    public void run() {
        Arrays.sort(arr);

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
            arr[i] = rand.nextInt(50);
        }
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }
}
