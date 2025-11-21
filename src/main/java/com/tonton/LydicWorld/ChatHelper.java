package com.tonton.LydicWorld;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class ChatHelper {

	public ChatHelper() {
		// TODO Auto-generated constructor stub
	}
	public static String GetNameMainLydoman() {
		return ChatColor.RED+"[ЛУДОМАН47] "+ChatColor.WHITE;
	}
	public static void SendWelcomeMessage(LydicPlayer pl) {
		pl.GetPlayer().sendMessage(GetNameMainLydoman()+"ЗДАРОВА "+pl.GetChatName()+". Добро пожаловать в мир "+GetInfoText("Лудомании",true));
		pl.GetPlayer().sendMessage(GetNameMainLydoman()+"Используй комаду /lydic info, что бы узнать все подробности");
		
	}
	public static String GetColorText(ChatColor color,String string,boolean up) {
		return color+(up?string.toUpperCase():string)+ChatColor.WHITE;
	}
	public static String GetInfoText(String string,boolean up) {
		return GetColorText(ChatColor.YELLOW,string,up);
	}
	public static String GetInfoText(String string) {
		return GetInfoText(string,false);
	}
	public static String GetWarningText(String string,boolean up) {
		return GetColorText(ChatColor.RED,string,up);
	}
	public static String GetWarningText(String string) {
		return GetWarningText(string,false);
	}
	public static String GetWinText(String string,boolean up) {
		return GetColorText(ChatColor.GREEN,string,up);
	}
	public static String GetWinText(String string) {
		return GetWarningText(string,false);
	}
	public static void SendNoMoney(GameCase gameCase,Player pl) {
		pl.sendMessage(GetNameMainLydoman()+GetWarningText("Чел. ",true)+"У тебя недостаточно "+GetInfoText("уровень опыта",true)+". Данный кейс стоит "+GetInfoText(""+gameCase.Cost(),true)+" уровней опыта");
	}
	public static void YouDie(Player pl) {
		pl.sendMessage(GetNameMainLydoman()+GetWarningText("Чел. ",true)+"Ты проебал "+GetWarningText("ВСЁ!",true)+" Ебать ты "+GetWarningText("ЛОШАРА!",true));
	}
	public static void SendHasNotCase(Player pl) {
		pl.sendMessage(GetNameMainLydoman()+GetWarningText("Чел. ",true)+"У нас "+GetWarningText("Нет",true)+" такого кейса");
	}
	public static void SendOnBuyCase(GameCase gameCase,Player pl) {
		pl.sendMessage(GetNameMainLydoman()+GetWarningText("Чел. ",true)+"Ты "+GetWinText("Успешно",true)+" купил кейс "+GetInfoText(gameCase.NameCase(),true));
	}
	public static void WinMobCase(Player pl, EntityType type) {
		pl.sendMessage(GetNameMainLydoman()+"Тебе повезло! Тебе выпал "+GetWarningText(type.toString(),true));
	}
	public static void SendMoreCases(Player pl) {
		pl.sendMessage(GetNameMainLydoman()+GetWarningText("Чел. ",true)+"Слишком много покупок за раз");
	}
	public static void WinOpCase(Player pl,int count) {
		pl.sendMessage(GetNameMainLydoman()+"Тебе повезло! Тебе выпало "+GetWarningText(count+"",true)+" опыта");
}
	public static void WinItemCase(Player pl, ItemStack item) {
		pl.sendMessage(GetNameMainLydoman()+"Тебе повезло! Тебе выпал "+GetWarningText(item.getType().toString(),true)+" в размере "+GetWarningText(""+item.getAmount(),true)+" штук!");
		
	}
	public static void NotWinCase(int count,Player pl) {
		pl.sendMessage(GetNameMainLydoman()+GetWarningText("Чел. ",true)+"Ты "+GetWarningText("Проебал "+count,true)+" опыта");
	}
	public static void SendInfoMessage(Player pl) {
		pl.sendMessage(GetNameMainLydoman()+"При первом спавне ты появляешься на летающем острове, на случаной координате");
		pl.sendMessage(GetNameMainLydoman()+"У тебя есть "+GetInfoText("уровень опыта",true));
		pl.sendMessage(GetNameMainLydoman()+"Используй команду "+GetInfoText("/lydic buy [номер кейса] {колличество кейсов}")+" что бы купить кейс за "+GetInfoText("уровень опыта",true));
		pl.sendMessage(GetNameMainLydoman()+"Используй команду "+GetInfoText("/lydic cases")+" что бы посмотреть кейсы ");
		pl.sendMessage(GetNameMainLydoman()+"При смерти ты теряешь "+GetWarningText("Половину опыта",true));
		pl.sendMessage(GetNameMainLydoman()+"Если у тебя будет "+GetInfoText("меньше 5 уровеня опыта",true)+", то ты спавишься на "+GetInfoText("новом",true)+" сгерированом острове");

		
	}
	public static void SendInfoCasesMessage(Player pl) {
		pl.sendMessage(GetNameMainLydoman()+"0 кейс спавнит тебе "+GetInfoText("Случайного моба",true)+" И стоит "+GetInfoText(""+GameCaseManager.GetManager().GetCase(0).Cost(),true)+" уровней опыта");
		pl.sendMessage(GetNameMainLydoman()+"1 кейс даёт тебе "+GetInfoText("Случайный предмет",true)+" И стоит "+GetInfoText(""+GameCaseManager.GetManager().GetCase(1).Cost(),true)+" уровней опыта");
		pl.sendMessage(GetNameMainLydoman()+"2 кейс даёт/забирает "+GetInfoText("Случайное колличество опыта",true)+" И стоит "+GetInfoText(""+GameCaseManager.GetManager().GetCase(2).Cost(),true)+" уровней опыта");

	}
}
