package testbench;

import bench.DummyBenchmark;
import bench.IBenchmark;
import bench.cpu.CPUDigitsOfPi;
import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

public class TestCPUDigitsOfPi {
    public static void main(String[] args) throws InterruptedException {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
//        ILogger log = new FileLogger();
        IBenchmark bench = new CPUDigitsOfPi();

        bench.initialize(25000);
        bench.warmup();
        timer.start();
        bench.run();
        long stopTime = timer.stop();
        log.write("Finished in", stopTime, "micros");
        log.write("Finished in", stopTime, "s");
        log.close();
    }
}
