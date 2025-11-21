package com.tonton.LydicWorld;

import java.util.Map;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class GameCase {
	public abstract String NameCase();
	public abstract int Index();
	public abstract int Cost();
	public abstract Material MaterialType();
	public boolean Give(LydicPlayer pl,int count) {
		if(count>100) {
			ChatHelper.SendMoreCases(pl.GetPlayer());
			return false;
		}
		if(!pl.SubLvl(Cost()*count,false)) {
			ChatHelper.SendNoMoney(this,pl.GetPlayer());
			return false;
		}
		ChatHelper.SendOnBuyCase(this,pl.GetPlayer());
		Player player=pl.GetPlayer();
		ItemStack itemStack=new ItemStack(MaterialType(),count);
		SetItemToCase(itemStack);
		Map<Integer, ItemStack> leftover=	player.getInventory().addItem(itemStack);
		if (!leftover.isEmpty()) {
		    for (ItemStack stack : leftover.values()) {
		        player.getWorld().dropItemNaturally(player.getLocation(), stack);
		    }
		}
		return true;
	}
	public boolean SubLvl(LydicPlayer pl,int min,int max) {
		Random random=new Random();
		int maxLvl=max;
		return random.nextBoolean()&&pl.SubLvl(random.nextInt(min,maxLvl),true);
	}
	public boolean SubLvl(LydicPlayer pl) {
		return SubLvl(pl,1,pl.GetLvl()/2<2?2:pl.GetLvl()/2);
	}
	public void SetItemToCase(ItemStack stack) {
		 ItemMeta meta = stack.getItemMeta();
	        meta.setDisplayName(NameCase());
	        meta.setRarity(ItemRarity.EPIC);
	        stack.setItemMeta(meta);
	}
	public boolean IsGameCase(ItemStack stack) {
		if(stack.hasItemMeta()){
            if((stack.getItemMeta().hasDisplayName())){
                if(stack.getItemMeta().getDisplayName().equalsIgnoreCase(NameCase()) &&
                		stack.getItemMeta().getRarity().equals(ItemRarity.EPIC)){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
	}
	public abstract void Use(LydicPlayer pl);
	public GameCase() {
	
	}

}
