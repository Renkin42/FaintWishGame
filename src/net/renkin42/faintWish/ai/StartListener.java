package net.renkin42.faintWish.ai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.renkin42.faintWish.gui.MainFrame;

public class StartListener implements ActionListener {
	
	private boolean ready;
	
	public StartListener() {
		super();
		ready = false;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!ready) {
			MainFrame.mainDisplay.clear();
			MainFrame.mapDisplay.clear();
			MainFrame.consoleDisplay.clear();
			
			MainSystem.introDialogue();
			
			ready = true;
		} else {
			MainFrame.startButton.setEnabled(false);
			MainFrame.westButton.setEnabled(true);
			MainFrame.northButton.setEnabled(true);
			MainFrame.eastButton.setEnabled(true);
			MainFrame.southButton.setEnabled(true);
		
			new MainSystem();
			
			ready = false;
		}

	}

}
