package renm;

public class DetectResult {
    long time;
    String fileName;
    boolean done;

    public DetectResult(long time, String fileName, boolean done) {
        this.time = time;
        this.fileName = fileName;
        this.done = done;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void reset() {
        this.time = 0;
        fileName = null;
        done = false;
    }
}
