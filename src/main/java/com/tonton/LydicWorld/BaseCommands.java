package com.tonton.LydicWorld;

import java.beans.Expression;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BaseCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		Player player;
		if(!(arg0 instanceof Player))
			return false;
		 player = (Player) arg0;
		if(arg2.equals("lydic")&&arg3.length>0) {
			switch(arg3[0]) {
			case "info":
				ChatHelper.SendInfoMessage(player);
				break;
			case "cases":
				ChatHelper.SendInfoCasesMessage(player);
				break;
			case "create":
				PlotCreator.CreatePlot(player);
				break;
			case "buy":
				try {
					int id=Integer.parseInt(arg3[1]);
					int count=1;
					if(arg3.length==3) 
						count=Integer.parseInt(arg3[2]);
					GameCase gameCase=GameCaseManager.GetManager().GetCase(id);
					
					if(gameCase instanceof NullGameCase) {
						ChatHelper.SendHasNotCase(player);
						break;
					}
					gameCase.Give(LydicPlayerManager.GetManager().GetLydic(player.getUniqueId()),count);
					
				} catch (Exception  ex) {
					ChatHelper.SendHasNotCase(player);
					return false;
				}
				break;
			}
			
		}
		
		return true;
	}
	

}
