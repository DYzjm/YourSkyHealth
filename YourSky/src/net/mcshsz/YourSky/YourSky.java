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
		// TODO �Զ����ɵķ������

	}


	


 
	@Override
	public void onEnable(){
		log.info("==================================");
		log.info("=== �ɹ�����YourSky��Ѫ���");
		log.info("=== �����ΪYourSky���ƵĻ�Ѫ���");
		log.info("=== @YourSky ��Ȩ���У�");
		log.info("=== ���Ʋ�����ػ�ʹ�� QQ��1748011755");
		log.info("==================================");
		//getServer().getPluginManager().registerEvents(new Event(), this);
	}
	
	
	
	@Override
	public void onDisable(){
		log.info("==================================");
		log.info("=== �ɹ�ж��YourSky��Ѫ���");
		log.info("=== �����ΪYourSky���ƵĻ�Ѫ���");
		log.info("=== @YourSky ��Ȩ���У�");
		log.info("=== ���Ʋ�����ػ�ʹ�� QQ��1748011755");
		log.info("==================================");
 	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		new command(log).onCommand(sender, cmd, label, args);
		return false;
	}
}
