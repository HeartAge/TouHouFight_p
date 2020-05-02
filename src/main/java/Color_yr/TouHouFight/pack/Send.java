package Color_yr.TouHouFight.pack;

import Color_yr.TouHouFight.TouHouFight;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.bukkit.entity.Player;

import java.nio.charset.StandardCharsets;

public class Send {
    public static void sendPack(String data, Player player) {
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        ByteBuf buf = Unpooled.buffer(bytes.length + 1);
        buf.writeByte(666);
        buf.writeBytes(bytes);
        player.sendPluginMessage(TouHouFight.plugin, TouHouFight.channel, buf.array());
    }
}
