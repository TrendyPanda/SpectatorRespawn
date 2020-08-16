package co.sirencraft.spectator;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
	    Player p = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
	    Location L = p.getLocation();
	      p.spigot().respawn(); 
	      p.teleport(L);
			p.setGameMode(GameMode.SPECTATOR);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			    public void run() {
			    	Location spawn = e.getEntity().getWorld().getSpawnLocation();
			    	p.teleport(spawn);
			       p.setGameMode(GameMode.SURVIVAL);
			    }
			}, (Main.getInstance().getConfig().getInt("SpectatorCooldown") * 20));
			

			
		} else {
			p.spigot().respawn();
		}
	}
}