package net.renkin42.faintWish.ai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import net.renkin42.faintWish.gui.MainFrame;
import net.renkin42.faintWish.maps.InvalidMovementException;

public class MovementListener implements ActionListener {
	
	private int direction;
	
	public MovementListener(int direction) {
		this.direction = direction;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			MainSystem.player.move(direction);
		} catch (InvalidMovementException ime) {
			MainFrame.consoleDisplay.println("Sorry, that path is blocked. Please try a different direction.");
		}
		
		boolean successful = false;
		
		do {
			int androidDirection = new Random().nextInt(4);
			try {
				MainSystem.android.move(androidDirection);
				successful = true;
			} catch (InvalidMovementException ime) {
				successful = false;
			}
		} while (!successful);
		
		

	}

}
