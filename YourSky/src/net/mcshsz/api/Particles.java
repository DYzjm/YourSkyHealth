package net.mcshsz.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@SuppressWarnings({ "unchecked", "rawtypes" })
public enum Particles
{
	EXPLOSION_NORMAL("explode", 0, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //爆炸_正常DIRECTIONAL
	EXPLOSION_LARGE("largeexplode", 1, -1, new ParticleProperty[0]), //大爆�??
	EXPLOSION_HUGE("hugeexplosion", 2, -1, new ParticleProperty[0]), //巨大爆炸
	FIREWORKS_SPARK("fireworksSpark", 3, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //烟花_火花
	WATER_BUBBLE("bubble", 4, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL, ParticleProperty.REQUIRES_WATER }), //水_泡沫 (必须在水�??)
	WATER_SPLASH("splash", 5, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //水_飞溅
	WATER_WAKE("wake", 6, 7, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //水_醒来
	SUSPENDED("suspended", 7, -1, new ParticleProperty[] { ParticleProperty.REQUIRES_WATER }), //暂停�???
	SUSPENDED_DEPTH("depthSuspend", 8, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //悬浮_深度
	CRIT("crit", 9, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //暴击
	CRIT_MAGIC("magicCrit", 10, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //魔法暴击
	SMOKE_NORMAL("smoke", 11, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //烟_正常
	SMOKE_LARGE("largesmoke", 12, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //烟_�???
	SPELL("spell", 13, -1, new ParticleProperty[0]), //咒语
	SPELL_INSTANT("instantSpell", 14, -1, new ParticleProperty[0]), //瞬间咒语
	SPELL_MOB("mobSpell", 15, -1, new ParticleProperty[] { ParticleProperty.COLORABLE }), //暴徒的咒�??
	SPELL_MOB_AMBIENT("mobSpellAmbient", 16, -1, new ParticleProperty[] { ParticleProperty.COLORABLE }), //怪物的法术_ _环境
	SPELL_WITCH("witchMagic", 17, -1, new ParticleProperty[0]), //女巫的咒�??
	DRIP_WATER("dripWater", 18, -1, new ParticleProperty[0]), //滴_�??
	DRIP_LAVA("dripLava", 19, -1, new ParticleProperty[0]), //熔岩�??
	VILLAGER_ANGRY("angryVillager", 20, -1, new ParticleProperty[0]), 
	VILLAGER_HAPPY("happyVillager", 21, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), 
	TOWN_AURA("townaura", 22, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //镇_光环
	NOTE("note", 23, -1, new ParticleProperty[] { ParticleProperty.COLORABLE }), 
	PORTAL("portal", 24, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), 
	ENCHANTMENT_TABLE("enchantmenttable", 25, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //魅力_�??
	FLAME("flame", 26, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //火焰
	LAVA("lava", 27, -1, new ParticleProperty[0]), //熔岩
	FOOTSTEP("footstep", 28, -1, new ParticleProperty[0]), //脚步
	CLOUD("cloud", 29, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //�??
	REDSTONE("reddust", 30, -1, new ParticleProperty[] { ParticleProperty.COLORABLE }), //红石
	SNOWBALL("snowballpoof", 31, -1, new ParticleProperty[0]), //雪球
	SNOW_SHOVEL("snowshovel", 32, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL }), //铲雪
	SLIME("slime", 33, -1, new ParticleProperty[0]), //�??
	HEART("heart", 34, -1, new ParticleProperty[0]), 
	BARRIER("barrier", 35, 8, new ParticleProperty[0]), 
	ITEM_CRACK("iconcrack", 36, -1, new ParticleProperty[] { ParticleProperty.DIRECTIONAL, ParticleProperty.REQUIRES_DATA }), 
	BLOCK_CRACK("blockcrack", 37, -1, new ParticleProperty[] { ParticleProperty.REQUIRES_DATA }), 
	BLOCK_DUST("blockdust", 38, 7, new ParticleProperty[] { ParticleProperty.DIRECTIONAL, ParticleProperty.REQUIRES_DATA }), 
	WATER_DROP("droplet", 39, 8, new ParticleProperty[0]), 
	ITEM_TAKE("take", 40, 8, new ParticleProperty[0]), 
	MOB_APPEARANCE("mobappearance", 41, 8, new ParticleProperty[0]), 
	DRAGON_BREATH("dragonbreath", 42, 9, new ParticleProperty[0]), 
	END_ROD("endRod", 43, 9, new ParticleProperty[0]), 
	DAMAGE_INDICATOR("damageIndicator", 44, 9, new ParticleProperty[0]), 
	SWEEP_ATTACK("sweepAttack", 45, 9, new ParticleProperty[0]);//new ParticleProperty[0]

	private static final Map<String, Particles> NAME_MAP;
	private static final Map<Integer, Particles> ID_MAP;
	private final String name;
	private final int id;
	private final int requiredVersion;
	private final List<ParticleProperty> properties;

	static
	{
		NAME_MAP = new HashMap();
		ID_MAP = new HashMap();
		for (Particles effect : values())
		{
			NAME_MAP.put(effect.name, effect);
			ID_MAP.put(Integer.valueOf(effect.id), effect);
		}
	}
	
	public static Particles getParticleByName(String name) { for (Particles particle : values()) {
		if (particle.getName().equals(name)) {
			return particle;
		}
	}
	return null;
	}

	private Particles(String name, int id, int requiredVersion, ParticleProperty[] properties)
	{
		this.name = name;
		this.id = id;
		this.requiredVersion = requiredVersion;
		this.properties = Arrays.asList(properties);
	}

	public String getName()
	{
		return this.name;
	}

	public int getId()
	{
		return this.id;
	}

	public boolean hasProperty(ParticleProperty property)
	{
		return this.properties.contains(property);
	}

	public boolean isSupported()
	{
		if (this.requiredVersion == -1) {
			return true;
		}
		return ParticlePacket.getVersion() >= this.requiredVersion;
	}

	private static boolean isWater(Location location)
	{
		Material material = location.getBlock().getType();
		return (material == Material.WATER) || (material == Material.STATIONARY_WATER);
	}

	private static boolean isLongDistance(Location location, List<Player> players)
	{
		String world = location.getWorld().getName();
		for (Player player : players)
		{
			Location playerLocation = player.getLocation();
			if ((world.equals(playerLocation.getWorld().getName())) && (playerLocation.distanceSquared(location) >= 65536.0D)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isDataCorrect(Particles effect, ParticleData data)
	{
		return ((effect != BLOCK_CRACK) && (effect != BLOCK_DUST)) || ((data instanceof BlockData)) || ((effect == ITEM_CRACK) && ((data instanceof ItemData)));
	}

	private static boolean isColorCorrect(Particles effect, ParticleColor color)
	{
		return ((effect != SPELL_MOB) && (effect != SPELL_MOB_AMBIENT) && (effect != REDSTONE)) || ((color instanceof OrdinaryColor)) || ((effect == NOTE) && ((color instanceof NoteColor)));
	}

	public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, double range)
	throws Particles.ParticleVersionException, Particles.ParticleDataException, IllegalArgumentException
	{
		if (!isSupported()) {
			throw new ParticleVersionException();
		}
		if (hasProperty(ParticleProperty.REQUIRES_DATA)) {
			throw new ParticleDataException();
		}
		if ((hasProperty(ParticleProperty.REQUIRES_WATER)) && (!isWater(center))) {
			throw new IllegalArgumentException("There is no water at the center location");
		}
		new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, range > 256.0D, null).sendTo(center, range);
	}

	public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, List<Player> players)
	throws Particles.ParticleVersionException, Particles.ParticleDataException, IllegalArgumentException
	{
		if (!isSupported()) {
			throw new ParticleVersionException();
		}
		if (hasProperty(ParticleProperty.REQUIRES_DATA)) {
			throw new ParticleDataException();
		}
		if ((hasProperty(ParticleProperty.REQUIRES_WATER)) && (!isWater(center))) {
			throw new IllegalArgumentException("There is no water at the center location");
		}
		new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, isLongDistance(center, players), null).sendTo(center, players);
	}

	public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, Player[] players)
    throws Particles.ParticleVersionException, Particles.ParticleDataException, IllegalArgumentException
	{
		display(offsetX, offsetY, offsetZ, speed, amount, center, Arrays.asList(players));
	}

	public void display(Vector direction, float speed, Location center, double range)
    throws Particles.ParticleVersionException, Particles.ParticleDataException, IllegalArgumentException
	{
		if (!isSupported()) {
			throw new ParticleVersionException();
		}
		if (hasProperty(ParticleProperty.REQUIRES_DATA)) {
			throw new ParticleDataException();
		}
		if (!hasProperty(ParticleProperty.DIRECTIONAL)) {
			throw new IllegalArgumentException("This particle effect is not directional");
		}
		if ((hasProperty(ParticleProperty.REQUIRES_WATER)) && (!isWater(center))) {
			throw new IllegalArgumentException("There is no water at the center location");
		}
		new ParticlePacket(this, direction, speed, range > 256.0D, null).sendTo(center, range);
	}

	public void display(Vector direction, float speed, Location center, List<Player> players)
			throws Particles.ParticleVersionException, Particles.ParticleDataException, IllegalArgumentException
	{
		if (!isSupported()) {
			throw new ParticleVersionException();
		}
		if (hasProperty(ParticleProperty.REQUIRES_DATA)) {
			throw new ParticleDataException();
		}
		if (!hasProperty(ParticleProperty.DIRECTIONAL)) {
			throw new IllegalArgumentException("This particle effect is not directional");
		}
		if ((hasProperty(ParticleProperty.REQUIRES_WATER)) && (!isWater(center))) {
			throw new IllegalArgumentException("There is no water at the center location");
		}
		new ParticlePacket(this, direction, speed, isLongDistance(center, players), null).sendTo(center, players);
	}

	public void display(Vector direction, float speed, Location center, Player[] players)
    throws Particles.ParticleVersionException, Particles.ParticleDataException, IllegalArgumentException
	{
		display(direction, speed, center, Arrays.asList(players));
	}

	public void display(ParticleColor color, Location center, double range)
	throws Particles.ParticleVersionException, Particles.ParticleColorException
	{
		if (!isSupported()) {
			throw new ParticleVersionException();
		}
		if (!hasProperty(ParticleProperty.COLORABLE)) {
			throw new ParticleColorException();
		}
		if (!isColorCorrect(this, color)) {
			throw new ParticleColorException();
		}
		new ParticlePacket(this, color, range > 256.0D).sendTo(center, range);
	}

	public void display(ParticleColor color, Location center, List<Player> players)
	throws Particles.ParticleVersionException, Particles.ParticleColorException
	{
		if (!isSupported()) {
			throw new ParticleVersionException();
		}
		if (!hasProperty(ParticleProperty.COLORABLE)) {
			throw new ParticleColorException();
		}
		if (!isColorCorrect(this, color)) {
			throw new ParticleColorException();
		}
		new ParticlePacket(this, color, isLongDistance(center, players)).sendTo(center, players);
	}

	public void display(ParticleColor color, Location center, Player[] players)
    throws Particles.ParticleVersionException, Particles.ParticleColorException
	{
		display(color, center, Arrays.asList(players));
	}

	public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, double range)
    throws Particles.ParticleVersionException, Particles.ParticleDataException
	{
		if (!isSupported()) {
			throw new ParticleVersionException();
		}
		if (!hasProperty(ParticleProperty.REQUIRES_DATA)) {
			throw new ParticleDataException();
		}
		if (!isDataCorrect(this, data)) {
			throw new ParticleDataException();
		}
		new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, range > 256.0D, data).sendTo(center, range);
	}

	public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, List<Player> players)
    throws Particles.ParticleVersionException, Particles.ParticleDataException
	{
		if (!isSupported()) {
			throw new ParticleVersionException();
		}
		if (!hasProperty(ParticleProperty.REQUIRES_DATA)) {
			throw new ParticleDataException();
		}
		if (!isDataCorrect(this, data)) {
			throw new ParticleDataException();
		}
		new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, isLongDistance(center, players), data).sendTo(center, players);
	}

	public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, Player[] players)
    throws Particles.ParticleVersionException, Particles.ParticleDataException
	{
		display(data, offsetX, offsetY, offsetZ, speed, amount, center, Arrays.asList(players));
	}

	public void display(ParticleData data, Vector direction, float speed, Location center, double range)
	throws Particles.ParticleVersionException, Particles.ParticleDataException
	{
		if (!isSupported()) {
			throw new ParticleVersionException();
		}
		if (!hasProperty(ParticleProperty.REQUIRES_DATA)) {
			throw new ParticleDataException();
		}
		if (!isDataCorrect(this, data)) {
			throw new ParticleDataException();
		}
		new ParticlePacket(this, direction, speed, range > 256.0D, data).sendTo(center, range);
	}

	public void display(ParticleData data, Vector direction, float speed, Location center, List<Player> players)
    throws Particles.ParticleVersionException, Particles.ParticleDataException
	{
		if (!isSupported()) {
			throw new ParticleVersionException();
		}
		if (!hasProperty(ParticleProperty.REQUIRES_DATA)) {
			throw new ParticleDataException();
		}
		if (!isDataCorrect(this, data)) {
			throw new ParticleDataException();
		}
		new ParticlePacket(this, direction, speed, isLongDistance(center, players), data).sendTo(center, players);
 	}

	public void display(ParticleData data, Vector direction, float speed, Location center, Player[] players)
    throws Particles.ParticleVersionException, Particles.ParticleDataException
	{
		display(data, direction, speed, center, Arrays.asList(players));
	}

	

	public static class ReflectionUtils
	{
		public static Constructor<?> getConstructor(Class<?> clazz, Class<?>[] parameterTypes)
	throws NoSuchMethodException
		{
			Class[] primitiveTypes = DataType.getPrimitive(parameterTypes);
			for (Constructor constructor : clazz.getConstructors())
				if (DataType.compare(DataType.getPrimitive(constructor.getParameterTypes()), primitiveTypes))
				{
					return constructor;
				}
			throw new NoSuchMethodException("There is no such constructor in this class with the specified parameter types");
		}

		public static Method getMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes)
				throws NoSuchMethodException
		{
			Class[] primitiveTypes = DataType.getPrimitive(parameterTypes);
			for (Method method : clazz.getMethods())
				if ((method.getName().equals(methodName)) && (DataType.compare(DataType.getPrimitive(method.getParameterTypes()), primitiveTypes)))
				{
					return method;
				}
			throw new NoSuchMethodException("There is no such method in this class with the specified name and parameter types");
		}

		public static Method getMethod(String className, PackageType packageType, String methodName, Class<?>[] parameterTypes)
				throws NoSuchMethodException, ClassNotFoundException
		{
			return getMethod(packageType.getClass(className), methodName, parameterTypes);
		}

		public static Field getField(Class<?> clazz, boolean declared, String fieldName)
				throws NoSuchFieldException, SecurityException
		{
			Field field = declared ? clazz.getDeclaredField(fieldName) : clazz.getField(fieldName);
			field.setAccessible(true);
			return field;
		}

		public static Field getField(String className, PackageType packageType, boolean declared, String fieldName)
				throws NoSuchFieldException, SecurityException, ClassNotFoundException
		{
			return getField(packageType.getClass(className), declared, fieldName);
		}

		public static void setValue(Object instance, Class<?> clazz, boolean declared, String fieldName, Object value)
				throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException
		{
			getField(clazz, declared, fieldName).set(instance, value);
		}

		public static void setValue(Object instance, boolean declared, String fieldName, Object value)
				throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException
		{
			setValue(instance, instance.getClass(), declared, fieldName, value);
		}

		public static enum PackageType
		{
			MINECRAFT_SERVER("net.minecraft.server." + getServerVersion()), 
			CRAFTBUKKIT("org.bukkit.craftbukkit." + getServerVersion()), 
			CRAFTBUKKIT_ENTITY(CRAFTBUKKIT, "entity");

			private final String path;

			private PackageType(String path)
			{
				this.path = path;
			}

			private PackageType(PackageType parent, String path)
			{
				this(parent + "." + path);
			}

			public Class<?> getClass(String className)
					throws ClassNotFoundException
			{
				return Class.forName(this + "." + className);
			}

			public String toString()
			{
				return this.path;
			}

			public static String getServerVersion()
			{
				return Bukkit.getServer().getClass().getPackage().getName().substring(23);
			}
		}

		public static enum DataType
		{
			BYTE(Byte.TYPE, Byte.class), 
			SHORT(Short.TYPE, Short.class), 
			INTEGER(Integer.TYPE, Integer.class), 
			LONG(Long.TYPE, Long.class), 
			CHARACTER(Character.TYPE, Character.class), 
			FLOAT(Float.TYPE, Float.class), 
			DOUBLE(Double.TYPE, Double.class), 
			BOOLEAN(Boolean.TYPE, Boolean.class);

			private static final Map<Class<?>, DataType> CLASS_MAP;
			private final Class<?> primitive;
			private final Class<?> reference;

			private DataType(Class<?> primitive, Class<?> reference) { 
				this.primitive = primitive;
				this.reference = reference;
			}

			public Class<?> getPrimitive()
			{
				return this.primitive;
			}

			public Class<?> getReference()
			{
				return this.reference;
			}

			public static DataType fromClass(Class<?> clazz)
			{
				return (DataType)CLASS_MAP.get(clazz);
			}

			public static Class<?> getPrimitive(Class<?> clazz)
			{
				DataType type = fromClass(clazz);
				return type == null ? clazz : type.getPrimitive();
			}

			public static Class<?> getReference(Class<?> clazz)
			{
				DataType type = fromClass(clazz);
				return type == null ? clazz : type.getReference();
			}

			public static Class<?>[] getPrimitive(Class<?>[] classes)
			{
				int length = classes == null ? 0 : classes.length;
				Class[] types = new Class[length];
				for (int index = 0; index < length; index++) {
					types[index] = getPrimitive(classes[index]);
				}
				return types;
			}

			public static boolean compare(Class<?>[] primary, Class<?>[] secondary)
			{
				if ((primary == null) || (secondary == null) || (primary.length != secondary.length)) {
					return false;
				}
				for (int index = 0; index < primary.length; index++) {
					Class primaryClass = primary[index];
					Class secondaryClass = secondary[index];
					if ((!primaryClass.equals(secondaryClass)) && (!primaryClass.isAssignableFrom(secondaryClass)))
					{
						return false;
					}
				}
				return true;
			}

			static
			{
				CLASS_MAP = new HashMap();
				
				for (DataType type : values()) {
					CLASS_MAP.put(type.primitive, type);
					CLASS_MAP.put(type.reference, type);
				}
			}
		}
	}

	public static final class ParticlePacket
	{
		private static int version;
		private static Class<?> enumParticle;
		private static Constructor<?> packetConstructor;
		private static Method getHandle;
		private static Field playerConnection;
		private static Method sendPacket;
		private static boolean initialized;
		private final Particles effect;
		private float offsetX;
		private final float offsetY;
		private final float offsetZ;
		private final float speed;
		private final int amount;
		private final boolean longDistance;
		private final Particles.ParticleData data;
		private Object packet;

		public ParticlePacket(Particles effect, float offsetX, float offsetY, float offsetZ, float speed, int amount, boolean longDistance, Particles.ParticleData data)
				throws IllegalArgumentException
		{
			initialize();
			if (speed < 0.0F) {
				throw new IllegalArgumentException("The speed is lower than 0");
			}
			if (amount < 0) {
				throw new IllegalArgumentException("The amount is lower than 0");
			}
			this.effect = effect;
			this.offsetX = offsetX;
			this.offsetY = offsetY;
			this.offsetZ = offsetZ;
			this.speed = speed;
			this.amount = amount;
			this.longDistance = longDistance;
			this.data = data;
		}

		public ParticlePacket(Particles effect, Vector direction, float speed, boolean longDistance, Particles.ParticleData data)
				throws IllegalArgumentException
		{
			this(effect, (float)direction.getX(), (float)direction.getY(), (float)direction.getZ(), speed, 0, longDistance, data);
		}

		public ParticlePacket(Particles effect, Particles.ParticleColor color, boolean longDistance)
		{
			this(effect, color.getValueX(), color.getValueY(), color.getValueZ(), 1.0F, 0, longDistance, null);
			if ((effect == Particles.REDSTONE) && ((color instanceof Particles.OrdinaryColor)) && (((Particles.OrdinaryColor)color).getRed() == 0))
				this.offsetX = 1.175494E-038F;
		}

		public static void initialize()
				throws Particles.ParticlePacket.VersionIncompatibleException
		{
			if (initialized) {
				return;
			}
			try
			{
				version = Integer.parseInt(Character.toString(Particles.ReflectionUtils.PackageType.getServerVersion().charAt(3)));
				if (version > 7) {
					enumParticle = Particles.ReflectionUtils.PackageType.MINECRAFT_SERVER.getClass("EnumParticle");
				}
				Class packetClass = Particles.ReflectionUtils.PackageType.MINECRAFT_SERVER.getClass(version < 7 ? "Packet63WorldParticles" : "PacketPlayOutWorldParticles");

				packetConstructor = Particles.ReflectionUtils.getConstructor(packetClass, new Class[0]);
				getHandle = Particles.ReflectionUtils.getMethod("CraftPlayer", Particles.ReflectionUtils.PackageType.CRAFTBUKKIT_ENTITY, "getHandle", new Class[0]);

				playerConnection = Particles.ReflectionUtils.getField("EntityPlayer", Particles.ReflectionUtils.PackageType.MINECRAFT_SERVER, false, "playerConnection");

				sendPacket = Particles.ReflectionUtils.getMethod(playerConnection.getType(), "sendPacket", new Class[] { Particles.ReflectionUtils.PackageType.MINECRAFT_SERVER.getClass("Packet") });
			}
			catch (Exception exception)
			{
				throw new VersionIncompatibleException(exception);
			}
			initialized = true;
		}

		public static int getVersion()
		{
			if (!initialized) {
				initialize();
			}
			return version;
		}

		private void initializePacket(Location center)
				throws Particles.ParticlePacket.PacketInstantiationException
		{
			if (this.packet != null) {
				return;
			}
			try
			{
				this.packet = packetConstructor.newInstance(new Object[0]);
				if (version >= 8)
				{
					Particles.ReflectionUtils.setValue(this.packet, true, "a", enumParticle.getEnumConstants()[this.effect.getId()]);
					Particles.ReflectionUtils.setValue(this.packet, true, "j", Boolean.valueOf(this.longDistance));
					if (this.data != null)
					{
						Particles.ReflectionUtils.setValue(this.packet, true, "k", this.data == null ? new int[0] : this.data.getPacketData());
					}
				}
				else
				{
					String name = this.effect.getName();
					if (this.data != null) {
						name = name + this.data.getPacketDataString();
					}
					Particles.ReflectionUtils.setValue(this.packet, true, "a", name);
				}
				Particles.ReflectionUtils.setValue(this.packet, true, "b", Float.valueOf((float)center.getX()));
				Particles.ReflectionUtils.setValue(this.packet, true, "c", Float.valueOf((float)center.getY()));
				Particles.ReflectionUtils.setValue(this.packet, true, "d", Float.valueOf((float)center.getZ()));
				Particles.ReflectionUtils.setValue(this.packet, true, "e", Float.valueOf(this.offsetX));
				Particles.ReflectionUtils.setValue(this.packet, true, "f", Float.valueOf(this.offsetY));
				Particles.ReflectionUtils.setValue(this.packet, true, "g", Float.valueOf(this.offsetZ));
				Particles.ReflectionUtils.setValue(this.packet, true, "h", Float.valueOf(this.speed));
				Particles.ReflectionUtils.setValue(this.packet, true, "i", Integer.valueOf(this.amount));
			}
			catch (Exception exception)
			{
				throw new PacketInstantiationException("Packet instantiation failed", exception);
			}
		}

		public void sendTo(Location center, Player player)
				throws Particles.ParticlePacket.PacketInstantiationException, Particles.ParticlePacket.PacketSendingException
		{
			initializePacket(center);
			try
			{
				sendPacket.invoke(playerConnection.get(getHandle.invoke(player, new Object[0])), new Object[] { this.packet });
			}
			catch (Exception exception)
			{
				throw new PacketSendingException(exception);
			}
		}

		public void sendTo(Location center, List<Player> players)
				throws IllegalArgumentException
		{
			if (players.isEmpty()) {
				throw new IllegalArgumentException("The player list is empty");
			}
			for (Player player : players)
				sendTo(center, player);
		}

		public void sendTo(Location center, double range)
				throws IllegalArgumentException
		{
			if (range < 1.0D) {
				throw new IllegalArgumentException("The range is lower than 1");
			}
			String worldName = center.getWorld().getName();
			double squared = range * range;
			for (Player player : Bukkit.getOnlinePlayers())
				if ((player.getWorld().getName().equals(worldName)) && (player.getLocation().distanceSquared(center) <= squared))
					sendTo(center, player);
		}
		
		private static final class PacketSendingException extends RuntimeException
		{
			private static final long serialVersionUID = 3203085387160737484L;

			public PacketSendingException(Throwable cause)
			{
				super();
			}
		}

		private static final class PacketInstantiationException extends RuntimeException
		{
			private static final long serialVersionUID = 3203085387160737484L;

			public PacketInstantiationException(String message, Throwable cause)
			{
				super();
			}
		}

		private static final class VersionIncompatibleException extends RuntimeException
		{
			private static final long serialVersionUID = 3203085387160737484L;

			public VersionIncompatibleException(Throwable cause)
			{
				super();
			}
		}
	}

	private static final class ParticleVersionException extends RuntimeException
	{
		private static final long serialVersionUID = 3203085387160737484L;
	}

	private static final class ParticleColorException extends RuntimeException
	{
		private static final long serialVersionUID = 3203085387160737484L;
	}

	private static final class ParticleDataException extends RuntimeException
	{
		private static final long serialVersionUID = 3203085387160737484L;
	}

	public static final class NoteColor extends Particles.ParticleColor
	{
		private final int note;

		public NoteColor(int note)
				throws IllegalArgumentException
		{
			if (note < 0) {
				throw new IllegalArgumentException("The note value is lower than 0");
			}
			if (note > 24) {
				throw new IllegalArgumentException("The note value is higher than 24");
			}
			this.note = note;
		}

		public float getValueX()
		{
			return this.note / 24.0F;
		}

		public float getValueY()
		{
			return 0.0F;
		}

		public float getValueZ()
		{
			return 0.0F;
		}
	}

	public static final class OrdinaryColor extends Particles.ParticleColor
	{
		private final int red;
		private final int green;
		private final int blue;

		public OrdinaryColor(int red, int green, int blue)
				throws IllegalArgumentException
		{
			if (red < 0) {
				throw new IllegalArgumentException("The red value is lower than 0");
			}
			if (red > 255) {
				throw new IllegalArgumentException("The red value is higher than 255");
			}
			this.red = red;
			if (green < 0) {
				throw new IllegalArgumentException("The green value is lower than 0");
			}
			if (green > 255) {
				throw new IllegalArgumentException("The green value is higher than 255");
			}
			this.green = green;
			if (blue < 0) {
				throw new IllegalArgumentException("The blue value is lower than 0");
			}
			if (blue > 255) {
				throw new IllegalArgumentException("The blue value is higher than 255");
			}
			this.blue = blue;
		}

		public OrdinaryColor(Color color)
		{
			this(color.getRed(), color.getGreen(), color.getBlue());
		}

		public int getRed()
		{
			return this.red;
		}

		public int getGreen()
		{
			return this.green;
		}

		public int getBlue()
		{
			return this.blue;
		}

		public float getValueX()
		{
			return this.red / 255.0F;
		}

		public float getValueY()
		{
			return this.green / 255.0F;
		}

		public float getValueZ()
		{
			return this.blue / 255.0F;
		}
	}

	public static abstract class ParticleColor
	{
		public abstract float getValueX();

		public abstract float getValueY();

		public abstract float getValueZ();
	}

	public static final class BlockData extends Particles.ParticleData
	{
		public BlockData(Material material, byte data)
				throws IllegalArgumentException
		{
			super(material, data);
			if (!material.isBlock())
				throw new IllegalArgumentException("The material is not a block");
		}
	}

	public static final class ItemData extends Particles.ParticleData
	{
		public ItemData(Material material, byte data)
		{
			super(material, data);
		}
	}

	public static abstract class ParticleData
	{
		private final Material material;
		private final byte data;
		private final int[] packetData;

		@SuppressWarnings("deprecation")
		public ParticleData(Material material, byte data)
		{
			this.material = material;
			this.data = data;
			this.packetData = new int[] { material.getId(), data };
		}

		public Material getMaterial()
		{
			return this.material;
		}

		public byte getData()
		{
			return this.data;
		}

		public int[] getPacketData()
		{
			return this.packetData;
		}

		public String getPacketDataString()
		{
			return "_" + this.packetData[0] + "_" + this.packetData[1];
		}
	}

	public static enum ParticleProperty
	{
		REQUIRES_WATER, REQUIRES_DATA, DIRECTIONAL, COLORABLE;
	}
}
