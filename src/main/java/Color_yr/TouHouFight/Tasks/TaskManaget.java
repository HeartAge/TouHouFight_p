package Color_yr.TouHouFight.Tasks;

import Color_yr.TouHouFight.Tasks.Player.PlayerTask;
import Color_yr.TouHouFight.Tasks.Shot.ShotTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskManaget {
    private static ScheduledExecutorService Shot;
    private static ScheduledExecutorService Skill;

    public static void init() {
        Shot = Executors.newSingleThreadScheduledExecutor();
        Shot.scheduleAtFixedRate(ShotTask.runnable, 0, 10, TimeUnit.MILLISECONDS);
        Skill = Executors.newSingleThreadScheduledExecutor();
        Skill.scheduleAtFixedRate(PlayerTask.runnable, 0, 1, TimeUnit.SECONDS);
    }

    public static void stop() {
        if (Shot != null)
            Shot.shutdown();
        if (Skill != null)
            Skill.shutdown();
    }
}
