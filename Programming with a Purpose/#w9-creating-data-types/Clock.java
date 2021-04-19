import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Clock {

    private static final int HOUR_PER_DAY = 24;
    private static final int MINUTE_PER_HOUR = 60;

    private int hour;
    private int minute;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h >= HOUR_PER_DAY || m < 0 || m >= MINUTE_PER_HOUR) {
            throw new IllegalArgumentException();
        }
        hour = h;
        minute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format
    // HH:MM
    public Clock(String s) {
        Pattern pattern = Pattern.compile("^[0-9]{2}:[0-9]{2}$");
        Matcher matcher = pattern.matcher(s);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        if (h < 0 || h >= HOUR_PER_DAY || m < 0 || m >= MINUTE_PER_HOUR) {
            throw new IllegalArgumentException();
        }
        hour = h;
        minute = m;
    }

    // Returns a string representation of this clock, using the format HH:MM
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour) {
            return true;
        } else if (hour > that.hour) {
            return false;
        } else if (minute < that.minute) {
            return true;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        toc(1);
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException();
        }
        minute += delta;
        if (minute >= MINUTE_PER_HOUR) {
            int h = minute / MINUTE_PER_HOUR;
            hour += h;
            minute -= MINUTE_PER_HOUR * h;
            if (hour >= HOUR_PER_DAY) {
                hour %= HOUR_PER_DAY;
            }
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        String s = args[2];
        Clock clock1 = new Clock(h, m);
        Clock clock2 = new Clock(s);
        clock1.tic();
        clock2.toc(2);
        StdOut.println("Clock 1: " + clock1);
        StdOut.println("Clock 2: " + clock2);
        StdOut.println(
                clock1.isEarlierThan(clock2) ? "Clock 1 is earlier than clock 2" : "Clock 2 is earlier than clock 1");

    }
}
