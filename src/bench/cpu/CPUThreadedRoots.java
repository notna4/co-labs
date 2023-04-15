package bench.cpu;

import bench.IBenchmark;

public class CPUThreadedRoots  {

    private double result;
    private int size;
    private boolean running;

    int from, to;


    public void initialize(Object... params) {
        // save size from params array
        this.size = (int)params[0];
    }

    public void warmUp() {
        // call run method: call run() once
        // detect number of cores: Runtime.....availableProcessors();
    }

    public void run() {
        throw new UnsupportedOperationException(
                "Method not implemented. Use run(Objects...) instead");
    }

    public void run(Object... options) {
        // options[0] -> number of threads
        // ...
        int nThreads = (int)options[0];
        Thread[] threads = new Thread[nThreads];

        // e.g. 1 to 10,000 on 4 threads = 2500 jobs per thread
        final int jobPerThread = size / nThreads;

        running = true; // flag used to stop all started threads
        // create a thread for each runnable (SquareRootTask) and start it
        for (int i = 0; i < nThreads; ++i) {
            int from = i * jobPerThread + 1;
            int to = i == nThreads - 1 ? size : (i + 1) * jobPerThread;
            SquareRootTask task = new SquareRootTask(from, to);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        // join threads
        for (int i = 0; i < nThreads; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void clean() {
        // only implement if needed
    }


    public String getResult() {
        return String.valueOf(result);
    }

    public class SquareRootTask implements Runnable {

        private int from, to;
        private final double precision = 1e-4; // fixed
        private double result = 0.0;

        public SquareRootTask(int from, int to) {
            // save params to class members
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            for (int i = from; i <= to; i++) {
                if (!running) {
                    return;
                }
                result += getNewtonian(i);
            }
        }

        private double getNewtonian(double x) {
            double s = x;
            while (Math.abs(s * s - x) > precision) {
                s = (x / s + s) / 2;
            }
            return s;
        }

        // extra: compute sum, pass it back to wrapper class. Use synchronized
    }

}