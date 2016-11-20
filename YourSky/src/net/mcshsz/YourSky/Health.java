package net.mcshsz.YourSky;

import java.text.NumberFormat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

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
		//输出一下，确认你的小数无误
		System.out.println("正在加血：" + percent);
		//获取格式化对象

		//最后格式化并输出
		Player.setHealth(percent);
		System.out.println("成功加血：" + percent);
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
		//输出一下，确认你的小数无误
		if(percent>MaxHealth){
			percent=MaxHealth;
		}
		System.out.println("正在加血：" + percent);
		//获取格式化对象

		//最后格式化并输出
		Player.setHealth(percent);
		System.out.println("成功加血：" + percent);
	}

}
