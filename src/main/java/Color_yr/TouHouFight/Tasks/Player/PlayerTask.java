package Color_yr.TouHouFight.Tasks.Player;

import Color_yr.TouHouFight.API.IPlayer;

import java.util.HashMap;
import java.util.Map;

public class PlayerTask {
    private final static Map<String, IPlayer> playerSave = new HashMap<>();
    private final static Object lock = new Object();

    public static void add(String player, IPlayer save) {
        synchronized (lock) {
            playerSave.put(player, save);
        }
    }

    public static final Runnable runnable = () -> {
        if (playerSave.size() != 0) {
            Tick();
        }
    };

    public static IPlayer get(String player) {
        return playerSave.get(player);
    }

    public static void Tick() {
        synchronized (lock) {
            for (Map.Entry<String, IPlayer> item : playerSave.entrySet()) {
                item.getValue().skillTick();
            }
        }
    }
}
