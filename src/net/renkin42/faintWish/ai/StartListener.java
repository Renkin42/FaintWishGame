package net.renkin42.faintWish.ai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.renkin42.faintWish.gui.MainFrame;

public class StartListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainFrame.westButton.setEnabled(true);
		MainFrame.northButton.setEnabled(true);
		MainFrame.eastButton.setEnabled(true);
		MainFrame.southButton.setEnabled(true);

	}

}
