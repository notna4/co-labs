package bench;

import java.util.Random;

public class CPUFixedPoint implements IBenchmark{


    int num[];
    int res[];

    private void arithm() {
        int l = 2, k = 2;
        for(int j = 0; j < num.length; j++) {
            j = (num[1] * (k - j) * (l + k));
            k = (num[3] * k - (l + j) * k);
            l = ((l + k) * (num[2] + j));
        }
    }

    @Override
    public void run() throws InterruptedException {
        arithm();
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialize(int size) {
        num = new int[size];
        res = new int[size];

        Random rand = new Random();
        for(int i = 0; i < size; i++) {
            num[i] = rand.nextInt(size);
            res[i] = rand.nextInt(size);
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
        arithm();
    }
}
