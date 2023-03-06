package bench;

public interface IBenchmark {
    void run();
    void run(Object ... params);
    void initialize(int size);

    void clean();
    void cancel();
}
