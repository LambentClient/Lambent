package com.jay.immoral.client.hud;

import org.lwjgl.opengl.GL11;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;
import com.jay.immoral.client.Client;
import com.jay.immoral.client.events.render.EventRender2D;

import net.minecraft.client.Minecraft;

public class HUD {

	public HUD() {
		EventManager.register(this);
	}
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	@EventTarget
	public void onRender(EventRender2D e) {
		drawName();
	}
	
	public void drawName() {
		GL11.glPushMatrix();
		GL11.glScalef(1.5f, 1.5f, 1.5f);
		mc.fontRendererObj.drawString(Client.clientName, 2, 5, 0xffff);
		GL11.glPopMatrix();
	}
	
}
