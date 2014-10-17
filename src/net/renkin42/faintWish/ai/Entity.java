package net.renkin42.faintWish.ai;

import net.renkin42.faintWish.maps.InvalidMovementException;
import net.renkin42.faintWish.maps.Sector;

public class Entity {
	
	public char marker;
	public int movementDirection;
	public Sector sector;
	
	public Entity(char marker) {
		this.marker = marker;
		this.movementDirection = MainSystem.NORTH;
	}
	
	public void move(int direction) throws InvalidMovementException {
		this.sector.move(direction, this);
	}
	
	public void printScene() {
		this.sector.printScene(this);
	}

}
