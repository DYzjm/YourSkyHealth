package net.mcshsz.YourSky;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.mcshsz.Command.command;

public class YourSky extends JavaPlugin implements Listener{
	
	private Logger log = Bukkit.getLogger();
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}


	


 
	@Override
	public void onEnable(){
		log.info("==================================");
		log.info("=== 成功加载YourSky回血插件");
		log.info("=== 本插件为YourSky定制的回血插件");
		log.info("=== @YourSky 版权所有！");
		log.info("=== 定制插件找守护使者 QQ：1748011755");
		log.info("==================================");
		//getServer().getPluginManager().registerEvents(new Event(), this);
	}
	
	
	
	@Override
	public void onDisable(){
		log.info("==================================");
		log.info("=== 成功卸载YourSky回血插件");
		log.info("=== 本插件为YourSky定制的回血插件");
		log.info("=== @YourSky 版权所有！");
		log.info("=== 定制插件找守护使者 QQ：1748011755");
		log.info("==================================");
 	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		new command(log).onCommand(sender, cmd, label, args);
		return false;
	}
}
