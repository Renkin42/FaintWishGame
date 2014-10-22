package net.renkin42.faintWish.ai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import net.renkin42.faintWish.gui.MainFrame;
import net.renkin42.faintWish.maps.InvalidMovementException;
import static net.renkin42.faintWish.ai.MainSystem.*;

public class MovementListener implements ActionListener {
	
	public static final int FORWARD = 0;
	public static final int RIGHT = 1;
	public static final int BACK = 2;
	public static final int LEFT = 3;
	private int relativeDirection;
	
	public MovementListener(int direction) {
		this.relativeDirection = direction;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int absoluteDirection = 0;
		
		switch (player.movementDirection) {
		case NORTH: absoluteDirection = this.relativeDirection; break;
		case EAST: 
			switch (this.relativeDirection) {
			case FORWARD:
			case RIGHT:
			case BACK:
				absoluteDirection = this.relativeDirection + 1;
				break;
			case LEFT:
				absoluteDirection = NORTH;
				break;
			}
			break;
		case SOUTH:
			switch(this.relativeDirection) {
			case FORWARD:
			case RIGHT:
				absoluteDirection = this.relativeDirection + 2;
				break;
			case BACK:
			case LEFT:
				absoluteDirection = this.relativeDirection - 2;
				break;
			}
			break;
		case WEST:
			switch(this.relativeDirection) {
			case FORWARD: 
				absoluteDirection = WEST; 
				break;
			case RIGHT:
			case BACK:
			case LEFT:
				absoluteDirection = this.relativeDirection - 1;
				break;
			}
			break;
		}
		
		try {
			player.move(absoluteDirection);
			player.printScene();
		} catch (InvalidMovementException ime) {
			MainFrame.consoleDisplay.println("Sorry, that path is blocked. Please try a different direction.");
		}
		
		if (player.sector == android.sector) {
			MainSystem.getCaught();
		} else if (player.sector.isGoal) {
			MainSystem.reachGoal();
		} else {
			boolean successful = false;
			
			do {
				int androidDirection = new Random().nextInt(4);
				try {
					android.move(androidDirection);
					successful = true;
				} catch (InvalidMovementException ime) {
					successful = false;
				}
			} while (!successful);
			
			if(player.sector == android.sector) {
				MainSystem.getCaught();
			} else {
				MainSystem.getTurnMessage();
			}
			
		}

	}

}
