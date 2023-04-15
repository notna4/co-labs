package testbench;


import bench.CPUFixedPoint;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

public class TestCPUFixedPoint {
    public static void main(String[] args) throws InterruptedException {
        ITimer time = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench = new CPUFixedPoint();
        bench.initialize(100000000);
//        bench.warmup();
        time.start();
//        long st = System.nanoTime();
        bench.run();
//        long en = System.nanoTime();
//        System.out.println(en-st);
        long end = time.stop();
        System.out.println(end);
        log.write("Finished in", end, "micros");
        log.write("Finished in", end, "s");
        log.write("Finished in", end, "ns");
//        System.out.println();
        System.out.println(("OPS: " + ((CPUFixedPoint) bench).calcOPS(end, 1)));
        System.out.println(("MOPS: " + ((CPUFixedPoint) bench).calcMOPS(end, 1)));
        log.close();
    }
}
