package com.tonton.LydicWorld;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class NullGameCase extends GameCase {



	@Override
	public String NameCase() {
		
		return "NullCase";
	}

	@Override
	public Material MaterialType() {
		
		return Material.AIR;
	}


	@Override
	public int Cost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Use(LydicPlayer pl) {
		
	}

	@Override
	public int Index() {
		// TODO Auto-generated method stub
		return -1;
	}

}
