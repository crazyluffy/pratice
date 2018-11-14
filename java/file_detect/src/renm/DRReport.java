package renm;

import java.util.Queue;

public class DRReport implements Reporter{
    private Queue<DetectResult> cache;

    public DRReport(Queue<DetectResult> cache) {
        this.cache = cache;
    }

    @Override
    public void report(DetectResult result) {
        cache.add(result);
    }
}
