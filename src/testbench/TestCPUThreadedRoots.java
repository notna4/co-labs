package testbench;

import bench.CPURecursionLoopUnrolling;
import bench.IBenchmark;
import bench.cpu.CPUThreadedRoots;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

import java.util.concurrent.TimeUnit;

public class TestCPUThreadedRoots {
    public static void main(String[] args) {
        ITimer timer = new Timer();

        ILogger log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.SECONDS;

        CPUThreadedRoots bench = new CPUThreadedRoots();
        int workload = 100000000;
        bench.initialize(workload);
        bench.warmUp();

        for(int i = 1; i < 9; i++){
            timer.start();
            bench.run(i);
            long time = timer.stop();
            System.out.println("[t="+i+"] Finished in " + time + " ns.");
            double score = (workload / ((time/1000000000)*8))/1000;
            System.out.println("Score: " + score);
//            System.out.print(timeUnit);
//            bench.getResult();
            log.write("[t="+i+"] Finished in", time, "s");
        }
        bench.clean();
        log.close();

    }
}
