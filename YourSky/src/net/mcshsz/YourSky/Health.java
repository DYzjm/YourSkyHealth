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
		// TODO �Զ����ɵĹ��캯�����
		this.Player = Player;
		this.nuber = nuber;
	}
	
	/**
	 * ������Ұٷֱȼ�Ѫ���滻����ѪҺ��
	 */
	public void HealthS() {
		double MaxHealth = Player.getMaxHealth();//�����Ѫ����
		double percent = ((nuber * 0.01 )*MaxHealth);//��Healths�ٷֱȵļ�Ѫ����
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
	 * �����������Ѫ�İٷֱȼ�Ѫ������ѪҺ�ϼӣ�
	 */
	public void HealthX() {
		// TODO �Զ����ɵĹ��캯�����
		double MaxHealth = Player.getMaxHealth();//�����Ѫ����
		double Health = Player.getHealth();//��ҵ�ǰѪ����
		double getMaxHealth = Player.getMaxHealth()-Player.getHealth();//���ʣ��Ѫ����
		double y = (nuber * 0.01 );
		double percent = (y*getMaxHealth)+Health;//��Healths�ٷֱȵļ�Ѫ����
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
				); 
		t.start();
	}

}
