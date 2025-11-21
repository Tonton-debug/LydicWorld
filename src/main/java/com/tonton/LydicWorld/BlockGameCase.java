package com.tonton.LydicWorld;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockGameCase extends GameCase {
	@Override
	public String NameCase() {
		
		return "BlockCase";
	}

	@Override
	public Material MaterialType() {
		
		return Material.RED_WOOL;
	}


	@Override
	public int Cost() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public void Use(LydicPlayer pl) {
		// TODO Auto-generated method stub
		Random random=new Random();
		ChatHelper.WinItemCase(pl.GetPlayer(), WorldHelper.SpawnRandomItem(pl.GetPlayer().getLocation())); 
	}

	@Override
	public int Index() {
		// TODO Auto-generated method stub
		return 1;
	}

}
