package net.renkin42.faintWish.maps;

import java.util.Random;

import net.renkin42.faintWish.ai.Entity;
import net.renkin42.faintWish.ai.MainSystem;

public class Sector {
	public boolean isGoal;
	
	private int map;
	private int x;
	private int y;
	private int arrayX;
	private int arrayY;
	private int scene;
	private MapReader maps;
	private MapReader scenes;
	
	public Sector(int map, int x, int y, MapReader maps, MapReader scenes) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.arrayX = this.x * 2 + 1;
		this.arrayY = this.y * 2 + 1;
		this.isGoal = (MainSystem.maps.mapChars[this.map][this.arrayY][arrayX]=='x');
		this.maps = maps;
		this.scenes = scenes;
		this.scene = new Random().nextInt(this.scenes.mapChars.length);
	}
	
	public void move(int direction, Entity entity) throws InvalidMovementException {
		int arrayX = this.x * 2 + 1;
		int arrayY = this.y * 2 + 1;
		switch (direction) {
		case MainSystem.NORTH:
			if (maps.mapChars[this.map][arrayY-1][arrayX]==' ') {
				maps.mapChars[this.map][arrayY][arrayX]=' ';
				maps.mapChars[this.map][arrayY-2][arrayX]=entity.marker;
				entity.sector = MainSystem.sector[this.x][this.y-1];
			} else {
				throw new InvalidMovementException(MainSystem.NORTH);
			}
			break;
		case MainSystem.EAST:
			if (maps.mapChars[this.map][arrayY][arrayX+1]==' ') {
				maps.mapChars[this.map][arrayY][arrayX]=' ';
				maps.mapChars[this.map][arrayY][arrayX+2]=entity.marker;
				entity.sector = MainSystem.sector[this.x+1][this.y];
			} else {
				throw new InvalidMovementException(MainSystem.EAST);
			}
			break;
		case MainSystem.SOUTH:
			if (maps.mapChars[this.map][arrayY+1][arrayX]==' ') {
				maps.mapChars[this.map][arrayY][arrayX]=' ';
				maps.mapChars[this.map][arrayY+2][arrayX]=entity.marker;
				entity.sector = MainSystem.sector[this.x][this.y+1];
			} else {
				throw new InvalidMovementException(MainSystem.SOUTH);
			}
			break;
		case MainSystem.WEST:
			if (maps.mapChars[this.map][arrayY][arrayX-1]==' ') {
				maps.mapChars[this.map][arrayY][arrayX]=' ';
				maps.mapChars[this.map][arrayY][arrayX-2]=entity.marker;
				entity.sector = MainSystem.sector[this.x-1][this.y];
			} else {
				throw new InvalidMovementException(MainSystem.WEST);
			}
			break;
		}
		this.maps.printMap(map);
	}
	
	public void printScene() {
		this.scenes.printMap(scene);
	}

}
