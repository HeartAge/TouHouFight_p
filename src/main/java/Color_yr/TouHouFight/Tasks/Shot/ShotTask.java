package Color_yr.TouHouFight.Tasks.Shot;

import Color_yr.TouHouFight.TouHouFight;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;

import java.util.ArrayList;
import java.util.List;

public class ShotTask {
    private static final List<ShotTaskObj> TaskList = new ArrayList<>();
    private static boolean needAdd;
    private static final Object lock = new Object();

    public static void addTask(ShotTaskObj obj) {
        needAdd = true;
        synchronized (lock) {
            TaskList.add(obj);
        }
        needAdd = false;
    }

    public static final Runnable runnable = () -> {
        if (needAdd)
            return;
        if (TaskList.size() != 0) {
            try {
                for (ShotTaskObj obj : TaskList) {
                    Player player = obj.getPlayer();
                    switch (obj.getMode()) {
                        case SevenShot:
                            for (int a = 0; a < 7; a++) {
                                shot(player);
                                Thread.sleep(obj.getRate());
                            }
                            break;
                        case TripleTap:
                            for (int a = 0; a < 3; a++) {
                                shot(player);
                                Thread.sleep(obj.getRate());
                            }
                            break;
                        case SingleShot:
                            shot(player);
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            TaskList.clear();
        }
    };

    private static void shot(Player player) {
        TouHouFight.task(() -> {
            Location location = player.getEyeLocation();
            location.setY(location.getY() - 0.3d);
            SmallFireball temp = (SmallFireball) player.getWorld().spawnEntity(location, EntityType.SMALL_FIREBALL);
            temp.setGravity(false);
            temp.setDirection(location.getDirection());
            temp.setCustomName("1;data");
            player.playSound(location, Sound.BLOCK_DISPENSER_DISPENSE, 1f, 1f);
        });
    }
}
