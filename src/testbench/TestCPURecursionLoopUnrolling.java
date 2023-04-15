package testbench;

import bench.CPURecursionLoopUnrolling;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

public class TestCPURecursionLoopUnrolling {
    public static void main(String[] args) {
        IBenchmark bench = new CPURecursionLoopUnrolling();
        ITimer time = new Timer();

        bench.initialize(20000);
        time.start();
        bench.run(true, 6);
        long end = time.stop();
        System.out.println("Time: " + end);
//        ((CPURecursionLoopUnrolling) bench).display();
        System.out.println("counter " + ((CPURecursionLoopUnrolling) bench).counter);
        System.out.println("sum " + ((CPURecursionLoopUnrolling) bench).sum);
        System.out.println("start " + ((CPURecursionLoopUnrolling) bench).start);
        System.out.println("score " + ((CPURecursionLoopUnrolling) bench).start*100000.0/end);

    }
}
