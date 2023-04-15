package bench;

import java.util.Random;

public class CPUFixedPoint implements IBenchmark{


    int num[];
    int res[];
    int size;

    //37 op
    private void arithm() {
        int l = 2, k = 2;
        for(int j = 0; j < num.length; j++) {
            k = (num[3] * k + (l + j) * k);
            l = ((l + k) * (num[2] + j));
            res[l%size] = j+k*1;
            res[k] = (j*k)%size;
        }
    }
    //17 op
    private void bran() {
        System.out.println("starting bran with size of: " + size);
        for(int i = 0; i < size; i++) {
            if(i == 1) {
                i = num[i+2];
            }
            else {
                i = num[i];
            }

            if(i > 2) {
                i = num[i];
            }
            else {
                i = num[i+1];
            }

            if(i < 1) {
                i = num[i+1];
            }
            else {
                i = num[i];
            }

        }
    }

    @Override
    public void initialize(Object... params) {

    }

    @Override
    public void warmUp() {

    }

    @Override
    public void run() throws InterruptedException {
//        arithm();
        System.out.println("starting...");
        bran();
        System.out.println("finished");
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialize(int size) {
        num = new int[size];
        res = new int[size];
        this.size=size;

        for(int i = 0; i < size; i++) {
            num[i] = i;
        }
//        Random rand = new Random();
//        for(int i = 0; i < size; i++) {
//            num[i] = rand.nextInt(size/2);
//            res[i] = rand.nextInt(size/2);
//        }
    }

    /**
     * Method for calculating the number of operations;
     * @param time Time given in nanoseconds for the calculation;
     * @param t Used for the type of benchmark; 1 for branchTest, any number for arithmetic test.
     */
    public double calcOPS(long time, int t){
        double op = 37;
        if(t==1){
            op = 17;
        }
        double ops = (op*size)/(time/1000000000.0);
        return ops;
    }

    /**
     * Method for calculating the number of operations in millions;
     * @param time Time given in nanoseconds for the calculation;
     * @param t Used for the type of benchmark; 1 for branchTest, any number for arithmetic test.
     */
    public double calcMOPS(long time, int t){
        double op = 37;
        if(t==1){
            op = 17;
        }
        double mops = (op*size)/(time/1000.0);
        return mops;
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmup() {
//        arithm();
        bran();
    }

}
