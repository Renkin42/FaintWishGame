package net.renkin42.faintWish.maps;

import java.util.Random;

import net.renkin42.faintWish.gui.InternalDisplay;

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
	
	public void move(int direction, InternalDisplay display) throws InvalidMovementException {
		int arrayX = this.x * 2 + 1;
		int arrayY = this.y * 2 + 1;
		switch (direction) {
		case 0:
			if (maps.mapChars[this.map][arrayX][arrayY+1]==' ') {
				maps.mapChars[this.map][arrayX][arrayY]=' ';
				maps.mapChars[this.map][arrayX][arrayY+2]='p';
			} else {
				throw new InvalidMovementException(0);
			}
			break;
		case 1:
			if (maps.mapChars[this.map][arrayX+1][arrayY]==' ') {
				maps.mapChars[this.map][arrayX][arrayY]=' ';
				maps.mapChars[this.map][arrayX+2][arrayY]='p';
			} else {
				throw new InvalidMovementException(1);
			}
			break;
		case 2:
			if (maps.mapChars[this.map][arrayX][arrayY-1]==' ') {
				maps.mapChars[this.map][arrayX][arrayY]=' ';
				maps.mapChars[this.map][arrayX][arrayY-2]='p';
			} else {
				throw new InvalidMovementException(2);
			}
			break;
		case 3:
			if (maps.mapChars[this.map][arrayX-1][arrayY]==' ') {
				maps.mapChars[this.map][arrayX][arrayY]=' ';
				maps.mapChars[this.map][arrayX-2][arrayY]='p';
			} else {
				throw new InvalidMovementException(3);
			}
			break;
		}
		this.maps.printMap(map, display);
	}
	
	public void printScene(InternalDisplay display) {
		this.scenes.printMap(scene, display);
	}

}
