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
	public static int turn;
	public static Entity player;
	public static Entity android;
	
	public MainSystem() {
		maps = new MapReader("map", 4, MainFrame.mapDisplay);
		
		map = new Random().nextInt(maps.mapChars.length);
		turn = 0;
		
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
	
	public static void getTurnMessage() {
		switch (turn) {
		case 0: consoleDisplay.appendc("In a town enveloped by darkness", Color.BLUE); break;
		case 1: consoleDisplay.appendc("The light from the moon no longer reaches us.", Color.BLUE); break;
		case 2: consoleDisplay.appendc("We will no longer be able to return,", Color.BLUE); break;
		case 3: consoleDisplay.appendc("so choose wisely the path humanity will take.", Color.BLUE); break;
		case 4: consoleDisplay.appendc("Humans in the flesh no longer exist.", Color.BLUE); break;
		case 5: consoleDisplay.appendc("A world where pain is lost.", Color.BLUE); break;
		case 6: consoleDisplay.appendc("The price for this program that doesn't", Color.BLUE); break;
		case 7: consoleDisplay.appendc("understand pain covers the entire world.", Color.BLUE); break;
		case 8: consoleDisplay.appendc("A body with no blood or tears...", Color.BLUE); break;
		case 9: consoleDisplay.appendc("A soul that doesn't feel any pain...", Color.BLUE); break;
		case 10: consoleDisplay.appendc("The threat to the 'New Humanity'...", Color.BLUE); break;
		case 11: consoleDisplay.appendc("The remains of the old humanity", Color.BLUE); break;
		case 12: consoleDisplay.appendc("Their task was to, yes...", Color.BLUE); break;
		case 13: consoleDisplay.appendc("connect their DNA to the future.", Color.BLUE); break;
		case 14: consoleDisplay.appendc("Where did things go wrong?", Color.BLUE); break;
		case 15: consoleDisplay.appendc("The war...still won't end.", Color.BLUE); break;
		case 16: consoleDisplay.appendc("Those words still ring in my ears,", Color.BLUE); break;
		case 17: consoleDisplay.appendc("'You guys...must live on...'", Color.BLUE); break;
		case 18: consoleDisplay.appendc("In this city that watches a never-ending dream,", Color.BLUE); break;
		case 19: consoleDisplay.appendc("You could no longer hear any heartbeats.", Color.BLUE); break;
		case 20: consoleDisplay.appendc("Just so you have no regrets,", Color.BLUE); break;
		case 21: consoleDisplay.appendc("Watch over, as humanity holds their will.", Color.BLUE); break;
		}
		if (turn<=21) {
			consoleDisplay.println();
		}
		turn++;
		
	}

}
