package net.mcshsz.Command;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.mcshsz.YourSky.Health;

public class command implements Listener{

	private Logger log ;
	
	public command(Logger log) {
		this.log = log;
	}

	/**
	 * 
	 * @param sender
	 * @param cmd
	 * @param label
	 * @param args
	 * @return
	 */
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

		if (!(sender instanceof Player)) {
			log.info("���������Ŷ��");
			return false;
		}
		Player Player = (Player)sender;
		
		
		/**
		 * 
		 * ���your
		 * Ȩ�ޣ�your.admin
		 */
		if(cmd.getName().equalsIgnoreCase("your")&&(args.length == 0)){
			Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/your ��� �ٷ�ֵ &2&l���аٷֱȼ�Ѫ���滻����ѪҺ��"));
			Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/yourx ��� �ٷ�ֵ &2&lѪҺ�Ļ����Ͻ��аٷֱȼ�Ѫ�� "));
			return false;
		}
		if(cmd.getName().equalsIgnoreCase("yourx")&&(args.length == 0)){
			Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/your ��� �ٷ�ֵ &2&l���аٷֱȼ�Ѫ���滻����ѪҺ��"));
			Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/yourx ��� �ٷ�ֵ &2&lѪҺ�Ļ����Ͻ��аٷֱȼ�Ѫ��"));
			return false;
		}
		
		if ((cmd.getName().equalsIgnoreCase("your"))&& Player.hasPermission("your.admin")){
			if ((args.length == 2)) {
				try{
					int i = Integer.parseInt(args[1]);
					Health Health = new Health(Bukkit.getPlayer(args[0]), i);
					Health.HealthS();
					return true; 
				}catch (Exception e) {
					Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/your ��� �ٷ�ֵ &2&l���аٷֱȼ�Ѫ���滻����ѪҺ��"));
					Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l���磺 /your "+Player.getName()+"10 &2&lΪ"+Player.getName()+"����10%��ѪҺ"));
				}
				return false;
			}
		}

		if((cmd.getName().equalsIgnoreCase("yourx"))&& Player.hasPermission("yourx.admin")){
			if ((args.length == 2)) {
				try{
					int i = Integer.parseInt(args[1]);
					Health Health = new Health(Bukkit.getPlayer(args[0]), i);
					Health.HealthX();
					return true; 
					
				}catch (Exception e) {
					Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/yourx ��� �ٷ�ֵ &2&lѪҺ�Ļ����Ͻ��аٷֱȼ�Ѫ��"));
					Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l���磺/yourx "+Player.getName()+" 10 &2&lΪ"+Player.getName()+"����10%��ѪҺ"));
				}
				return false;
			}
		}
		
		
		return false;
	}
}
