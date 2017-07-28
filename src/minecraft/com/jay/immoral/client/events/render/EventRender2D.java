package com.jay.immoral.client.events.render;

import com.darkmagician6.eventapi.events.Event;

public class EventRender2D implements Event {

	public int width, height;

	public EventRender2D(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
