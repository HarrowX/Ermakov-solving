package xyz.alexandrit.attributes;

public class Time implements Comparable<Time> {
    int totalSecond;

    static final int SECONDS_IN_DAY = 24 * 60 * 60;
    static final int SECONDS_IN_HOUR = 60 * 60;
    static final int SECONDS_IN_MINUTE = 60;

    public Time(int totalSecond) {
        this.totalSecond = totalSecond % SECONDS_IN_DAY;
    }

    public Time(int hours, int minutes, int seconds) {
        this(seconds + minutes * SECONDS_IN_MINUTE + hours * SECONDS_IN_HOUR);
    }

    public int minutes() {
        return totalSecond % SECONDS_IN_HOUR / SECONDS_IN_MINUTE;
    }

    public int seconds() {
        return totalSecond % SECONDS_IN_MINUTE;
    }

    public int hours() {
        return totalSecond / SECONDS_IN_HOUR;
    }

    @Override
    public int compareTo(Time o) {
        return this.totalSecond - o.totalSecond;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d",hours(),minutes(),seconds());
    }
}
