package bench.cpu;

import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Random;

public class CPUDigitsOfPi implements IBenchmark {

    int range = 0;

    private void computePi(int size) {

        BigDecimal pi = BigDecimal.ZERO;
        BigDecimal term1, term2, term3, term4;

        for (int i = 0; i < size; i++) {
            term1 = BigDecimal.valueOf(4).divide(BigDecimal.valueOf(8 * i + 1), size, BigDecimal.ROUND_HALF_UP);
            term2 = BigDecimal.valueOf(2).divide(BigDecimal.valueOf(8 * i + 4), size, BigDecimal.ROUND_HALF_UP);
            term3 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(8 * i + 5), size, BigDecimal.ROUND_HALF_UP);
            term4 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(8 * i + 6), size, BigDecimal.ROUND_HALF_UP);

            pi = pi.add(term1.subtract(term2).subtract(term3).subtract(term4));
        }

//        System.out.println(pi);
}

    @Override
    public void initialize(Object... params) {

    }

    @Override
    public void warmUp() {

    }

    @Override
    public void run()  {
        computePi(this.range);
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialize(int size) {
        this.range = size;
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmup() {
        computePi(1000);
    }
}
