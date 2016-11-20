package net.mcshsz.api;

import java.util.Random;

import org.bukkit.Location;

public class ParticleUtils{
	
	/**
	 * 
	 * @param effect
	 * @param location
	 * @param amount
	 * @param speed
	 */
	public static void display(Particles effect, Location location, int amount, float speed){
		effect.display(0.0F, 0.0F, 0.0F, speed, amount, location, 128.0D);
	}

	/**
	 * 
	 * @param effect
	 * @param location
	 * @param amount
	 */
	public static void display(Particles effect, Location location, int amount){
		if (effect == Particles.NOTE) {
			int i = 0; if (i < amount) {
				effect.display(new Particles.NoteColor(new Random().nextInt(24) + 1), location, 128.0D);
				return;
			}
		}
		effect.display(0.0F, 0.0F, 0.0F, 0.0F, amount, location, 128.0D);
	}

	/**
	 * 
	 * @param effect
	 * @param location
	 * @param offsetX
	 * @param offsetY
	 * @param offsetZ
	 * @param amount
	 */
	public static void display(Particles effect, Location location, float offsetX, float offsetY, float offsetZ, int amount){
		if (effect == Particles.NOTE) {
			effect.display(new Particles.NoteColor(new Random().nextInt(24) + 1), location, 512.0D);
			return;
		}
		effect.display(offsetX, offsetY, offsetZ, 0.0F, amount, location, 512.0D);
	}

	/**
	 * 
	 * @param effect
	 * @param location
	 */
	public static void display(Particles effect, Location location){
		display(effect, location, 1);
	}

	/**
	 * 
	 * @param effect
	 * @param x
	 * @param y
	 * @param z
	 * @param location
	 * @param amount
	 */
	public static void display(Particles effect, double x, double y, double z, Location location, int amount){
		if (effect == Particles.NOTE) {
			int i = 0; if (i < amount) {
				effect.display(new Particles.NoteColor(new Random().nextInt(24) + 1), location, 128.0D);
				return;
			}
		}
		effect.display((float)x, (float)y, (float)z, 0.0F, amount, location, 128.0D);
	}

	/**
	 * 
	 * @param effect
	 * @param red
	 * @param green
	 * @param blue
	 * @param location
	 * @param amount
	 */
	public static void display(Particles effect, int red, int green, int blue, Location location, int amount){
		if (effect == Particles.NOTE) {
			int i = 0; if (i < amount) {
				effect.display(new Particles.NoteColor(new Random().nextInt(24) + 1), location, 128.0D);
				return;
			}
		}
		for (int i = 0; i < amount; i++)
			effect.display(new Particles.OrdinaryColor(red, green, blue), location, 128.0D);
	}

	/**
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 * @param location
	 */
	public static void display(int red, int green, int blue, Location location){
		display(Particles.REDSTONE, red, green, blue, location, 1);
	}

	/**
	 * 
	 * @param effect
	 * @param red
	 * @param green
	 * @param blue
	 * @param location
	 */
	public static void display(Particles effect, int red, int green, int blue, Location location){
		if (effect == Particles.NOTE) {
			int i = 0; if (i < 1) {
				effect.display(new Particles.NoteColor(new Random().nextInt(24) + 1), location, 128.0D);
				return;
			}
		}
		display(effect, red, green, blue, location, 1);
	}
}

