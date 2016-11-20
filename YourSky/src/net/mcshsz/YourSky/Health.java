package net.mcshsz.YourSky;

import java.text.NumberFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
 
import net.mcshsz.api.Algorithm;

public class Health implements Listener{

	private Player Player;
	private int nuber;

	public Health(Player Player, int nuber) {
		// TODO 自动生成的构造函数存根
		this.Player = Player;
		this.nuber = nuber;
	}
	
	/**
	 * 按照玩家百分比加血（替换已有血液）
	 */
	public void HealthS() {
		double MaxHealth = Player.getMaxHealth();//玩家总血量！
		double percent = ((nuber * 0.01 )*MaxHealth);//求Healths百分比的加血量！
		if(percent>MaxHealth){
			percent=MaxHealth;
		}
		Player.setHealth(percent);
		Thread t = new Thread(new Runnable(){
			public void run() {
				try {
					Algorithm.flamex(Player);
					//Algorithm.cloud(Player);
					//Algorithm.bubble(Player);
					//Algorithm.flamex(Player);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
				); 
		t.start();
	}
	/**
	 * 按照玩家已有血的百分比加血（已有血液上加）
	 */
	public void HealthX() {
		// TODO 自动生成的构造函数存根
		double MaxHealth = Player.getMaxHealth();//玩家总血量！
		double Health = Player.getHealth();//玩家当前血量！
		double getMaxHealth = Player.getMaxHealth()-Player.getHealth();//玩家剩余血量！
		double y = (nuber * 0.01 );
		double percent = (y*getMaxHealth)+Health;//求Healths百分比的加血量！
		if(percent>MaxHealth){
			percent=MaxHealth;
		}
		Player.setHealth(percent);
		Thread t = new Thread(new Runnable(){
			public void run() {
				try {
					Algorithm.cloud(Player);	
					//Algorithm.cloud(Player);
					//Algorithm.bubble(Player);
					//Algorithm.flamex(Player);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
				); 
		t.start();
	}

}
