package net.renkin42.faintWish.ai;

import net.renkin42.faintWish.gui.MainFrame;
import net.renkin42.faintWish.maps.InvalidMovementException;
import net.renkin42.faintWish.maps.Sector;

public class Entity {
	
	public char marker;
	public Sector sector;
	
	public Entity(char marker) {
		this.marker = marker;
	}
	
	public void move(int direction) throws InvalidMovementException {
		this.sector.move(direction, MainFrame.mapDisplay, this);
	}

}
