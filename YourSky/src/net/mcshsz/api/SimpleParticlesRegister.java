package net.mcshsz.api;

import org.bukkit.plugin.Plugin;

public class SimpleParticlesRegister{
	private Plugin plugin;

	public SimpleParticlesRegister(Plugin plugin){
		this.plugin = plugin;
	}

	public ParticleAPI getApi() {
		return new SimpleParticlesAPI(this.plugin);
	}
}