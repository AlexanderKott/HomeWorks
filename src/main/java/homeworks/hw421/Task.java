package homeworks.hw421;


import java.util.Date;

public class Task {
    private String caption;
    private long time;

    public Task(String caption) {
        this.caption = caption;
        this.time = System.currentTimeMillis();
    }

    @Override
    public String toString() {

        return "Task " +
               "caption='" + caption + '\'' +
               ", time=" + new Date(time);
    }
}
