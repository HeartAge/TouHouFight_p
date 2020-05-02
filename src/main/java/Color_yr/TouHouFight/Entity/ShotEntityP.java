package Color_yr.TouHouFight.Entity;

import net.minecraft.server.v1_14_R1.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ShotEntityP extends EntitySmallFireball {

    //向量
    //(x,y,z)点1
    //(x1,y1,y2)点2
    public ShotEntityP(World world, double x, double y, double z, double x1, double x2, double x3, Player player) {
        super(world, x, y, z, x1, x2, x3);
        shooter = (EntityLiving) player;
    }

    public ShotEntityP(Location location, Vector vector, Player player) {
        super(((CraftWorld) player.getWorld()).getHandle(), location.getX(), location.getY(), location.getZ(), vector.getX(), vector.getY(), vector.getZ());
        shooter = ((CraftPlayer) player).getHandle();
    }
}
