package com.jay.immoral.client.module;

import java.util.ArrayList;
import java.util.List;

import com.jay.immoral.client.module.impl.movement.Sprint;
import com.jay.immoral.client.utils.Logger;

public class ModuleManager {

	private static List<Module> mods = new ArrayList<>();

	public ModuleManager() {
		addMod(new Sprint());
	}
	
	public void addMod(Module module) {
		this.mods.add(module);
		Logger.loading("Module: " + module.getName());
	}
	
	public List<Module> getModules() {
		return mods;
	}
	
	public Module findModule(Class<? extends Module> className) {
		for(Module m : getModules()) {
			if(m.getClass() == className) {
				return m;
			}
		}
		return null;
	}
	

	
}
