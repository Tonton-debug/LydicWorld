package com.tonton.LydicWorld;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;

public class LydicPlayerList {
	private Map<UUID,LydicPlayer> _players=new HashMap<UUID,LydicPlayer>();
	public LydicPlayerList() {
		// TODO Auto-generated constructor stub
	}
	public LydicPlayerList(LydicPlayer[] players) {
		for(LydicPlayer pl: players) {
			AddLydic(pl);
		}
	}
	public void AddLydic(LydicPlayer player) {
		if(HasLydic(player.GetUUID()))
			return;
			_players.put(player.GetUUID(), player);
		
	}
	public LydicPlayer[] GetLydics() {
		int size=_players.size();
		return  _players.values().toArray(new LydicPlayer[size]);
	}
	public boolean HasLydic(UUID lydic) {
		return _players.containsKey(lydic);
	}
	public LydicPlayer GetLydic(UUID lydicId) {
		if(!HasLydic(lydicId))
		{
			AddLydic(new LydicPlayer(lydicId));
			return GetLydic(lydicId);
		}
		return _players.get(lydicId);
	}
}
