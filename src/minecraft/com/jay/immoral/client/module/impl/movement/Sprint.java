package com.jay.immoral.client.module.impl.movement;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventTarget;
import com.jay.immoral.client.events.update.EventUpdate;
import com.jay.immoral.client.module.Category;
import com.jay.immoral.client.module.Module;
import com.jay.immoral.client.utils.Logger;

@Module.mod(name = "Sprint", description = "Auto-Sprints", bind = Keyboard.KEY_L, category = Category.Movement)
public class Sprint extends Module{

	@EventTarget
	public void onUpdate(EventUpdate e) {
		if(!this.getState())return;
		if(mc.thePlayer.onGround && !mc.thePlayer.isEating() && !mc.thePlayer.isDead && !mc.gameSettings.keyBindBack.pressed && !mc.thePlayer.isCollidedHorizontally) {
			mc.thePlayer.setSprinting(true);
		}
	}
	
	@Override
	public void onDisable() {
		mc.thePlayer.setSprinting(false);
	}
	
}
