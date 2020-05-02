package Color_yr.TouHouFight.Tasks.Shot;

import Color_yr.TouHouFight.API.ShotType;
import Color_yr.TouHouFight.TouHouFight;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.MetadataValueAdapter;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class ShotTask {
    private static final List<ShotTaskObj> TaskList = new ArrayList<>();
    public static final Runnable runnable = () -> {
        if (TaskList.size() != 0) {
            DoTask();
            TaskList.clear();
        }
    };

    public static void DoTask() {
        try {
            List<ShotTaskObj> temp = new ArrayList<>(TaskList);
            for (ShotTaskObj obj : temp) {
                Player player = obj.getPlayer();
                switch (obj.getMode()) {
                    case SevenShot:
                        for (int a = 0; a < 7; a++) {
                            shot(player, obj.getType(), obj.getDamage());
                            Thread.sleep(obj.getRate());
                        }
                        break;
                    case TripleTap:
                        for (int a = 0; a < 3; a++) {
                            shot(player, obj.getType(), obj.getDamage());
                            Thread.sleep(obj.getRate());
                        }
                        break;
                    case SingleShot:
                        shot(player, obj.getType(), obj.getDamage());
                        break;
                }
                TaskList.remove(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addTask(ShotTaskObj obj) {
        TaskList.add(obj);
    }

    private static void shot(Player player, ShotType type, int damage) {
        TouHouFight.task(() -> {
            Location location = player.getEyeLocation();
            location.setY(location.getY() - 0.15d);
            Vector a = location.getDirection();
            Vector v = new Vector(a.getX(), a.getY(), a.getZ());
            Vector v1 = new Vector(a.getX(), a.getY(), a.getZ());
            v1.multiply(0.8);
            location.add(v1);
            v.multiply(3);
            Snowball temp = (Snowball) player.getWorld().spawnEntity(location, EntityType.SNOWBALL);
            temp.setGravity(false);
            temp.setVelocity(v);
            temp.setShooter(player);
            temp.setGlowing(true);
            temp.setMetadata("t", get(type));
            temp.setMetadata("d", get(damage));
            player.playSound(location, Sound.BLOCK_DISPENSER_DISPENSE, 1f, 1f);
        });
    }

    private static MetadataValue get(Object obj) {
        return new MetadataValueAdapter(TouHouFight.plugin) {
            @Override
            public Object value() {
                return obj;
            }

            @Override
            public void invalidate() {

            }
        };
    }
}
