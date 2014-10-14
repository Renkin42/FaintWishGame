package net.renkin42.faintWish.ai;

import java.util.Random;

import net.renkin42.faintWish.maps.MapReader;
import net.renkin42.faintWish.maps.Sector;

public class MainSystem {
	
	public static Sector[][] sector = new Sector[9][9];
	public static MapReader maps;
	public static MapReader scenes;
	public static int map;
	public static Entity player;
	public static Entity android;
	
	public MainSystem() {
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
