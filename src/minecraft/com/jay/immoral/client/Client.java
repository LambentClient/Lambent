package com.jay.immoral.client;

import javax.swing.JOptionPane;

import org.lwjgl.opengl.Display;

import com.jay.immoral.client.hud.HUD;
import com.jay.immoral.client.module.ModuleManager;
import com.jay.immoral.client.utils.Logger;

import net.minecraft.client.Minecraft;

/**
 * Lambent Client.
 * 
 * @author Jay
 * @author ImmortalDesire
 *
 */

public class Client {

	public static String clientName = "Lambent"; //TODO: Make it read from HTML (cooler ofc)
	public static String clientBuild = "b1"; //TODO: Make it read from HTML (cooler ofc)
	
	public static ModuleManager moduleManager;
	public static HUD hud;
	
	public static void initializeClient() {
		try{
			Logger.initialize(clientName);
			initialisePopup();
			createDisplay();
			
			////////////////////////
			moduleManager = new ModuleManager();
			hud = new HUD();
			////////////////////////
			
			Runtime.getRuntime().addShutdownHook(new Thread(() -> endClient()));
		}catch(Exception e) {
			Logger.error("Failed to initialize Client.", e);
		}
	}
	
	public static void endClient() {
		Logger.info("Ended Client.");
	}
	
	private static void createDisplay() {
		Display.setResizable(true);
		Display.setTitle(clientName + " " + clientBuild);
	}
	
	private static void initialisePopup() {
		JOptionPane.showMessageDialog(null, "Weclome to " + clientName + ", Coded by Jay and ImmoralDesire.");
	}
	
}
