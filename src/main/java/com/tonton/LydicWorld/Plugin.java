package com.tonton.LydicWorld;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;


public class Plugin extends JavaPlugin {
    public static JavaPlugin plugin;
    
    @Override
    public void onEnable() {
        Plugin.plugin = this;
        getLogger().info("Plugin is Starting!");
        getDataFolder().mkdirs();
        LydicPlayerManager.GetManager();
        getCommand("lydic").setExecutor(new BaseCommands());
		 getServer().getPluginManager().registerEvents(new PlayerLister(), this);
    }
    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new WorldGenerator();
    }
    @Override
    public void onDisable() {
    	LydicPlayerManager.GetManager().Save();
        getLogger().info("Plugin is Disabling!");
    }
}
