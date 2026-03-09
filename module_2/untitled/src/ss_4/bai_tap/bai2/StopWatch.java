package ss_4.bai_tap.bai2;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch(){
        this.startTime = System.currentTimeMillis();
        this.endTime = this.startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public void start() {
        this.startTime = System.currentTimeMillis();
        this.endTime = this.startTime;
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return endTime - startTime;
    }
    @Override
    public String toString() {
        return "Elapsed time = " + getElapsedTime() + "ms";
    }
}
