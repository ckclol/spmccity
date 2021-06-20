package org.plugin.tagSystem;

import org.caveandcliff.Implemenation;
import org.api.TagWrapper;
import org.bukkit.Bukkit;
import rise.city.RiseCity;

public class TagManager {

	//Singleton class setup
	private static TagManager instance;
	private TagManager() {};
	
	public static TagManager getInstance() {
		if (instance == null) {
			instance = new TagManager();
		}
		return instance;
	}
	
	//Actual content
	private TagWrapper implementation;	
	private final String serverVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].substring(1);

	//Sets the implementation vased on the version. 1.14+ uses the 1.14 implementation.
	public void createInstance() {
			implementation = new Implemenation(RiseCity.getPlugin());
			
			if (implementation == null) {
				Bukkit.getLogger().severe("Version " + serverVersion + " is not supported by EnchanterCore. EnchanterCore disabling.");
			}
	}
	
	public TagWrapper getImplemenation() {
		return implementation;
	}
		
}
