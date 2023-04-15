package bench;

public interface IBenchmark {
    void initialize(Object... params);

    void warmUp();

    void run() throws InterruptedException;
    void run(Object ... params);
    void initialize(int size);

    void clean();
    void cancel();

    void warmup();
}
