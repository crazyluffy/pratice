package org.renm;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue<DelayType> delayTypes = new DelayQueue<>();
        new Thread(() -> {
            while (true) {
                DelayType take = null;
                try {
                    take = delayTypes.take();
                    System.out.println("" + System.currentTimeMillis() + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        DelayType delayType = new DelayType(System.currentTimeMillis() + 10 * 1000);
        delayTypes.add(delayType);
        System.out.println(System.currentTimeMillis());
    }
}

class DelayType implements Delayed {
    private long timestamp;

    public DelayType(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timestamp - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayType other = (DelayType) o;
        return Long.compare(timestamp, other.timestamp);
    }
}