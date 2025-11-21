package com.tonton.LydicWorld;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlotCreator {

	public PlotCreator() {
		// TODO Auto-generated constructor stub
	}
	public static void CreatePlot(Player pl) {
		int startX=pl.getLocation().getBlockX();
		int startZ=pl.getLocation().getBlockZ();
		int startY=64;
		World world=pl.getWorld();
		Random random=new Random();
		int size=random.nextInt(7,15);
		int sizeY=random.nextInt(5,size);
		
		int zRadius=0;
		for(int y=startY;y>startY-sizeY;y-=1) {
		for(int x=startX-size+zRadius;x<startX+size-zRadius;x+=1) {
			for(int z=startZ-size+zRadius;z<startZ+size-zRadius;z+=1) {
				if(zRadius==0)
				world.getBlockAt(x,y,z).setType(Material.GRASS_BLOCK);
				else
					world.getBlockAt(x,y,z).setType(Material.DIRT);
			}	
		}
		zRadius+=1;
		}
		int randomWaterBlockX=random.nextInt(startX-size+2,startX+size-2);
		int randomWaterBlockY=random.nextInt(startZ-size+2,startZ+size-2);
		int randomTreeBlockX=random.nextInt(startX-size+1,startX+size-1);
		int randomTreeBlockZ=random.nextInt(startZ-size+1,startZ+size-1);
		world.generateTree(world.getBlockAt(randomTreeBlockX, startY+1, randomTreeBlockZ).getLocation(), TreeType.TREE);
		for(int x=randomWaterBlockX;x<randomWaterBlockX+2;x+=1) {
			for(int z=randomWaterBlockY;z<randomWaterBlockY+2;z+=1) {
				world.getBlockAt(x,startY,z).setType(Material.WATER);
			}
		}
		world.getBlockAt(randomTreeBlockX-1,startY+1,randomTreeBlockZ).setType(Material.CHEST);
		Chest chest=(Chest)world.getBlockAt(randomTreeBlockX-1,startY+1,randomTreeBlockZ).getState();
		chest.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET,1));
	}
	

}
