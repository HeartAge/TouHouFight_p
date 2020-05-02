package Color_yr.TouHouFight.Tasks;

import Color_yr.TouHouFight.Tasks.Shot.ShotTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskManaget {
    private static ScheduledExecutorService Shot;

    public static void init() {
        Shot = Executors.newSingleThreadScheduledExecutor();
        Shot.scheduleAtFixedRate(ShotTask.runnable, 0, 10, TimeUnit.MILLISECONDS);
    }

    public static void stop() {
        if (Shot != null)
            Shot.shutdown();
    }
}
