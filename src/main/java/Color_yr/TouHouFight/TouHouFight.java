package Color_yr.TouHouFight;

import Color_yr.TouHouFight.Command.THF;
import Color_yr.TouHouFight.Config.configMain;
import Color_yr.TouHouFight.Event.block;
import Color_yr.TouHouFight.Event.packer;
import Color_yr.TouHouFight.Event.player;
import Color_yr.TouHouFight.Tasks.TaskManaget;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class TouHouFight extends JavaPlugin {

    private static final String Version = "1.0.0";
    public static Plugin plugin;
    public static Logger log;
    public static configMain configMain;
    public static final String channel = "thf:channel";

    public static void LoadConfig() {
        if (configMain == null)
            configMain = new configMain();
        else
            configMain.setConfig();
    }

    public static void task(Runnable runnable) {
        Bukkit.getScheduler().runTask(plugin, runnable);
    }

    @Override
    public void onEnable() {
        plugin = this;
        log = getLogger();
        log.info("[TouHouFight]正在启动，感谢使用，本插件交流群：571239090");
        log.info("[TouHouFight]读取配置文件中");
        LoadConfig();
        log.info("[TouHouFight]挂钩插件中");
        log.info("[TouHouFight]注册指令中");
        THF.THF = new THF();
        Bukkit.getPluginCommand("touhoufight").setExecutor(THF.THF);//注册插件主指令
        Bukkit.getPluginCommand("thf").setExecutor(THF.THF);//注册插件主指令
        log.info("[TouHouFight]事件注册中");
        Bukkit.getPluginManager().registerEvents(new player(), this);
        Bukkit.getPluginManager().registerEvents(new block(), this);
        Bukkit.getMessenger().registerIncomingPluginChannel(this, channel, new packer());
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, channel);
        TaskManaget.init();

        log.info("[TouHouFight]已启动-" + Version);
    }

    @Override
    public void onDisable() {
        configMain.SaveTask.closeTimer();
        TaskManaget.stop();
        log.info("[TouHouFight]已停止，感谢使用");
    }
}
