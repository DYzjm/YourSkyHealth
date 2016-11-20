package net.mcshsz.api;

import java.lang.reflect.Constructor;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class API {

	/**
	 * 三维空间方程式
	 * @param AboutHorn getYaw XZ坐标直角三角形角度
	 * @param highHorn  getPitchY坐标直角三角形
	 * @param AB 余边长度
	 * @param X 玩家坐标
	 * @param Y 玩家坐标
	 * @param Z 玩家坐标
	 * @return 余边长度末点坐标
	 */
	public static double[] ABC(double AboutHorn ,double highHorn , double AF, double X, double Y, double Z){

		double AC = AF*AboutHorn;
		double CF = AF*AboutHorn;
		double BF = -(AF*highHorn);//（反转方向）
		//以上AC,CF,BF分别为z坐标差,x坐标差，y坐标差
		double X1 = AC;
		double Y1 = CF;
		double Z1 = BF;
		System.out.println("X1=" + X1 + "," + "Y1=" + Y1 + "," + "Z1=" + Z1);
		/*
		 * 接下来需要将坐标系还原！ TODO
		 */
		double Xa = X+X1;
		double Ya = Y+Y1;
		double Za = Z+Z1;
		double[] ABC={Xa, Ya, Za};
		return (ABC); 
	}
	
	public void tpto(Player Player, double x, double y, double z){
		Location loc = Player.getLocation();
		loc.add(-loc.getBlockX(), -loc.getBlockY(), -loc.getBlockZ());
		loc.setX(x);
		loc.setY(y);
		loc.setZ(z);
		//System.out.println("您的位子：" + loc + "| 传送位子：" + loc.add(0, 0, 0) + "| 您设置的位置：" + x + "," + y + "," + z);
		Player.teleport(loc.add(0, 0, 0));
	}
	
	
	/**
	 * 
	 * @param Player
	 * @param lon
	 * @param higth
	 */
	public static void flame(Player Player, double lon, double higth,float circlePos){
		Location loc = Player.getLocation();
		loc.add(Math.cos(0.5D * circlePos) * lon, higth, Math.sin(0.5D * circlePos) * lon);
		ParticleUtils.display(Particles.FLAME, loc.add(0.0D, 1.0D, 0.0D), 0.0F, 0.0F, 0.0F, 1);
		
	}
	
	/**
	 * 
	 * @param Player
	 * @param lon
	 * @param higth
	 */
	public static void wake(Player Player, double lon, double higth,float circlePos){
		Location loc = Player.getLocation();
		loc.add(Math.cos(0.5D * circlePos) * lon, higth, Math.sin(0.5D * circlePos) * lon);
		ParticleUtils.display(Particles.DRIP_WATER, loc.add(0.0D, 1.0D, 0.0D), 0.0F, 0.0F, 0.0F, 1);
	}
	
	public static void cloud(Player Player, double lon, double higth,float circlePos){
		Location loc = Player.getLocation();
		loc.add(Math.cos(0.5D * circlePos) * lon, higth, Math.sin(0.5D * circlePos) * lon);
		ParticleUtils.display(Particles.CLOUD, loc.add(0.0D, 1.0D, 0.0D), 0.0F, 0.0F, 0.0F, 1);
	}
	
	/**
	 * 伤害攻击类型！
	 * @param loc Location方法-玩家坐标
	 * @param Player 玩家
	 * @param radius 半径
	 * @param Hurt 伤害
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean Health(Location loc, Player Player, double radius, double Hurt) throws InterruptedException{
		//double radius = 5;
		//double Hurt = 0.5D;
		Collection<Entity> play = loc.getWorld().getNearbyEntities(loc, radius, radius, radius);
		for (Entity p :play){
			if(p instanceof Player) {
				Player Pr = (Player)p;
				if(Pr!=Player){
					if(Pr.getHealth()>Hurt){
						Pr.setHealth(Pr.getHealth()-Hurt);
						return false;
					}else{
						//Pr.setHealth(Pr.getHealth()-Pr.getHealth());
						Pr.damage(Pr.getMaxHealth());
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param loc Location方法-玩家坐标
	 * @param Player 玩家
	 * @param radius1 X半径
	 * @param radius2 Y半径
	 * @param radius3 Z半径
	 * @param Hurt 伤害
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean Health(Location loc, Player Player, double radius1, double radius2, double radius3, double Hurt) throws InterruptedException{
		//double radius = 5;
		//double Hurt = 0.5D;
		Collection<Entity> play = loc.getWorld().getNearbyEntities(loc, radius1, radius2, radius3);
		for (Entity p :play){
			if(p instanceof Player) {
				Player Pr = (Player)p;
				if(Pr!=Player){
					if(Pr.getHealth()>Hurt){
						Pr.setHealth(Pr.getHealth()-Hurt);
						return false;
					}else{
						//Pr.setHealth(Pr.getHealth()-Pr.getHealth());
						Pr.damage(Pr.getMaxHealth());
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 这里是全服发送哦！
	 * @param mess
	 */
	public static void sendMessage(String mess){
		for(Player Player :Bukkit.getOnlinePlayers()){
			Player.sendMessage(mess);
		}
	}
	
	
	public static void Title_Player(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle){
		sendTitle(player,fadeIn,stay,fadeOut,title,subtitle);
	}
	
	/**
	 * 集体发送
	 * @param fadeIn 淡出时间 类型：double
	 * @param stay 停留时间 类型：double
	 * @param fadeOut 淡入时间 类型：double
	 * @param title 标题 类型：String
	 * @param subtitle 子标题 类型：String
	 */
	@EventHandler
	public static void Title_Online_Players(Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
		Collection<? extends Player> Players = Bukkit.getOnlinePlayers();
		for(Player p :Players){
			sendTitle(p,fadeIn,stay,fadeOut,title,subtitle);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle){
		try {
			if (title != null) {
		        title = ChatColor.translateAlternateColorCodes('&', title);
		        title = title.replaceAll("%player%", player.getDisplayName());
		        Object enumTitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
		        Object chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] {"{\"text\":\"" + title + "\"}" });
		        Constructor titleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE });
		        Object titlePacket = titleConstructor.newInstance(new Object[] { enumTitle, chatTitle, fadeIn, stay, fadeOut });
		        sendPacket(player, titlePacket);
			}

			if (subtitle != null) {
		        subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
		        subtitle = subtitle.replaceAll("%player%", player.getDisplayName());
		        Object enumSubtitle = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
		        Object chatSubtitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\":\"" + subtitle + "\"}" });
		        Constructor subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(new Class[] { getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE });
		        Object subtitlePacket = subtitleConstructor.newInstance(new Object[] {enumSubtitle, chatSubtitle, fadeIn, stay, fadeOut });
		        sendPacket(player, subtitlePacket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Class<?> getNMSClass(String name) {
		String version = org.bukkit.Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		try {
			return Class.forName("net.minecraft.server." + version + "." + name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void sendPacket(Player player, Object packet) {
		try {
			Object handle = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
			Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
			playerConnection.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(playerConnection, new Object[] { packet });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
