package com.tonton.LydicWorld;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class LydicPlayerManager {

	private static LydicPlayerManager _manager;
	private LydicPlayerList _listPlayers;
	private LydicYaml _config=new LydicYaml();
	
	public static LydicPlayerManager GetManager () {
		if(_manager==null)
			_manager=new LydicPlayerManager();
		return _manager;
	}
	private LydicPlayerManager() {
		// TODO Auto-generated constructor stub
		Init();
	}
	private void Init() {
		_listPlayers=_config.Load();
		
	}
	public void Save() {
		_config.Save(_listPlayers);
	}
	public void RegisterLydic(Player pl) {
		_listPlayers.AddLydic(new LydicPlayer(pl.getUniqueId()));
	}
	public LydicPlayer GetLydic(UUID uid) {
		return _listPlayers.GetLydic(uid);
	}
	public boolean HasLydic(UUID uid) {
		return _listPlayers.HasLydic(uid);
	}
	

}
