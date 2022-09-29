package firstTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FirstTask {
    private static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) {
        scheduledExecutorService.scheduleAtFixedRate(new SecondsCounterThread(), 1, 1, SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new FiveSecondAlarmThread(), 5, 5, SECONDS);
    }
}
