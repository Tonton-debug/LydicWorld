package com.tonton.LydicWorld;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class LydicYaml {
	private YamlConfiguration _yaml;
	private File _file;
	public LydicYaml() {
		// TODO Auto-generated constructor stub
		Init();
	}
	private void Init() {
		 _file = new File(Plugin.plugin.getDataFolder(), "Lydics.yml");
		
		if(!_file.exists()) {
			CreateLydicFile(_file);
		}
		_yaml = YamlConfiguration.loadConfiguration(_file);
		
	}
	public LydicPlayerList Load() {
		ArrayList<LydicPlayer> _players=new ArrayList<LydicPlayer>();
		for(String player:_yaml.getKeys(false)) {
			 
			LydicPlayer lydic=new LydicPlayer(UUID.fromString(player));	
			lydic.SetRespawnLoc(_yaml.getInt(player+".RespawnLoc.X"), _yaml.getInt(player+".RespawnLoc.Y"), _yaml.getInt(player+".RespawnLoc.Z"));
			_players.add(lydic);
		}
		if(_players.size()==0)
			return new LydicPlayerList();
		int size=_players.size();
		return new LydicPlayerList(_players.toArray(new LydicPlayer[size]));
	}
	public void Save(LydicPlayerList list) {
		for(LydicPlayer pl: list.GetLydics()) {
			_yaml.set(pl.GetUUID()+".Name", pl.GetName());
			_yaml.set(pl.GetUUID()+".RespawnLoc.X", pl.GetRespawnLoc().getBlockX());
			_yaml.set(pl.GetUUID()+".RespawnLoc.Y", pl.GetRespawnLoc().getBlockY());
			_yaml.set(pl.GetUUID()+".RespawnLoc.Z", pl.GetRespawnLoc().getBlockZ());
		}
		try {
			_yaml.save(_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void CreateLydicFile(File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
