package com.tonton.LydicWorld;

import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatColor;

public class LydicPlayer {
	private OfflinePlayer _player;
	private int _savedLvl=0;
	private Location _respawnLoc;
	public LydicPlayer(UUID id) {
		// TODO Auto-generated constructor stub
		_player=Bukkit.getOfflinePlayer(id);
		
	}
	public void Init() {
		if(!_player.isOnline())
				return;
		SendWelcomeMessage();
		Respawn();
	}
	public void SetRespawnLoc(int x,int y,int z) {
		_respawnLoc=new Location(_player.getLocation().getWorld(),x,y,z);
	}
	public Vector GetRespawnLoc() {
		return _respawnLoc.toVector();
	}
	private void TeleportRandom() {
		if(!_player.isOnline())
			return;
		Player pl=_player.getPlayer();
		Random random=new Random();
		int x=random.nextInt(-10000,10000);
		int z=random.nextInt(-10000,10000);
		Location loc=new Location(pl.getWorld(),x,70,z);
		_player.getPlayer().teleport(loc);
	}
	
	public void Respawn() {
		Bukkit.getServer().getScheduler().runTaskLater(Plugin.plugin, 
				new Runnable() {
			 
            @Override
            public void run() {
            	Player pl=_player.getPlayer();
        		_savedLvl=_savedLvl/2;
        		
        		if(_savedLvl<5) {
        		
        		TeleportRandom();
        		PlotCreator.CreatePlot(_player.getPlayer());
        		_respawnLoc=pl.getLocation();
        		ChatHelper.YouDie(pl);
        		SetLvl(20);
        		pl.getInventory().clear();
        		pl.setBedSpawnLocation(null, true);
        		
        		} else {
        			if(pl.getBedSpawnLocation()==null)
        			pl.teleport(_respawnLoc);
        			SetLvl(_savedLvl/2);
        		}

            }

        }, 1);
		
	}
	public void OnDie() {
		_savedLvl=GetLvl();
	}
	private void SendWelcomeMessage() {
		ChatHelper.SendWelcomeMessage(this);
	}
	public Player GetPlayer() {
		return _player.getPlayer();
	}
	public UUID GetUUID() {
		return _player.getUniqueId();
	}
	public String GetName() {
		return _player.getName();
	}
	public void SetLvl(int lvl) {
		if(!_player.isOnline())
			return;
		
		_player.getPlayer().setLevel(lvl);
		TryKill();
		
	}
	public void TryKill() {
		
		if(GetLvl()<5)
			_player.getPlayer().setHealth(0);
	}
	public int GetLvl() {
		if(!_player.isOnline())
			return 0;
		return _player.getPlayer().getLevel();
	}
	public boolean AddLvl(int id) {
		if(!_player.isOnline())
			return false;
		TryKill();
		if(GetLvl()+id<=0)
			return false;
		SetLvl(GetLvl()+id);
		return true;
	}
	public boolean SubLvl(int id,boolean printMessage) {
		if(printMessage)
		ChatHelper.NotWinCase(id, GetPlayer());
		return AddLvl(-id);
	}
	public String GetChatName() {
		return ChatColor.RED+"[ЛУДОМАН "+GetLvl()+"] "+ChatColor.YELLOW+"<"+ GetName()+"_47>"+ChatColor.WHITE;
	}
}
