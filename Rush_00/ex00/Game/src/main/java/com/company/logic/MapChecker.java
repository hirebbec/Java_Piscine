package com.company.logic;

import java.util.ArrayList;
import java.util.List;

public class MapChecker {
	private final int x;
	private final int y;
	private final char [][]map;
	private final List<MapPhantom> phantoms;

	public MapChecker(int x, int y, char [][]map){
		this.x = x;
		this.y = y;
		this.map = map;
		this.phantoms = new ArrayList<>();
	}

	public int Check(int exit_x, int exit_y, MapSettings mapSettings){
		boolean flag = true;
		phantoms.add(new MapPhantom(getX(), getY(), getMapCopy()));
		while (flag) {
			MapPhantom[] Array = phantoms.toArray(new MapPhantom[0]);
			if (Array.length == 0) {
				return 0;
			}
			for (int i = 0; i < Array.length; i++) {
				if (Array[i].getStatus() == 1) {
					flag = false;
					return 1;
				}
				Array[i].doStep(exit_x, exit_y, phantoms, mapSettings);
			}
		}
		return 1;
	}

	public int getX() {
		int X = x;
		return X;
	}

	public int getY() {
		int Y = y;
		return Y;
	}

	public char[][] getMapCopy() {
		char [][]mapCopy = new char[map[0].length][map[0].length];
		for (int i = 0; i < map[0].length; i++){
			for (int j = 0;j < map[0].length; j++){
				mapCopy[i][j] = map[i][j];
			}
		}
		return (mapCopy);
	}
}
