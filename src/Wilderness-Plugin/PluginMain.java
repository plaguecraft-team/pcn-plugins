package vb.$smp;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.plugin.java.*;
import org.bukkit.util.*;
import com.gmail.visualbukkit.stdlib.VariableManager;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;
	private static Object localVariableScope = new Object();

	public void onEnable() {
		VariableManager.loadVariables(this);
		instance = this;
		getDataFolder().mkdir();
		getServer().getPluginManager().registerEvents(this, this);
		Object localVariableScope = new Object();
		saveDefaultConfig();
		try {
			Bukkit.getConsoleSender().sendMessage(PluginMain.color("&c&bSMP Plugin has Enabled by RandomMafia11"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onDisable() {
		VariableManager.saveVariables();
	}

	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("wild")) {
			try {
				Object localVariableScope = new Object();
				VariableManager.setLocalVariable(localVariableScope,
						((org.bukkit.entity.Entity) commandSender).getLocation(), "location ");
				new ArrayList(Arrays.asList(new java.lang.Double(
						((org.bukkit.Location) VariableManager.getLocalVariable(localVariableScope, "location"))
								.getX())))
										.add(new java.lang.Integer(java.util.concurrent.ThreadLocalRandom.current()
												.nextInt(((int) -10000d), ((int) 27000d) + 1)));
				new ArrayList(Arrays.asList(new java.lang.Double(
						((org.bukkit.Location) VariableManager.getLocalVariable(localVariableScope, "location"))
								.getZ())))
										.add(new java.lang.Integer(java.util.concurrent.ThreadLocalRandom.current()
												.nextInt(((int) -10000d), ((int) 27000d) + 1)));
				((org.bukkit.Location) VariableManager.getLocalVariable(localVariableScope, "location"))
						.setY((((org.bukkit.Location) VariableManager.getLocalVariable(localVariableScope, "location"))
								.getWorld().getHighestBlockAt(((org.bukkit.Location) VariableManager
										.getLocalVariable(localVariableScope, "location")))
								.getLocation().getY() + 2d));
				((org.bukkit.entity.Entity) commandSender).teleport(
						((org.bukkit.Location) VariableManager.getLocalVariable(localVariableScope, "location")));
				commandSender.sendMessage(PluginMain.color("&cYou were radomly tped! Beware"));
				((org.bukkit.entity.Player) commandSender).playSound(
						((org.bukkit.entity.Entity) commandSender).getLocation(),
						org.bukkit.Sound.ENTITY_ENDERMAN_TELEPORT, ((float) 1d), ((float) 1d));
				((org.bukkit.entity.Player) commandSender).sendTitle("\u00A7cYou randomly Tped!", "\u00A7BEWARE!",
						((int) 100d), ((int) 100d), ((int) 100d));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static void procedure(String procedure, List<?> procedureArgs) throws Exception {
	}

	public static Object function(String function, List<?> functionArgs) throws Exception {
		return null;
	}

	public static List<Object> createList(Object obj) {
		List<Object> list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static String color(String string) {
		return string != null ? ChatColor.translateAlternateColorCodes('&', string) : null;
	}

	public static PluginMain getInstance() {
		return instance;
	}
}
