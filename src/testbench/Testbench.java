package testbench;

import bench.DummyBenchmark;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Testbench {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, InterruptedException {
//        ITimer timer = new Timer();
//        ILogger log = new ConsoleLogger();
//        ILogger log = new FileLogger();
//        IBenchmark bench = new DummyBenchmark();
//        long val = 2000;
//        bench.initialize(100000);
//        timer.start();
//        bench.run();
//        long stopTime = timer.stop();
//        log.write("Finished in", stopTime, "micros");
//        log.write("Finished in", stopTime, "s");
//        log.write("Finished in", stopTime, "ns");
//        long offset = ((stopTime-val*10^6)/val*10^6)*100;
//        log.write("Offset", offset);

//        log.close();


        //testing pause and resume using a loop
        ITimer timer = new Timer();
////        ILogger log = new ConsoleLogger();
        ILogger log = new FileLogger();
        IBenchmark bench = new DummyBenchmark();
//        log.write("starting...");
        final int workload = 100000000;
        for(int i = 0; i < 12; ++i) {
            bench.initialize(workload);
            timer.resume();
            bench.run();
            long time = timer.pause();
            log.write("Run " + i + ":", time, "ns");
            log.write("Run " + i + ":", time, "s");
            log.write("\n");
        }
        log.write("Finished in", timer.stop(), "ns");
        log.write("Finished in", timer.stop(), "s");
        log.close();
    }
}
