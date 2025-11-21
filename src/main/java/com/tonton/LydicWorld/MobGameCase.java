package com.tonton.LydicWorld;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class MobGameCase extends GameCase {
	@Override
	public String NameCase() {
		
		return "MobCase";
	}

	@Override
	public Material MaterialType() {
		
		return Material.GRASS_BLOCK;
	}


	@Override
	public int Cost() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void Use(LydicPlayer pl) {
		// TODO Auto-generated method stub
		Random random=new Random();
		ChatHelper.WinMobCase(pl.GetPlayer(), WorldHelper.SpawnRandomMob(pl.GetPlayer().getLocation())); ;
	}

	@Override
	public int Index() {
		// TODO Auto-generated method stub
		return 0;
	}

}
