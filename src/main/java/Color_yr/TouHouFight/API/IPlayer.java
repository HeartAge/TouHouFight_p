package Color_yr.TouHouFight.API;

import org.bukkit.entity.Player;

public interface IPlayer {

    Player getPlayer();

    int health();

    int maxAmmunition();

    int nowAmmunition();

    int rate();

    int shield();

    int delayShot();

    String model();

    ShotMode shotMode();

    ShotType shotType();

    ShotState getState();

    double getDamage();

    void damage(double amount, ShotType type);

    double passiveChance();

    void skill1();
    
    void skill2();

    void skill3();

    void uniqueSkills();

    void skillTick();

    void reset();

    void killAdd();

    void kill();

    void shot();

}
