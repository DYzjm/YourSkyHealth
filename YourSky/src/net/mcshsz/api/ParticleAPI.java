package net.mcshsz.api;

import org.bukkit.Location;


public abstract interface ParticleAPI{
  public void doRepeatEffect(Particles paramParticles, Location paramLocation, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);

  public void doRepeatEffect(Particles paramParticles, int paramInt1, int paramInt2, Location paramLocation, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt3);

  public void doRepeatEffect(Particles paramParticles, int paramInt1, Location paramLocation, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2);

  public void doRepeatEffect(Particles paramParticles, int paramInt1, Location paramLocation, int paramInt2);

  public void doRepeatEffect(Particles paramParticles, int paramInt, Location paramLocation);

  public void doEffect(Particles paramParticles, Location paramLocation, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);

  public void doEffect(Particles paramParticles, Location paramLocation, float paramFloat1, float paramFloat2, float paramFloat3);

  public void doEffect(Particles paramParticles, Location paramLocation, int paramInt);

  public void doEffect(Particles paramParticles, Location paramLocation);
}
