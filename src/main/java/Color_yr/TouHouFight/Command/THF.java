package Color_yr.TouHouFight.Command;

import Color_yr.TouHouFight.API.ShotMode;
import Color_yr.TouHouFight.API.ShotType;
import Color_yr.TouHouFight.Config.languageObj;
import Color_yr.TouHouFight.Entity.ShotEntityP;
import Color_yr.TouHouFight.Tasks.Shot.ShotTask;
import Color_yr.TouHouFight.Tasks.Shot.ShotTaskObj;
import Color_yr.TouHouFight.TouHouFight;
import net.minecraft.server.v1_14_R1.Vec3D;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class THF implements CommandExecutor, TabExecutor {
    public static THF THF;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] arg) {
        if (command.getName().equalsIgnoreCase("touhoufight")
                || command.getName().equalsIgnoreCase("thf")) {
            languageObj lan = TouHouFight.configMain.lan;
            if (arg.length == 0) {
                sender.sendMessage(lan.getUnknownCommand());
                return true;
            } else if (arg[0].equalsIgnoreCase("help")) {
                for (String a : lan.getHelpCommand()) {
                    sender.sendMessage(a);
                }
                return true;
            } else if (arg[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("heartage.admin")) {
                    TouHouFight.LoadConfig();
                    sender.sendMessage(lan.getReloadCommand());
                    return true;
                }
            } else if (arg[0].equalsIgnoreCase("test1")) {
                Player player = (Player) sender;
                ShotTask.addTask(new ShotTaskObj(player, ShotType.Physical, ShotMode.SingleShot, 1, 50));
                player.sendMessage("shot1");
                return true;
            } else if (arg[0].equalsIgnoreCase("test2")) {
                Player player = (Player) sender;
                ShotTask.addTask(new ShotTaskObj(player, ShotType.Physical, ShotMode.TripleTap, 1, 200));
                player.sendMessage("shot2");
                return true;
            } else if (arg[0].equalsIgnoreCase("test3")) {
                Player player = (Player) sender;
                ShotTask.addTask(new ShotTaskObj(player, ShotType.Physical, ShotMode.SevenShot, 1, 200));
                player.sendMessage("shot3");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] arg) {
        if (arg.length == 1) {
            List<String> temp = new ArrayList<>();
            if (sender.hasPermission("heartage.admin")) {
                temp.add("reload");
            }
            temp.add("help");
            return temp;
        }
        return null;
    }
}
