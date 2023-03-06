package timing;

public class Timer implements ITimer{

    private long start = 0;
    private long end = 0;
    private long elapsedTime = 0;
    private long totalTime = 0;

    @Override
    public void start() {
        start = System.nanoTime();
        totalTime = 0;
    }

    @Override
    public long stop() {
        totalTime = System.nanoTime() - start;
        return totalTime;
    }

    @Override
    public void resume() {
        elapsedTime = System.nanoTime()-start;
    }

    @Override
    public long pause() {
        elapsedTime = System.nanoTime()-start;
        totalTime += elapsedTime;
        return elapsedTime;
    }
}
