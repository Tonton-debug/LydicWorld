package com.tonton.LydicWorld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.ItemStack;

import com.google.common.reflect.Reflection;

public class GameCaseManager {

	private static GameCaseManager _manager;
	private Map<Integer,GameCase> _cases=new HashMap<Integer,GameCase>();
	public static GameCaseManager GetManager () {
		if(_manager==null)
			_manager=new GameCaseManager();
		return _manager;
	}
	private GameCaseManager() {
		// TODO Auto-generated constructor stub
		RegisterCase(new MobGameCase());
		RegisterCase(new BlockGameCase());
		RegisterCase(new OpGameCase());
	}
	public void RegisterCase(GameCase gameCase) {
		
		if(_cases.containsKey(gameCase.Index()))
			return;
		_cases.put(gameCase.Index(), gameCase);
	}
	public void Use(ItemStack stack,LydicPlayer pl) {
		for(GameCase caseGame:_cases.values()) {
			if(caseGame.IsGameCase(stack))
			{
				stack.setAmount(stack.getAmount()-1);
				caseGame.Use(pl);
				return;
			}
		}
	}
	public GameCase GetCase(int id) {
		if(!_cases.containsKey(id))
			return new NullGameCase();
		return _cases.get(id);
		
	}

}
