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
			log.info("您不是玩家哦！");
			return false;
		}
		Player Player = (Player)sender;
		
		
		/**
		 * 
		 * 命令：your
		 * 权限：your.admin
		 */
		if(cmd.getName().equalsIgnoreCase("your")&&(args.length == 0)){
			Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/your 玩家 百分值 &2&l进行百分比加血，替换已有血液！"));
			Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/yourx 玩家 百分值 &2&l血液的基础上进行百分比加血！ "));
			return false;
		}
		if(cmd.getName().equalsIgnoreCase("yourx")&&(args.length == 0)){
			Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/your 玩家 百分值 &2&l进行百分比加血，替换已有血液！"));
			Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/yourx 玩家 百分值 &2&l血液的基础上进行百分比加血！"));
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
					Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/your 玩家 百分值 &2&l进行百分比加血，替换已有血液！"));
					Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l例如： /your "+Player.getName()+"10 &2&l为"+Player.getName()+"设置10%的血液"));
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
					Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l/yourx 玩家 百分值 &2&l血液的基础上进行百分比加血！"));
					Player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&l例如：/yourx "+Player.getName()+" 10 &2&l为"+Player.getName()+"增加10%的血液"));
				}
				return false;
			}
		}
		
		
		return false;
	}
}
