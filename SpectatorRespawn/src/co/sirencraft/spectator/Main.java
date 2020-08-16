package co.sirencraft.spectator;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static Main instance;
	
	
	@Override
	public void onEnable() {
		System.out.println("TestPlugin Enabled");
		Bukkit.getPluginManager().registerEvents(new DeathEvent(), this);
		
		this.saveDefaultConfig();
		instance = this;
		
	}
	
	
	
	
	public static Main getInstance() {
		return instance;
	}
}
