package com.tonton.LydicWorld;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class PlayerLister implements Listener {

	public PlayerLister() {
		// TODO Auto-generated constructor stub
	}
	@EventHandler
	public void OnJoin(PlayerJoinEvent event) {
		
		if(!LydicPlayerManager.GetManager().HasLydic(event.getPlayer().getUniqueId())) {
			LydicPlayerManager.GetManager().RegisterLydic(event.getPlayer());
			LydicPlayerManager.GetManager().GetLydic(event.getPlayer().getUniqueId()).Init();
		}
	}
	@EventHandler
    public void onExpChange(PlayerExpChangeEvent event) {
        LydicPlayerManager.GetManager().GetLydic(event.getPlayer().getUniqueId()).TryKill();
    }
	@EventHandler
	public void OnUse(PlayerInteractEvent event) {
		   Player player = event.getPlayer();
		   
		   LydicPlayer playerLydic=LydicPlayerManager.GetManager().GetLydic(event.getPlayer().getUniqueId());
	        ItemStack item = player.getInventory().getItemInMainHand();
	        	Plugin.plugin.getLogger().info("ANANAS");
	        	GameCaseManager.GetManager().Use(item, playerLydic);
	}
	 @EventHandler
	    public void onPlayerChat(AsyncPlayerChatEvent eventas) {
		 LydicPlayer pl=LydicPlayerManager.GetManager().GetLydic(eventas.getPlayer().getUniqueId()); 
		 eventas.setFormat(pl.GetChatName()+eventas.getMessage());
	 }
	 @EventHandler
public void OnRespawn(PlayerRespawnEvent event) {
		 LydicPlayer pl=LydicPlayerManager.GetManager().GetLydic(event.getPlayer().getUniqueId()); 
			pl.Respawn();
	 }
	 @EventHandler
public void OnDie(PlayerDeathEvent event) {
		 Plugin.plugin.getLogger().info("PLAYER "+event.getEntity().getName()+"DIE");
		 LydicPlayer pl=LydicPlayerManager.GetManager().GetLydic(event.getEntity().getUniqueId()); 
		pl.OnDie();	
	 }
}
