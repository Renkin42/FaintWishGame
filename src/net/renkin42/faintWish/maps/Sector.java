package net.renkin42.faintWish.maps;

import java.util.Random;

import net.renkin42.faintWish.ai.Entity;
import net.renkin42.faintWish.ai.MainSystem;

public class Sector {
	
	private int map;
	private int x;
	private int y;
	private int scene;
	private MapReader maps;
	private MapReader scenes;
	
	public Sector(int map, int x, int y, MapReader maps, MapReader scenes) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.maps = maps;
		
		this.scenes = scenes;
		this.scene = new Random().nextInt(this.scenes.mapChars.length);
	}
	
	public void move(int direction, Entity entity) throws InvalidMovementException {
		int arrayX = this.x * 2 + 1;
		int arrayY = this.y * 2 + 1;
		switch (direction) {
		case 0:
			if (maps.mapChars[this.map][arrayX][arrayY+1]==' ') {
				maps.mapChars[this.map][arrayX][arrayY]=' ';
				maps.mapChars[this.map][arrayX][arrayY+2]=entity.marker;
				entity.sector = MainSystem.sector[this.x][this.y+1];
			} else {
				throw new InvalidMovementException(0);
			}
			break;
		case 1:
			if (maps.mapChars[this.map][arrayX+1][arrayY]==' ') {
				maps.mapChars[this.map][arrayX][arrayY]=' ';
				maps.mapChars[this.map][arrayX+2][arrayY]=entity.marker;
				entity.sector = MainSystem.sector[this.x+1][this.y];
			} else {
				throw new InvalidMovementException(1);
			}
			break;
		case 2:
			if (maps.mapChars[this.map][arrayX][arrayY-1]==' ') {
				maps.mapChars[this.map][arrayX][arrayY]=' ';
				maps.mapChars[this.map][arrayX][arrayY-2]=entity.marker;
				entity.sector = MainSystem.sector[this.x][this.y-1];
			} else {
				throw new InvalidMovementException(2);
			}
			break;
		case 3:
			if (maps.mapChars[this.map][arrayX-1][arrayY]==' ') {
				maps.mapChars[this.map][arrayX][arrayY]=' ';
				maps.mapChars[this.map][arrayX-2][arrayY]=entity.marker;
				entity.sector = MainSystem.sector[this.x-1][this.y];
			} else {
				throw new InvalidMovementException(3);
			}
			break;
		}
		this.maps.printMap(map);
	}
	
	public void printScene() {
		this.scenes.printMap(scene);
	}
	
	public boolean isGoal() {
		int arrayX = this.x * 2 + 1;
		int arrayY = this.y * 2 + 1;
		return this.maps.mapChars[this.map][arrayX][arrayY] == 'x';
	}

}
