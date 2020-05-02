package Color_yr.TouHouFight.FightList;

import Color_yr.TouHouFight.API.ShotType;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Random;

//博丽灵梦
public class hakurei_reimu extends PlayerBase {

    private void init() {
        health = 100;
        shield = 200;
        damage = 20;
        ammunition = 30;
        reloadTime = 5;
    }

    public hakurei_reimu(Player player) {
        super(player);
        init();
    }

    @Override
    public void skill1() {
        if (skill1CountDown != 0)
            return;
        Location location = player.getLocation();
        Vector vector = location.getDirection();
        vector.multiply(5);
        location.add(vector);
        player.getLocation(location);
    }

    @Override
    public void skill2() {

    }

    @Override
    public void skill3() {

    }

    @Override
    public void uniqueSkills() {

    }

    @Override
    public void skillTick() {
        if (skill1CountDown > 0) {
            skill1CountDown--;
            player.sendMessage("skill 1>:" + skill1CountDown);
        }
        if (skill2CountDown > 0) {
            skill2CountDown--;
        }
        if (skill3CountDown > 0) {
            skill3CountDown--;
        }
        if (skillKillCountDown > 0) {
            skillKillCountDown--;
        }
    }

    @Override
    public void shot() {

    }

    @Override
    public void damage(int amount, ShotType type) {
        if (type == ShotType.Physical) {
            Random random = new Random();
            if (random.nextInt(99) <= 5)
                return;
        }
        super.damage(amount, type);
    }

    @Override
    public void reset() {
        super.reset();
        init();
    }
}
