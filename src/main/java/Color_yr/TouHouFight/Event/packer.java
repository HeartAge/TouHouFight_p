package Color_yr.TouHouFight.Event;

import Color_yr.TouHouFight.API.ShotMode;
import Color_yr.TouHouFight.API.ShotType;
import Color_yr.TouHouFight.Tasks.Shot.ShotTask;
import Color_yr.TouHouFight.Tasks.Shot.ShotTaskObj;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class packer implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
        if (channel.equalsIgnoreCase("thf:channel")) {
            byte[] temp = new byte[bytes.length - 1];
            System.arraycopy(bytes, 1, temp, 0, bytes.length - 1);
            String data = new String(temp);
            if (data.equals("shot")) {
                ShotTask.addTask(new ShotTaskObj(player, ShotType.Physical, ShotMode.SingleShot, 1, 50));
                player.sendMessage("shot1");
            }
            else if(data.equals("noshot"))
            {

            }
        }
    }
}