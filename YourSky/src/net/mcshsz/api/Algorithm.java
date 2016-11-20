package net.mcshsz.api;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;


/**
 * 算法
 * @author Administrator
 *
 */
public class Algorithm {

	
	private static float circlePos = 0.0F;
	private static float circlePoss = 0.0F;

	/**
	 * 火焰气罩算法
	 * @param sender
	 * @throws InterruptedException
	 */
	public static void  flamex(CommandSender sender) throws InterruptedException{
		Player Player = (Player)sender;
		double higth = -1.0D;
		double lon = 1.0D;
		double topd = 0.0D;
		double higths = 1.3D;
		double lons = -1.0D;
		double xias = 0.0D;
		
		for (int i=0; i<=100; i++){
			Thread.sleep(50);
			topd = topd+0.1D;
			API.flame(Player, (topd+0.1D), -1.0D, circlePos);
			if(topd >=3.0D){
				topd = 0.0D;
			}
			API.flame(Player, 1.0D, -1.0D, circlePos);
			API.flame(Player, lon, (higth), circlePos);
			higth = higth + 0.05D;
			if (higth >= 1.3D){
				higth = -1.0D;
				lon = 1.0D;
			}
			circlePos = (float)(circlePos + 2.0D);
			//
			xias = xias+0.1D;
			API.flame(Player, (xias+0.1D) , 1.3D, circlePoss);
			if(xias >=1.0D){
				xias = 0.0D;
			}
			API.flame(Player, -1.0D, 1.3D, circlePoss);
			API.flame(Player, lons, (higths), circlePoss);
			higths = (higths-0.05D);
			if ( higths <= -1.0){
				higths = 1.3D;
				lons = -1.0D;
			}
			circlePoss = (float)(circlePoss + 1.3D);
			//
		}
	}

	public static void  flameq(CommandSender sender) throws InterruptedException{
		Player Player = (Player)sender;
		float offset = 0;
		int amount=20;
		double Ahead=10;
		Location location = Player.getLocation();
		//for (int i=0; i<=500; i++){
			Thread.sleep(10);
			new Algorithm();
			double[] ABC = API.ABC(location.getYaw(),location.getPitch(),Ahead,location.getX(),location.getY(),location.getZ());
			System.out.println("X=" + location.getX() + "," + "Y=" + location.getY() + "," + "Z=" + location.getZ());
			location.setX(ABC[0]);
			location.setY(ABC[1]);
			location.setZ(ABC[2]);
			
			System.out.println("X=" + ABC[0] + "," + "Y=" + ABC[1] + "," + "Z=" + ABC[2]);
			System.out.println("Yaw=" + location.getYaw());
			System.out.println("Pitch=" + location.getPitch());
			//System.out.println("location=" + location);
			
			//Vector look = new Vector(Math.cos(location.getYaw() * Math.cos(location.getPitch())), Math.sin(location.getYaw()) * Math.cos(location.getPitch()), Math.sin(location.getPitch()));
			
			for (int i=0; i<=500; i++){
			ParticleUtils.display(Particles.FLAME, location.add(0, 0, 0), offset, offset, offset, amount);
			Thread.sleep(100);
			}
			circlePos = (float)(circlePos + 2.0D);
			Ahead=Ahead+0.3;
			//
		//}
	
	
	}
	
	
	
	/**
	 * 水气罩算法
	 * @param sender
	 * @throws InterruptedException
	 */
	public static void bubble(CommandSender sender) throws InterruptedException {
		// TODO 自动生成的方法存根
		Player Player = (Player)sender;
		double higth = -1.0D;
		double lon = 1.0D;
		double topd = 0.0D;
		double higths = 1.3D;
		double lons = -1.0D;
		double xias = 0.0D;
		for (int i=0; i<=100; i++){
			//
			Thread.sleep(50);
			topd = topd+0.1D;
			API.wake(Player, topd, -1.0D, circlePos);
			if(topd >=3.0D){
				topd = 0.0D;
			}
			API.wake(Player, 1.0D, -1.0D, circlePos);
			API.wake(Player, lon, higth, circlePos);
			higth = higth + 0.05D;
			if ( higth >= 1.3D){
				higth = -1.0D;
				lon = 1.0D;
			}
			circlePos = (float)(circlePos + 2.0D);
			//
			xias = xias+0.1D;
			API.wake(Player, xias , 1.3D, circlePoss);
			if(xias >=1.0D){
				xias = 0.0D;
			}
			API.wake(Player, -1.0D, 1.3D, circlePoss);
			API.wake(Player, lons, higths, circlePoss);
			higths = (higths-0.05D);
			if ( higths <= -1.0){
				higths = 1.3D;
				lons = -1.0D;
			}
			circlePoss = (float)(circlePoss + 1.3D);
			//
		}
	}
	
