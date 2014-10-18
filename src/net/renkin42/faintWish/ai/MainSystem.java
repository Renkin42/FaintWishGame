package net.renkin42.faintWish.ai;

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
	public static MapReader scenes;
	public static int map;
	public static Entity player;
	public static Entity android;
	
	public MainSystem() {
		maps = new MapReader("map", 3, MainFrame.mapDisplay);
		scenes = new MapReader("scene", 3, MainFrame.mainDisplay);
		
		map = new Random().nextInt(maps.mapChars.length);
		
		player = new Entity('p');
		android = new Entity('A');
		
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				sector[i][j] = new Sector(map, i, j, maps, scenes);
			}
		}
		
		maps.initializeSectors(map, player, android);
		maps.printMap(map);
		scenes.printMap(2);
	}

}
