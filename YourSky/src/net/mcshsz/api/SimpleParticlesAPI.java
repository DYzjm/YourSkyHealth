package net.mcshsz.api;


import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class SimpleParticlesAPI implements ParticleAPI{
	private Plugin plugin;

	public SimpleParticlesAPI(Plugin plugin) {
		this.plugin = plugin;
	}

	public void doRepeatEffect(Particles paramParticle, Location paramLocation, float offsetX, float offsetY, float offsetZ, int amount){
		doRepeatEffect(paramParticle, 1, 1, paramLocation, offsetX, offsetY, offsetZ, amount);
	}
 
	public void doRepeatEffect(final Particles paramParticle, int delay, int refreashSpeed, final Location paramLocation, final float offsetX, final float offsetY, final float offsetZ, final int amount){
		new BukkitRunnable(){
			public void run() {
				ParticleUtils.display(paramParticle, paramLocation, offsetX, offsetY, offsetZ, amount);
			}
		}.runTaskTimer(this.plugin, delay, refreashSpeed);
	}

	public void doRepeatEffect(Particles paramParticle, int refreashSpeed, Location paramLocation, float offsetX, float offsetY, float offsetZ, int amount){
		doRepeatEffect(paramParticle, refreashSpeed, refreashSpeed, paramLocation, offsetX, offsetY, offsetZ, amount);
	}

	public void doRepeatEffect(Particles paramParticle, int refreashSpeed, Location paramLocation, int amount){
		doRepeatEffect(paramParticle, refreashSpeed, refreashSpeed, paramLocation, 0.0F, 0.0F, 0.0F, amount);
	}

	public void doRepeatEffect(Particles paramParticle, int refreashSpeed, Location paramLocation){
		doRepeatEffect(paramParticle, refreashSpeed, refreashSpeed, paramLocation, 0.0F, 0.0F, 0.0F, 1);
	}

	public void doEffect(Particles paramParticle, Location paramLocation, float offsetX, float offsetY, float offsetZ, int amount){
		ParticleUtils.display(paramParticle, paramLocation, offsetX, offsetY, offsetZ, amount);
	}

	public void doEffect(Particles paramParticle, Location paramLocation, float offsetX, float offsetY, float offsetZ) {
		doEffect(paramParticle, paramLocation, offsetX, offsetY, offsetZ, 1);
	}
 
	public void doEffect(Particles paramParticle, Location paramLocation, int amount){
		doEffect(paramParticle, paramLocation, 0.0F, 0.0F, 0.0F, amount);
	}

	public void doEffect(Particles paramParticle, Location paramLocation){
		doEffect(paramParticle, paramLocation, 0.0F, 0.0F, 0.0F, 1);
	}
}
