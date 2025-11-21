package com.tonton.LydicWorld;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class OpGameCase extends GameCase {
	@Override
	public String NameCase() {
		
		return "OpCase";
	}

	@Override
	public Material MaterialType() {
		
		return Material.WHITE_WOOL;
	}


	@Override
	public int Cost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Use(LydicPlayer pl) {
		// TODO Auto-generated method stub
		Random random=new Random();
		if(SubLvl(pl))
			;
		else {
			int count=random.nextInt(1,10);
			pl.AddLvl(count);
			ChatHelper.WinOpCase(pl.GetPlayer(), count);
		}
	}

	@Override
	public int Index() {
		// TODO Auto-generated method stub
		return 2;
	}

}
