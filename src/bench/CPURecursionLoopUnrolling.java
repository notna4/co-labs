package bench;


public class CPURecursionLoopUnrolling implements IBenchmark{
    private long[] data;
    int size = 0;

    public int counter, unrollLevel, start, sum = 0;

    @Override
    public void initialize(Object... params) {

    }

    @Override
    public void warmUp() {

    }

    @Override
    public void run() throws InterruptedException {

    }

    public void run(Object... options) {
        boolean unrolling = (Boolean) options[0];
        if (unrolling) {
            int unrollLevel = (Integer) options[1];
            recursiveUnrolled(1, unrollLevel, data.length, 0);
        } else {
            recursive(1, size, 0);
        }
    }

    private long recursive(long start, long size, int counter) {
        this.counter = counter;
        this.start = (int) start;

        this.counter = counter;
        this.unrollLevel = unrollLevel;
        if (start > size) {
            return 0;
        }
        if (isPrime(start)) {
            data[(int) (start - 1)] = start;
        }
        try {
            return recursive(start + 1, size, counter + 1) + (isPrime(start) ? start : 0);
        } catch (StackOverflowError e) {
            display();
//            System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
            return 0;
        }
    }

    public void display() {

            System.out.println("Reached nr " + this.start + "/" + this.size + " at " + this.unrollLevel + " levels after " + this.counter + " calls.");
    }

    private long recursiveUnrolled(long start, int unrollLevel, int size, int counter) {
        this.counter = counter;
        this.start = (int) start;

        this.counter = counter;
        this.unrollLevel = unrollLevel;
        if (start > size) {
            return 0;
        }
        int primesFound = 0;
        for (int i = 0; i < unrollLevel && start + i <= size; i++) {
            if (isPrime(start + i)) {
                data[(int)start + i - 1] = start + i;
                primesFound++;
                long mysum = sumArray(start - 1, unrollLevel, primesFound);
                this.sum = (int) mysum;
            }
        }
        try {
            long mysumm = sumArray(start - 1, unrollLevel, primesFound);
//            this.sum = (int) mysum;
            return recursiveUnrolled(start + unrollLevel, unrollLevel, size, counter + 1)
                    + mysumm;
        } catch (StackOverflowError e) {
//             display((int) start, size, unrollLevel, counter);
//            display();
//            System.out.println("Reached nr " + start + "/" + size + " at " + unrollLevel + " levels after " + counter + " calls.");
            return 0;
        }
    }

    private boolean isPrime(long num) {
        if (num <= 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private long sumArray(long start, int unrollLevel, int primesFound) {
        long sum = 0;
        for (int i = 0; i < unrollLevel && start + i < data.length; i++) {
            sum += data[(int) (start + i)];
        }
        return sum;
    }


    @Override
    public void initialize(int sizee) {
        this.size = sizee;
        data = new long[size];
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
