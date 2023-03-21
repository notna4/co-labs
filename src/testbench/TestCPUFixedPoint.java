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
        bench.initialize(1000000);
//        bench.warmup();
        time.start();
        bench.run();
        long end = time.stop();
        System.out.println(end);
        log.write("Finished in", end, "micros");
        log.write("Finished in", end, "s");
        log.close();
    }
}
