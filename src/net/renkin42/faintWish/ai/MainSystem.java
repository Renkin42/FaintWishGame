package net.renkin42.faintWish.ai;

import java.awt.Color;
import java.util.Random;

import net.renkin42.faintWish.gui.MainFrame;
import net.renkin42.faintWish.maps.MapReader;
import net.renkin42.faintWish.maps.Sector;

public class MainSystem {
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public static Sector[][] sector = new Sector[9][9];
	public static MapReader maps;
	public static MapReader scenes = new MapReader("scene", 8, MainFrame.mainDisplay);
	public static MapReader menus = new MapReader("menu", 3, MainFrame.mainDisplay);
	public static int map;
	public static Entity player;
	public static Entity android;
	
	public MainSystem() {
		maps = new MapReader("map", 3, MainFrame.mapDisplay);
		
		map = new Random().nextInt(maps.mapChars.length);
		
		player = new Entity('^');
		android = new Entity('A');
		
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				sector[i][j] = new Sector(map, i, j, maps, scenes);
			}
		}
		
		maps.initializeSectors(map, player, android);
		maps.printMap(map);
		player.printScene();
	}
	
	public static void getCaught() {
		MainFrame.northButton.setEnabled(false);
		MainFrame.eastButton.setEnabled(false);
		MainFrame.southButton.setEnabled(false);
		MainFrame.westButton.setEnabled(false);
		
		menus.printMap(1);
		
		MainFrame.consoleDisplay.printc("Oh no! You were caught by the Android!", Color.RED);
		MainFrame.consoleDisplay.println();
		MainFrame.consoleDisplay.printc("Humanity's future...is lost.", Color.RED);
		MainFrame.consoleDisplay.println();
		MainFrame.consoleDisplay.printc("Press 'START' to continue.", Color.YELLOW);
		MainFrame.consoleDisplay.println();
		MainFrame.startButton.setEnabled(true);
	}
	
	public static void reachGoal() {
		MainFrame.northButton.setEnabled(false);
		MainFrame.eastButton.setEnabled(false);
		MainFrame.southButton.setEnabled(false);
		MainFrame.westButton.setEnabled(false);
		
		menus.printMap(2);
		
		MainFrame.consoleDisplay.printc("Congratulations! You have reached the secret lab!", Color.GREEN);
		MainFrame.consoleDisplay.println();
		MainFrame.consoleDisplay.println("Here lies the trans-dimensional orbital interface.");
		MainFrame.consoleDisplay.println("It is a machine capable of sending people beyond the vector of history!");
		MainFrame.consoleDisplay.println("With it, you can take the path, where everything returns to zero.");
		MainFrame.consoleDisplay.println("At long last, humanity can be saved from its terrible mistakes.");
		MainFrame.consoleDisplay.printc("Press 'START' to continue.", Color.YELLOW);
		MainFrame.consoleDisplay.println();
		MainFrame.startButton.setEnabled(true);
	}

}
