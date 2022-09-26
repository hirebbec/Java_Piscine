package com.company.logic;

import java.util.ArrayList;
import java.util.List;

public class Enemy {
	private int x;
	private int y;
	private final char [][]map;
	private final List<Phantom> phantoms;

	Enemy(int x, int y, char [][]map){
		this.x = x;
		this.y = y;
		this.map = map;
		this.phantoms = new ArrayList<>();
	}

	public void doStep(int player_x, int player_y, MapSettings settings){
		boolean flag = true;
		char step = 'W';
		phantoms.add(new Phantom(getX(), getY(), 0, 'W', getMapCopy()));
		while (flag) {
			Phantom[] Array = phantoms.toArray(new Phantom[0]);
			if (Array.length == 0) {
				return ;
			}
			for (int i = 0; i < Array.length; i++) {
				if (Array[i].getStatus() == 1) {
					step = Array[i].getFirstStep();
					flag = false;
					break;
				}
				Array[i].doStep(player_x, player_y, phantoms, settings);
			}
		}
		map[y][x] = settings.getEmptyChar();
		if (step == 'W'){
			y--;
			if (map[y][x] == settings.getEnemyChar()){y++;}
		}
		else if (step == 'S'){
			y++;
			if (map[y][x] == settings.getEnemyChar()){y--;}
		}
		else if (step == 'A'){
			x--;
			if (map[y][x] == settings.getEnemyChar()){x++;}
		}
		else if (step == 'D'){
			x++;
			if (map[y][x] == settings.getEnemyChar()){x--;}
		}
		phantoms.clear();
		if (y == player_y && x == player_x){
			System.out.println("The player was killed by enemies");
			System.exit(-1);
		}
		map[y][x] = settings.getEnemyChar();
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

