package Color_yr.TouHouFight.FightList;

import Color_yr.TouHouFight.API.*;
import org.bukkit.entity.Player;

public abstract class PlayerBase implements IPlayer {
    protected Player player;
    protected int health;
    protected int ammunition;
    protected int nowAmmunition;
    protected int rate;
    protected int shield;
    protected int reloadNow;
    protected int reloadTime;
    protected String model;
    protected ShotMode shotMode;
    protected ShotType shotType;
    protected ShotState shotState;
    protected PlayerState playerState;
    protected int damage;
    protected double passiveChance;
    protected int skill1CountDown;
    protected int skill2CountDown;
    protected int skill3CountDown;
    protected int skillKillCountDown;

    public PlayerBase(Player player) {
        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void addHealth(int amount) {
        health += amount;
    }

    @Override
    public void addShield(int amount) {
        shield += amount;
    }

    @Override
    public int health() {
        return health;
    }

    @Override
    public int maxAmmunition() {
        return ammunition;
    }

    @Override
    public int nowAmmunition() {
        return nowAmmunition;
    }

    @Override
    public int rate() {
        return rate;
    }

    @Override
    public int shield() {
        return shield;
    }

    @Override
    public int reloadNow() {
        return reloadNow;
    }

    @Override
    public int reloadTime() {
        return reloadTime;
    }

    @Override
    public String model() {
        return model;
    }

    @Override
    public ShotMode shotMode() {
        return shotMode;
    }

    @Override
    public ShotType shotType() {
        return shotType;
    }

    @Override
    public ShotState getState() {
        return shotState;
    }

    @Override
    public PlayerState getPlayState() {
        return playerState;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void damage(int amount, ShotType type) {
        switch (type) {
            case Physical:
                shield -= amount;
                if (shield < 0) {
                    health += shield;
                    shield = 0;
                }
                break;
            case Magic:
                health -= amount;
        }
    }

    @Override
    public double passiveChance() {
        return passiveChance;
    }

    @Override
    public void reset() {
        shotState = ShotState.Shot;
        playerState = PlayerState.Play;
    }

    @Override
    public void kill() {
        health = 0;
    }
}
