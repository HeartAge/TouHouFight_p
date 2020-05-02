package Color_yr.TouHouFight.API;

public interface IPlayer {

    int health();

    int shield();

    int delayShot();

    ShotMode shotMode();

    ShotType shotType();

    void skill1();
    
    void skill2();

    void skill3();

    void kill();
}
