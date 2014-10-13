package net.renkin42.faintWish.maps;

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
		case 0: message += "NORTH."; break;
		case 1: message += "EAST."; break;
		case 2: message += "SOUTH."; break;
		case 3: message += "WEST."; break;
		default: message += "UNKNOWN.";
		}
		return message;
	}

}
