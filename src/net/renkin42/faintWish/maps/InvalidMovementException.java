package net.renkin42.faintWish.maps;

import net.renkin42.faintWish.ai.MainSystem;

public class InvalidMovementException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidMovementException() {
		super("Invalid movement direction.");
	}
	
	public InvalidMovementException(int direction) {
		super(getDirectionMessage(direction));
	}
	
	private static String getDirectionMessage(int direction) {
		String message = "Invalid movement direction: ";
		switch (direction) {
		case MainSystem.NORTH: message += "NORTH."; break;
		case MainSystem.EAST: message += "EAST."; break;
		case MainSystem.SOUTH: message += "SOUTH."; break;
		case MainSystem.WEST: message += "WEST."; break;
		default: message += "UNKNOWN.";
		}
		return message;
	}

}
