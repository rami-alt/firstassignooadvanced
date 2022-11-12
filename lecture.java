import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class lecture {
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getTime() {
        return time;
    }

    public Duration getDuration() {
        return duration;
    }

    DayOfWeek dayOfWeek;
    LocalTime time;
    Duration duration;

    public lecture(DayOfWeek dayOfWeek, LocalTime time, Duration duration) {
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.duration = duration;

    }

    @Override
    public String toString() {
        return "lecture [dayOfWeek=" + dayOfWeek + ", time=" + time + ", duration=" + duration + "]";
    }

}
