package Color_yr.TouHouFight.Event;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

public class player implements Listener {

    @EventHandler
    public void damage(EntityDamageByEntityEvent e) {
        EntityType type = e.getDamager().getType();
        if (type == EntityType.SNOWBALL) {
            Snowball temp = (Snowball) e.getDamager();
            ProjectileSource source = temp.getShooter();
            String name = temp.getCustomName();
            if (source instanceof Player) {
                Player player = (Player) source;
                LivingEntity a = (LivingEntity) e.getEntity();
                a.damage(20000, player);
            }
            e.setCancelled(true);
        }
    }
}