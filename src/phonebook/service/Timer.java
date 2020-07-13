package phonebook.service;

import java.util.concurrent.TimeUnit;

public class Timer {
    private long start = 0;
    private long stop = 0;
    private long duration = 0;
    //TODO correct class to work for multiple tasks
    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        stop = System.currentTimeMillis();
        duration = stop - start;
    }

    public long getDuration() {
        duration = System.currentTimeMillis() - start;
        return duration;
    }

    private String getFormattedDuration() {
        long millis = duration;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        millis -= TimeUnit.SECONDS.toMillis(seconds);
        return String.format("%d min. %d sec. %d ms.", minutes, seconds, millis);
    }

    @Override
    public String toString() {
        return "Time taken : " + getFormattedDuration();
    }
}
