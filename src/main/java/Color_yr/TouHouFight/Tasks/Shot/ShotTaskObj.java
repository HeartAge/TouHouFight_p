package Color_yr.TouHouFight.Tasks.Shot;

import Color_yr.TouHouFight.API.ShotMode;
import Color_yr.TouHouFight.API.ShotType;
import org.bukkit.entity.Player;

public class ShotTaskObj {
    private final Player player;
    private final ShotType type;
    private final ShotMode mode;
    private final int damage;
    private final int rate;

    public ShotTaskObj(Player player, ShotType type, ShotMode mode, int damage, int rate) {
        this.damage = damage;
        this.mode = mode;
        this.player = player;
        this.type = type;
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public int getDamage() {
        return damage;
    }

    public Player getPlayer() {
        return player;
    }

    public ShotMode getMode() {
        return mode;
    }

    public ShotType getType() {
        return type;
    }
}
