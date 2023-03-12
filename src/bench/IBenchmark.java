package bench;

public interface IBenchmark {
    void run() throws InterruptedException;
    void run(Object ... params);
    void initialize(int size);

    void clean();
    void cancel();
}
