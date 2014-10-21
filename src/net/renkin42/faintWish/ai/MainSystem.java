package net.renkin42.faintWish.ai;

import java.awt.Color;
import java.util.Random;

import net.renkin42.faintWish.gui.MainFrame;
import net.renkin42.faintWish.maps.MapReader;
import net.renkin42.faintWish.maps.Sector;
import static net.renkin42.faintWish.gui.MainFrame.*;

public class MainSystem {
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public static Sector[][] sector = new Sector[9][9];
	public static MapReader maps;
	public static MapReader scenes = new MapReader("scene", 8, MainFrame.mainDisplay);
	public static MapReader menus = new MapReader("menu", 4, MainFrame.mainDisplay);
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
	
	public static void introDialogue() {
		menus.printMap(3);
		
		consoleDisplay.println("To combat the depleting natural resources,");
		consoleDisplay.println("The United Nations enforced the humanity revival project,");
		consoleDisplay.println("which transferred the brains of all humans into machines.");
		consoleDisplay.println("Now 100 years have passed.");
		consoleDisplay.println("The androidification of humanity is 'nearly' complete.");
	}
	
	public static void getCaught() {
		northButton.setEnabled(false);
		eastButton.setEnabled(false);
		southButton.setEnabled(false);
		westButton.setEnabled(false);
		
		menus.printMap(1);
		
		consoleDisplay.printc("Oh no! You were caught by the Android!", Color.RED);
		consoleDisplay.println();
		consoleDisplay.printc("Humanity's future...is lost.", Color.RED);
		consoleDisplay.println();
		consoleDisplay.printc("Press 'START' to continue.", Color.YELLOW);
		consoleDisplay.println();
		startButton.setEnabled(true);
	}
	
	public static void reachGoal() {
		northButton.setEnabled(false);
		eastButton.setEnabled(false);
		southButton.setEnabled(false);
		westButton.setEnabled(false);
		
		menus.printMap(2);
		
		consoleDisplay.printc("Congratulations! You have reached the secret lab!", Color.GREEN);
		consoleDisplay.println();
		consoleDisplay.println("Here lies the trans-dimensional orbital interface.");
		consoleDisplay.println("It is a machine capable of sending people beyond the vector of history!");
		consoleDisplay.println("With it, you can take the path, where everything returns to zero.");
		consoleDisplay.println("At long last, humanity can be saved from its terrible mistakes.");
		consoleDisplay.printc("Press 'START' to continue.", Color.YELLOW);
		consoleDisplay.println();
		startButton.setEnabled(true);
	}

}
