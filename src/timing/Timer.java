package timing;

public class Timer implements ITimer{

    private long resumeTime = 0;
    private long elapsedTime = 0;

    @Override
    public void start() {
        resumeTime = System.nanoTime();
    }

    @Override
    public long stop() {
        return System.nanoTime()-resumeTime+elapsedTime;
    }

    @Override
    public void resume() {
        resumeTime = System.nanoTime();
    }

    @Override
    public long pause() {
        elapsedTime += System.nanoTime()-resumeTime;
        return System.nanoTime()-resumeTime;
    }
}
