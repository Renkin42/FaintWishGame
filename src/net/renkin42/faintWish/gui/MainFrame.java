package net.renkin42.faintWish.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import net.renkin42.faintWish.ai.MovementListener;
import net.renkin42.faintWish.ai.StartListener;
import net.renkin42.faintWish.maps.MapReader;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static InternalDisplay mainDisplay;
	public static InternalDisplay mapDisplay;
	public static InternalDisplay consoleDisplay;
	
	public static JButton westButton;
	public static JButton northButton;
	public static JButton eastButton;
	public static JButton southButton;
	public static JButton startButton;
	
	public MainFrame() {
		super("A Faint Wish");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addComponents(this.getContentPane());
		this.pack();
	}
	
	private void addComponents(Container pane) {
		
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		mainDisplay = new InternalDisplay(275, 400);
		mapDisplay = new InternalDisplay(100, 100);
		consoleDisplay = new InternalDisplay(100, 50);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 5;
		c.fill = GridBagConstraints.BOTH;
		pane.add(mainDisplay, c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		pane.add(new JScrollPane(mapDisplay), c);
		
		c.gridx = 0;
		c.gridy = 5;
		pane.add(new JScrollPane(consoleDisplay), c);
		
		MapReader test = new MapReader("test", 1, mainDisplay);
		test.printMap(0);
		
		westButton = new JButton("WEST");
		northButton = new JButton("NORTH");
		eastButton = new JButton("EAST");
		southButton = new JButton("SOUTH");
		startButton = new JButton("START");
		
		westButton.setEnabled(false);
		northButton.setEnabled(false);
		eastButton.setEnabled(false);
		southButton.setEnabled(false);
		
		startButton.addActionListener(new StartListener());
		northButton.addActionListener(new MovementListener(3));
		eastButton.addActionListener(new MovementListener(0));
		southButton.addActionListener(new MovementListener(1));
		westButton.addActionListener(new MovementListener(2));
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		pane.add(westButton, c);
		
		c.gridx = 2;
		c.gridy = 0;
		pane.add(northButton, c);
		
		c.gridx = 3;
		c.gridy = 1;
		pane.add(eastButton, c);
		
		c.gridx = 2;
		c.gridy = 2;
		pane.add(southButton, c);
		
		c.gridx = 2;
		c.gridy = 3;
		pane.add(startButton, c);
		
	}

}