	public static void cloud(CommandSender sender) throws InterruptedException {
		// TODO 自动生成的方法存根
		Player Player = (Player)sender;
		double higth = -1.0D;
		double lon = 1.0D;
		double topd = 0.0D;
		double higths = 1.3D;
		double lons = -1.0D;
		double xias = 0.0D;
		for (int i=0; i<=100; i++){
			//
			Thread.sleep(50);
			topd = topd+0.1D;
			API.cloud(Player, topd, -1.0D, circlePos);
			if(topd >=3.0D){
				topd = 0.0D;
			}
			API.cloud(Player, 1.0D, -1.0D, circlePos);
			API.cloud(Player, lon, higth, circlePos);
			higth = higth + 0.05D;
			if ( higth >= 1.3D){
				higth = -1.0D;
				lon = 1.0D;
			}
			circlePos = (float)(circlePos + 2.0D);
			//
			xias = xias+0.1D;
			API.cloud(Player, xias , 1.3D, circlePoss);
			if(xias >=1.0D){
				xias = 0.0D;
			}
			API.cloud(Player, -1.0D, 1.3D, circlePoss);
			API.cloud(Player, lons, higths, circlePoss);
			higths = (higths-0.05D);
			if ( higths <= -1.0){
				higths = 1.3D;
				lons = -1.0D;
			}
			circlePoss = (float)(circlePoss + 1.3D);
			//
		}
	}
	
	
	//220 73 384
	@SuppressWarnings("static-access")
	public static void xyc() throws InterruptedException {
		Location location = new Location(Bukkit.getWorld("world"), 220.5, 73, 384.5,0,0);
		
		location.setWorld(Bukkit.getWorld("world"));
		location.setX(220.5);
		location.setY(73);
		location.setZ(384.5);
		location.setYaw(0);
		location.setPitch(0);

		int iu=0;
		int nu=0;
		int help=0;
		while (true){
			Collection<Entity> play = location.getWorld().getNearbyEntities(location, 7, 7, 7);
			Thread.sleep(100);
			ParticleUtils.display(Particles.FLAME, location, 6, 15, 6, 30);
			ParticleUtils.display(Particles.WATER_SPLASH, location, nu, 0, nu, 50);
			ParticleUtils.display(Particles.FIREWORKS_SPARK, location, iu, (iu+1), iu, 50);
			iu++;
			nu++;
			help++;
			if(iu>=5){
				iu=0;
			}
			if(nu>=6){
				nu=0;
			}
			
			for (Entity p :play){
				if(p instanceof Player) {
					Player player = (Player)p;
					if(player.getLevel()<=31){//5级一重
						new API().tpto(player,232,72,384);
						new API().Title_Player(player, 3, 2, 3, "", "&e您需要四重斗气或中级魔法师的实力");
					}else{
						if(help>=200){
							help=0;
							//Funt(location, player);
							if(player.getLevel()>=31){//5级一重
								double Hurt=(player.getMaxHealth()*0.05D);
								if(player.getHealth()<=player.getMaxHealth()){
									if(player.getHealth()>=((player.getMaxHealth()-Hurt))){
										player.setHealth(player.getMaxHealth());
									}else{
										player.setHealth(player.getHealth()+Hurt);
										new API().Title_Player(player, 3, 2, 3, "", "&6光明魔法师为你施展了——神之祝福");
									}
								}
							}
						}
					}
				}
			}
			
		}
	}
}
