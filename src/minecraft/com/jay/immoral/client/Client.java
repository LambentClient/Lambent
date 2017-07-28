package com.jay.immoral.client;

import java.awt.Checkbox;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.text.html.HTML;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.White;
import org.lwjgl.opengl.Display;

import com.jay.immoral.client.hud.HUD;
import com.jay.immoral.client.module.ModuleManager;
import com.jay.immoral.client.utils.HTMLReader;
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

	public static String clientName = "Lambent";
	public static String clientBuild = HTMLReader.checkVersion(); 	
	public static ModuleManager moduleManager;
	public static HUD hud;
	
	public static void initializeClient() {
		try{
			checkWhitelist();
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
	
	public static void checkWhitelist() {
		String uuid = Minecraft.getMinecraft().thePlayer.getUniqueID().toString().trim();
		if(HTMLReader.getWhitelist().contains(uuid)) {
			JOptionPane.showMessageDialog(null, "You are not whitelisted to use this client! Please buy it before trying to use!");
			Minecraft.getMinecraft().shutdown();
			Minecraft.getMinecraft().shutdownMinecraftApplet();
			System.exit(1);
		}
	}
	
	private static void initialisePopup() {
		JOptionPane.showMessageDialog(null, "Weclome to " + clientName + ", Coded by Jay and ImmoralDesire.");
	}
	
}
