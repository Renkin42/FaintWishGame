package net.renkin42.faintWish.maps;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.renkin42.faintWish.gui.InternalDisplay;

public class MapReader {
	
	public char[][][] mapChars;
	
	public MapReader(String mapName, int mapSize) {
		this.mapChars = new char[mapSize][19][19];
		
		for (int i=0; i<mapSize; i++) {
			try {
				InputStream file = this.getClass().getResourceAsStream("/resources/text/"+mapName+"s/"+mapName+i+".txt");
				BufferedReader mapTextFile = new BufferedReader(new InputStreamReader(file));
				
				for (int j=0; j<19; j++) {
					
					char[] line = mapTextFile.readLine().toCharArray();
					
					for (int k=0; k<19; k++) {
						this.mapChars[i][j][k] = line[k];
					}
				}
				
				mapTextFile.close();
			} catch (Exception e) {
				System.out.println("Unable to load "+mapName+" file "+i+". Generating blank map instead.");
				for (int j=0; j<19; j++) {
					for (int k=0; k<19; k++) {
						this.mapChars[i][j][k] = ' ';
					}
				}
			}
		}
	}
	
	public void printMap(int map, InternalDisplay display) {
		display.clear();
		
		for (int i=0; i<19; i++) {
			for (int j=0; j<19; j++) {
				switch (mapChars[map][i][j]) {
				case 'r': display.appendc("\u2591", Color.RED); break;
				case 'R': display.appendc("\u2593", Color.RED); break;
				case 'g': display.appendc("\u2591", Color.GREEN); break;
				case 'G': display.appendc("\u2593", Color.GREEN); break;
				case 'b': display.appendc("\u2591", Color.BLUE); break;
				case 'B': display.appendc("\u2593", Color.BLUE); break;
				case 'c': display.appendc("\u2591", Color.CYAN); break;
				case 'C': display.appendc("\u2593", Color.CYAN); break;
				case 'm': display.appendc("\u2591", Color.MAGENTA); break;
				case 'M': display.appendc("\u2593", Color.MAGENTA); break;
				case 'y': display.appendc("\u2591", Color.YELLOW); break;
				case 'Y': display.appendc("\u2593", Color.YELLOW); break;
				case 'k': display.appendc("\u2591", Color.GRAY); break;
				case 'K': display.appendc("\u2593", Color.GRAY); break;
				case 'w': display.append("\u2591"); break;
				case 'W': display.append("\u2593"); break;
				case '0': display.append("\u2501"); break; //horizontal wall
				case '1': display.append("\u2503"); break; //vertical wall
				case '2': display.append("\u250F"); break; //top left corner
				case '3': display.append("\u2513"); break; //top right corner
				case '4': display.append("\u2517"); break; //bottom left corner
				case '5': display.append("\u251B"); break; //bottom right corner
				case '6': display.append("\u2523"); break; //left T-intersection
				case '7': display.append("\u252B"); break; //right T-intersection
				case '8': display.append("\u2533"); break; //top T-intersection
				case '9': display.append("\u253B"); break; //bottom T-intersection
				case 'a': display.append("\u254B"); break; //4-way intersection
				case 'A': display.appendc("\u2620", Color.RED); break;
				case 'x': display.appendc("\u2613", Color.YELLOW); break;
				case 'p': display.appendc("\u265B", Color.BLUE); break;
				case ' ': display.appendc("\u2593", Color.BLACK); break;
				default: display.append(Character.toString(mapChars[map][i][j]));
				}
			}
			display.appendln();
		}
		display.print("");
	}
	
}
