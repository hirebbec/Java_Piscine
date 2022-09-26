package com.company.logic;

import java.util.List;

public class Phantom {
	private final int phantom_x;
	private final int phantom_y;
	private int length;
	private int status;
	private final char firstStep;
	private final char [][]map;

	Phantom (int x, int y, int length, char firstStep, char [][]map){
		this.phantom_x = x;
		this.phantom_y = y;
		this.length = length;
		this.status = 0;
		this.firstStep = firstStep;
		this.map = map;
	}

	public void doStep(int player_x, int player_y, List <Phantom> list, MapSettings settings){
		if (phantom_x == player_x && phantom_y == player_y){
			this.status = 1;
			return ;
		}
		length++;
		if (phantom_y - 1 > -1) {
			if (map[phantom_y - 1][phantom_x] != settings.getWallChar() && map[phantom_y - 1][phantom_x] != settings.getPhantomChar() && map[phantom_y - 1][phantom_x] != settings.getFinishChar()) {
				if (length == 1) {
					list.add(new Phantom(phantom_x, phantom_y - 1, length, 'W', map));
				} else {
					list.add(new Phantom(phantom_x, phantom_y - 1, length, this.firstStep, map));
				}
				map[phantom_y - 1][phantom_x] = settings.getPhantomChar();
			}
		}
		if (phantom_y + 1 < map[0].length) {
			if (map[phantom_y + 1][phantom_x] != settings.getWallChar() && map[phantom_y + 1][phantom_x] != settings.getPhantomChar() && map[phantom_y + 1][phantom_x] != settings.getFinishChar()) {
				if (length == 1) {
					list.add(new Phantom(phantom_x, phantom_y + 1, length, 'S', map));
				} else {
					list.add(new Phantom(phantom_x, phantom_y + 1, length, this.firstStep, map));
				}
				map[phantom_y + 1][phantom_x] = settings.getPhantomChar();
			}
		}
		if (phantom_x - 1 > -1) {
			if (map[phantom_y][phantom_x - 1] != settings.getWallChar() && map[phantom_y][phantom_x - 1] != settings.getPhantomChar() && map[phantom_y][phantom_x - 1] != settings.getFinishChar()) {
				if (length == 1) {
					list.add(new Phantom(phantom_x - 1, phantom_y, length, 'A', map));
				} else {
					list.add(new Phantom(phantom_x - 1, phantom_y, length, this.firstStep, map));
				}
				map[phantom_y][phantom_x - 1] = settings.getPhantomChar();
			}
		}
		if (phantom_x + 1 < map[0].length) {
			if (map[phantom_y][phantom_x + 1] != settings.getWallChar() && map[phantom_y][phantom_x + 1] != settings.getPhantomChar() && map[phantom_y][phantom_x + 1] != settings.getFinishChar()) {
				if (length == 1) {
					list.add(new Phantom(phantom_x + 1, phantom_y, length, 'D', map));
				} else {
					list.add(new Phantom(phantom_x + 1, phantom_y, length, this.firstStep, map));
				}
				map[phantom_y][phantom_x + 1] = settings.getPhantomChar();
			}
		}
		map[phantom_y][phantom_x] = settings.getWallChar();
		list.remove(this);
	}

	public int getLength() {
		return length;
	}

	public int getStatus() {
		return status;
	}

	public char getFirstStep() {
		return firstStep;
	}

	public int getPhantom_x() {
		return phantom_x;
	}

	public int getPhantom_y() {
		return phantom_y;
	}
}

