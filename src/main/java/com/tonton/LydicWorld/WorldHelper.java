package com.tonton.LydicWorld;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class WorldHelper {

	public WorldHelper() {
		// TODO Auto-generated constructor stub
	}
	public static EntityType SpawnRandomMob(Location loc) {
		Random random=new Random();
		  EntityType[] types = EntityType.values();
	        
	        boolean canSpawn=false;
	        while(!canSpawn) {
	        try {
	        	EntityType randomType = types[random.nextInt(types.length)];
	            loc.getWorld().spawnEntity(loc, randomType);
	            canSpawn=true;
	            return randomType;
	        } catch (Exception e) {
	            canSpawn=false;
	        }
	        }
	        return null;
	}
	 public static ItemStack SpawnRandomItem( Location location) {
		 World world=location.getWorld();
	        Material[] materials = Material.values();
	        Random random=new Random();
	        boolean canSpawn=false;
	        while(!canSpawn) {
	        try {
	        	  Material randomMat = materials[random.nextInt(materials.length)];
	        	  int count=random.nextInt(1,64);
	  	        ItemStack item = new ItemStack(randomMat,count);
	  	        world.dropItemNaturally(location, item);
	            canSpawn=true;
	            return item;
	        } catch (Exception e) {
	            canSpawn=false;
	        }
	        }
	        return null;
	        
	      
	    }

}
