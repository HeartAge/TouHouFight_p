package Color_yr.TouHouFight.Command;

import Color_yr.TouHouFight.Config.languageObj;
import Color_yr.TouHouFight.TouHouFight;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

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
