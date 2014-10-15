package net.renkin42.faintWish.maps;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;

import net.renkin42.faintWish.ai.Entity;
import net.renkin42.faintWish.ai.MainSystem;
import net.renkin42.faintWish.gui.InternalDisplay;

public class MapReader {
	
	public char[][][] mapChars;
	private int[] playerInitialX;
	private int[] playerInitialY;
	private int[] androidInitialX;
	private int[] androidInitialY;
	private InternalDisplay output;
	
	public MapReader(String mapName, int mapSize, InternalDisplay output) {
		this.mapChars = new char[mapSize][19][19];
		this.playerInitialX = new int[mapSize];
		this.playerInitialY = new int[mapSize];
		this.androidInitialX = new int[mapSize];
		this.androidInitialY = new int[mapSize];
		this.output = output;
		
		for (int i=0; i<mapSize; i++) {
			try {
				String file = this.getClass().getResource("/resources/text/"+mapName+"s/"+mapName+i+".txt").getPath();
				BufferedReader mapTextFile = new BufferedReader(new FileReader(file));
				
				for (int j=0; j<19; j++) {
					
					char[] line = mapTextFile.readLine().toCharArray();
					
					for (int k=0; k<19; k++) {
						this.mapChars[i][j][k] = line[k];
						if (line[k]=='p') {
							playerInitialX[i] = (j-1)/2;
							playerInitialY[i] = (k-1)/2;
						} else if (line[k]=='A') {
							androidInitialX[i] = (j-1)/2;
							androidInitialY[i] = (k-1)/2;
						}
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
	
	public void initializeSectors(int map, Entity player, Entity android) {
		player.sector = MainSystem.sector[this.playerInitialX[map]][this.playerInitialY[map]];
		android.sector = MainSystem.sector[this.androidInitialX[map]][this.androidInitialY[map]];
	}
	
	public void printMap(int map) {
		output.clear();
		
		for (int i=0; i<19; i++) {
			for (int j=0; j<19; j++) {
				switch (mapChars[map][i][j]) {
				case 'r': output.appendc("\u2591", Color.RED); break;
				case 'R': output.appendc("\u2593", Color.RED); break;
				case 'g': output.appendc("\u2591", Color.GREEN); break;
				case 'G': output.appendc("\u2593", Color.GREEN); break;
				case 'b': output.appendc("\u2591", Color.BLUE); break;
				case 'B': output.appendc("\u2593", Color.BLUE); break;
				case 'c': output.appendc("\u2591", Color.CYAN); break;
				case 'C': output.appendc("\u2593", Color.CYAN); break;
				case 'm': output.appendc("\u2591", Color.MAGENTA); break;
				case 'M': output.appendc("\u2593", Color.MAGENTA); break;
				case 'y': output.appendc("\u2591", Color.YELLOW); break;
				case 'Y': output.appendc("\u2593", Color.YELLOW); break;
				case 'k': output.appendc("\u2591", Color.GRAY); break;
				case 'K': output.appendc("\u2593", Color.GRAY); break;
				case 'w': output.append("\u2591"); break;
				case 'W': output.append("\u2593"); break;
				case '0': output.append("\u2501"); break; //horizontal wall
				case '1': output.append("\u2503"); break; //vertical wall
				case '2': output.append("\u250F"); break; //top left corner
				case '3': output.append("\u2513"); break; //top right corner
				case '4': output.append("\u2517"); break; //bottom left corner
				case '5': output.append("\u251B"); break; //bottom right corner
				case '6': output.append("\u2523"); break; //left T-intersection
				case '7': output.append("\u252B"); break; //right T-intersection
				case '8': output.append("\u2533"); break; //top T-intersection
				case '9': output.append("\u253B"); break; //bottom T-intersection
				case 'a': output.append("\u254B"); break; //4-way intersection
				case 'A': output.appendc("\u2620", Color.RED); break;
				case 'x': output.appendc("\u2613", Color.YELLOW); break;
				case 'p': output.appendc("\u265B", Color.BLUE); break;
				case ' ': output.appendc("\u2593", Color.BLACK); break;
				default: output.append(Character.toString(mapChars[map][i][j]));
				}
			}
			output.appendln();
		}
		output.print("");
	}
	
}
