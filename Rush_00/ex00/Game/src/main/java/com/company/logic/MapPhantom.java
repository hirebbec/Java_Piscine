package com.company.logic;

import java.util.List;

public class MapPhantom {
	private final int phantom_x;
	private final int phantom_y;
	private int status;
	private final char [][]map;

	MapPhantom (int x, int y, char [][]map){
		this.phantom_x = x;
		this.phantom_y = y;
		this.status = 0;
		this.map = map;
	}

	public void doStep(int player_x, int player_y, List<MapPhantom> list, MapSettings settings) {
		if (phantom_x == player_x && phantom_y == player_y){
			this.status = 1;
			return ;
		}
		if (phantom_y - 1 > -1) {
			if (map[phantom_y - 1][phantom_x] != settings.getWallChar() && map[phantom_y - 1][phantom_x] != settings.getPhantomChar()) {
				list.add(new MapPhantom(phantom_x, phantom_y - 1, map));
				map[phantom_y - 1][phantom_x] = settings.getPhantomChar();
			}
		}
		if (phantom_y + 1 < map[0].length) {
			if (map[phantom_y + 1][phantom_x] != settings.getWallChar() && map[phantom_y + 1][phantom_x] != settings.getPhantomChar()) {
				list.add(new MapPhantom(phantom_x, phantom_y + 1, map));
				map[phantom_y + 1][phantom_x] = settings.getPhantomChar();
			}
		}
		if (phantom_x - 1 > -1) {
			if (map[phantom_y][phantom_x - 1] != settings.getWallChar() && map[phantom_y][phantom_x - 1] != 'P') {
				list.add(new MapPhantom(phantom_x - 1, phantom_y, map));
				map[phantom_y][phantom_x - 1] = settings.getPhantomChar();
			}
		}
		if (phantom_x + 1 < map[0].length) {
			if (map[phantom_y][phantom_x + 1] != settings.getWallChar() && map[phantom_y][phantom_x + 1] != 'P') {
				list.add(new MapPhantom(phantom_x + 1, phantom_y, map));
				map[phantom_y][phantom_x + 1] = settings.getPhantomChar();
			}
		}
		map[phantom_y][phantom_x] = settings.getWallChar();
		list.remove(this);
	}

	public int getStatus() {
		return status;
	}


	public int getPhantom_x() {
		return phantom_x;
	}

	public int getPhantom_y() {
		return phantom_y;
	}
}