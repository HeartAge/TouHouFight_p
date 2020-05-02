package Color_yr.TouHouFight.Event;

import Color_yr.TouHouFight.API.IPlayer;
import Color_yr.TouHouFight.Tasks.Player.PlayerTask;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class packer implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {
        if (channel.equalsIgnoreCase("thf:channel")) {
            IPlayer save = PlayerTask.get(player.getName());
            if(save==null)
                return;
            byte[] temp = new byte[bytes.length - 1];
            System.arraycopy(bytes, 1, temp, 0, bytes.length - 1);
            String data = new String(temp);
            if (data.equals("shot")) {
                save.shot();
            } else if (data.equals("noshot")) {

            } else if (data.equals("ex1")) {

            } else if (data.equals("ex2")) {

            } else if (data.equals("ex3")) {

            } else if (data.equals("kill")) {

            }
        }
    }
}