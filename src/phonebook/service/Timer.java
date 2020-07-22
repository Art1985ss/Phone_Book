package phonebook.service;

import java.util.concurrent.TimeUnit;

public class Timer {
    private long start = 0;
    private long stop = 0;
    private long duration = 0;
    private boolean running = false;

    public void start() {
        start = System.currentTimeMillis();
        running = true;
    }

    public void stop() {
        stop = System.currentTimeMillis();
        duration = stop - start;
        running = false;
    }

    public long getDuration() {
        if (running) {
            return System.currentTimeMillis() - start;
        }
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    private String getFormattedDuration() {
        long millis = getDuration();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        millis -= TimeUnit.SECONDS.toMillis(seconds);
        return String.format("%d min. %d sec. %d ms.", minutes, seconds, millis);
    }

    @Override
    public String toString() {
        return getFormattedDuration();
    }
}
