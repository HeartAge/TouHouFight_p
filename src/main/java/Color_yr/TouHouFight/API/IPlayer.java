package Color_yr.TouHouFight.API;

import org.bukkit.entity.Player;

public interface IPlayer {

    //获取玩家
    Player getPlayer();
    //获取生命
    int health();
    //回血
    void addHealth(int amount);
    //最大弹药
    int maxAmmunition();
    //当前弹药
    int nowAmmunition();
    //射速
    int rate();
    //护盾
    int shield();
    //增加护盾
    void addShield(int amount);
    //重装时间
    int reloadTime();
    //已经重装了多长时间
    int reloadNow();
    //模型
    String model();
    //射击模式
    ShotMode shotMode();
    //弹药类型
    ShotType shotType();
    //射击状态
    ShotState getState();
    //玩家状态
    PlayerState getPlayState();
    //伤害
    int getDamage();
    //造成伤害
    void damage(int amount, ShotType type);
    //被动概率
    double passiveChance();
    //主动技能
    void skill1();

    void skill2();

    void skill3();
    //绝杀技能
    void uniqueSkills();
    //技能tick
    void skillTick();
    //重置
    void reset();
    //击杀
    void kill();
    //射击
    void shot();

}
