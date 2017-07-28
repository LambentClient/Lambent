package com.jay.immoral.client.module;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;

import net.minecraft.client.Minecraft;

public class Module {

	private String name = getClass().getAnnotation(mod.class).name();
	private String description = getClass().getAnnotation(mod.class).description();
	private int bind = getClass().getAnnotation(mod.class).bind();
	private Category category = getClass().getAnnotation(mod.class).category();

	public static Minecraft mc = Minecraft.getMinecraft();

	private boolean state;

	/**
	 * Module Info.
	 * 
	 * @author Jay
	 *
	 */
	@Retention(RetentionPolicy.RUNTIME)
	public @interface mod {
		String name();

		String description();

		int bind();

		Category category();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBind() {
		return bind;
	}

	public void setBind(int bind) {
		this.bind = bind;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
	        if (state) {
	            onEnable();
	            this.state = true;
	            EventManager.register(this);
	        } else {
	            onDisable();
	            this.state = false;
	            EventManager.unregister(this);
	        }
	     }
	
	public void toggle() {
		setState(!this.getState());
	}

	public final boolean isCategory(Category c) {
		if (c == this.category) {
			return true;
		}
		return false;
	}

	public String getKeyName() {
		return getBind() == -1 ? "-1" : Keyboard.getKeyName(getBind());
	}

	public void onEnable() {
	}

	public void onDisable() {
	}

}
