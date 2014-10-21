package net.renkin42.faintWish.maps;

import net.renkin42.faintWish.ai.Entity;
import net.renkin42.faintWish.ai.MainSystem;

public class Sector {
	public boolean isGoal;
	
	private int map;
	private int x;
	private int y;
	private int arrayX;
	private int arrayY;
	private MapReader maps;
	private MapReader scenes;
	
	public Sector(int map, int x, int y, MapReader maps, MapReader scenes) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.arrayX = this.x * 2 + 1;
		this.arrayY = this.y * 2 + 1;
		this.isGoal = (MainSystem.maps.mapChars[this.map][arrayX][this.arrayY]=='x');
		this.maps = maps;
		this.scenes = scenes;
	}
	
	public void move(int direction, Entity entity) throws InvalidMovementException {
		int arrayX = this.x * 2 + 1;
		int arrayY = this.y * 2 + 1;
		switch (direction) {
		case MainSystem.NORTH:
			if (maps.mapChars[this.map][arrayY-1][arrayX]==' ') {
				if (entity==MainSystem.player) {entity.marker = '^';}
				maps.mapChars[this.map][arrayY][arrayX]=' ';
				maps.mapChars[this.map][arrayY-2][arrayX]=entity.marker;
				entity.sector = MainSystem.sector[this.x][this.y-1];
				entity.movementDirection = MainSystem.NORTH;
			} else {
				throw new InvalidMovementException(MainSystem.NORTH);
			}
			break;
		case MainSystem.EAST:
			if (maps.mapChars[this.map][arrayY][arrayX+1]==' ') {
				if (entity==MainSystem.player) {entity.marker = '>';}
				maps.mapChars[this.map][arrayY][arrayX]=' ';
				maps.mapChars[this.map][arrayY][arrayX+2]=entity.marker;
				entity.sector = MainSystem.sector[this.x+1][this.y];
				entity.movementDirection = MainSystem.EAST;
			} else {
				throw new InvalidMovementException(MainSystem.EAST);
			}
			break;
		case MainSystem.SOUTH:
			if (maps.mapChars[this.map][arrayY+1][arrayX]==' ') {
				if (entity==MainSystem.player) {entity.marker = 'v';}
				maps.mapChars[this.map][arrayY][arrayX]=' ';
				maps.mapChars[this.map][arrayY+2][arrayX]=entity.marker;
				entity.sector = MainSystem.sector[this.x][this.y+1];
				entity.movementDirection = MainSystem.SOUTH;
			} else {
				throw new InvalidMovementException(MainSystem.SOUTH);
			}
			break;
		case MainSystem.WEST:
			if (maps.mapChars[this.map][arrayY][arrayX-1]==' ') {
				if (entity==MainSystem.player) {entity.marker = '<';}
				maps.mapChars[this.map][arrayY][arrayX]=' ';
				maps.mapChars[this.map][arrayY][arrayX-2]=entity.marker;
				entity.sector = MainSystem.sector[this.x-1][this.y];
				entity.movementDirection = MainSystem.WEST;
			} else {
				throw new InvalidMovementException(MainSystem.WEST);
			}
			break;
		}
		this.maps.printMap(map);
	}
	
	public void printScene(Entity player) {
		boolean leftOpen;
		boolean frontOpen;
		boolean rightOpen;
		
		switch (player.movementDirection) {
		case MainSystem.NORTH:
			leftOpen = (this.maps.mapChars[this.map][this.arrayY][this.arrayX-1]==' ');
			frontOpen = (this.maps.mapChars[this.map][this.arrayY-1][this.arrayX]==' ');
			rightOpen = (this.maps.mapChars[this.map][this.arrayY][this.arrayX+1]==' ');
			break;
		case MainSystem.EAST:
			leftOpen = (this.maps.mapChars[this.map][this.arrayY-1][this.arrayX]==' ');
			frontOpen = (this.maps.mapChars[this.map][this.arrayY][this.arrayX+1]==' ');
			rightOpen = (this.maps.mapChars[this.map][this.arrayY+1][this.arrayX]==' ');
			break;
		case MainSystem.SOUTH:
			leftOpen = (this.maps.mapChars[this.map][this.arrayY][this.arrayX+1]==' ');
			frontOpen = (this.maps.mapChars[this.map][this.arrayY+1][this.arrayX]==' ');
			rightOpen = (this.maps.mapChars[this.map][this.arrayY][this.arrayX-1]==' ');
			break;
		case MainSystem.WEST:
			leftOpen = (this.maps.mapChars[this.map][this.arrayY+1][this.arrayX]==' ');
			frontOpen = (this.maps.mapChars[this.map][this.arrayY][this.arrayX-1]==' ');
			rightOpen = (this.maps.mapChars[this.map][this.arrayY-1][this.arrayX]==' ');
			break;
		default:
			leftOpen=false;
			frontOpen=false;
			rightOpen=false;
		}
		
		int scene = leftOpen ? 1 : 0;
		scene += frontOpen ? 2 : 0;
		scene += rightOpen ? 4 : 0;
		
		this.scenes.printMap(scene);
	}

}
