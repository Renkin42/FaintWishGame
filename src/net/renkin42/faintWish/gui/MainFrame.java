package net.renkin42.faintWish.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.renkin42.faintWish.maps.Entity;
import net.renkin42.faintWish.maps.MapReader;
import net.renkin42.faintWish.maps.Sector;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static Sector[][] sector = new Sector[9][9];
	public static MapReader maps;
	public static MapReader scenes;
	public static int map;
	public static Entity player;
	public static Entity android;
	
	public MainFrame() {
		super("A Faint Wish");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addComponents(this.getContentPane());
		this.pack();
	}
	
	private void addComponents(Container pane) {
		initializeVariables();
		
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		InternalDisplay text = new InternalDisplay(400,400);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 4;
		c.fill = GridBagConstraints.BOTH;
		text.println("Test Line 1");
		text.println();
		text.print("Test line 2. ");
		text.printc("This text is red!", Color.RED);
		text.println();
		text.printc("\u2593\u2593\u2593\u2592\u2592\u2592\u2591\u2591\u2591\u2592\u2592\u2592\u2593\u2593\u2593", Color.BLUE);
		pane.add(text, c);
		
		maps.printMap(0, text);
		
		JButton button1 = new JButton("LEFT");
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		pane.add(button1, c);
		
		JButton button2 = new JButton("UP");
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		pane.add(button2, c);
		
		JButton button3 = new JButton("RIGHT");
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		pane.add(button3, c);
		
		JButton button4 = new JButton("DOWN");
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		pane.add(button4, c);
		
	}
	
	private static void initializeVariables() {
		maps = new MapReader("map", 1);
		scenes = new MapReader("scene", 1);
		
		map = new Random().nextInt(maps.mapChars.length);
		
		player = new Entity('p');
		android = new Entity('A');
		
		maps.initializeSectors(map, player, android);
		
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				sector[i][j] = new Sector(map, i, j, maps, scenes);
			}
		}
	}

}
