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

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        ITimer timer = new Timer();
//        ILogger log = new ConsoleLogger();
        ILogger log = new FileLogger();
        IBenchmark bench = new DummyBenchmark();

        bench.initialize(100);
        timer.start();
        bench.run();
        log.write("Finished in", timer.stop(), "ns");

        log.close();
    }
}
