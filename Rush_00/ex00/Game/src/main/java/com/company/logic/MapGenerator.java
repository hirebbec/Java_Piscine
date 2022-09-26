package com.company.logic;

import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private final List<Enemy> enemiesPositions = new ArrayList<Enemy>();
    private static char[][]map;
    private int playerY;
    private int playerX;
    private int finishY;
    private int finishX;

    public MapGenerator(int size, int wallsCount, int enemyCount, char emptyChar, char playerChar, char enemyChar, char wallChar, char finishChar) {
        map = createMap(size);
        randomPlayer(map, playerChar, size, emptyChar, enemyChar, wallChar, finishChar);
        randomFinish(map, playerChar, size, emptyChar, enemyChar, wallChar, finishChar);
        if (wallsCount >= 1) {
            randomWalls(map, playerChar, size, emptyChar, enemyChar, wallChar, finishChar, wallsCount);
        }
        if (enemyCount >= 1) {
            randomEnemies(map, playerChar, size, emptyChar, enemyChar, wallChar, finishChar, enemyCount);
        }
        fillMap(map, playerChar, size, emptyChar, enemyChar, wallChar, finishChar);
        getPositions(map, playerChar, finishChar, size);
        saveEnemiesPositions(map, enemyChar, size);
    }

    private static char[][] createMap(int size) {
        return (new char[size][size]);
    }

    private void randomPlayer(char[][] map, char playerChar, int size, char emptyChar, char enemyChar, char wallChar, char finishChar) {
        boolean isPlayerPlaced = false;
        int playerX;
        int playerY;
        while (!isPlayerPlaced) {
            playerX = (int) (Math.random() * size);
            playerY = (int) (Math.random() * size);
            if (map[playerY][playerX] != playerChar && map[playerY][playerX] != finishChar && map[playerY][playerX] != wallChar && map[playerY][playerX] != enemyChar && map[playerY][playerX] != emptyChar) {
                map[playerY][playerX] = finishChar;
                this.playerX = playerX;
                this.playerY = playerY;
                isPlayerPlaced = true;
            }
        }
    }

    private void randomFinish(char[][] map, char playerChar, int size, char emptyChar, char enemyChar, char wallChar, char finishChar) {
        boolean isFinishPlaced = false;
        int finishX;
        int finishY;
        while (!isFinishPlaced) {
            finishX = (int) (Math.random() * size);
            finishY = (int) (Math.random() * size);
            if (map[finishY][finishX] != playerChar && map[finishY][finishX] != finishChar && map[finishY][finishX] != wallChar && map[finishY][finishX] != enemyChar && map[finishY][finishX] != emptyChar) {
                map[finishY][finishX] = playerChar;
                this.finishX = finishX;
                this.finishY = finishY;
                isFinishPlaced = true;
            }
        }
    }

    private static void randomWalls(char[][] map, char playerChar, int size, char emptyChar, char enemyChar, char wallChar, char finishChar, int wallsCount) {
        boolean isWallsPlaced = false;
        int wallX;
        int wallY;
        while (!isWallsPlaced) {
            wallX = (int) (Math.random() * size);
            wallY = (int) (Math.random() * size);
            if (map[wallY][wallX] != playerChar && map[wallY][wallX] != finishChar && map[wallY][wallX] != emptyChar && map[wallY][wallX] != wallChar && map[wallY][wallX] != enemyChar && wallsCount != 0) {
                map[wallY][wallX] = wallChar;
                wallsCount--;
                if (wallsCount == 0) {
                    isWallsPlaced = true;
                }
            }
        }
    }

    private static void randomEnemies(char[][] map, char playerChar, int size, char emptyChar, char enemyChar, char wallChar, char finishChar, int enemyCount) {
        boolean isEnemiesPlaced = false;
        int enemyX;
        int enemyY;
        while (!isEnemiesPlaced) {
            enemyX = (int) (Math.random() * size);
            enemyY = (int) (Math.random() * size);
            if (map[enemyY][enemyX] != playerChar && map[enemyY][enemyX] != enemyChar && map[enemyY][enemyX] != emptyChar && map[enemyY][enemyX] != wallChar && map[enemyY][enemyX] != finishChar && enemyCount != 0) {
                map[enemyY][enemyX] = enemyChar;
                enemyCount--;
                if (enemyCount == 0) {
                    isEnemiesPlaced = true;
                }
            }
        }
    }

    private static void fillMap(char[][] map, char playerChar, int size, char emptyChar, char enemyChar, char wallChar, char finishChar) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] != playerChar && map[i][j] != wallChar && map[i][j] != emptyChar && map[i][j] != enemyChar && map[i][j] != finishChar)
                    map[i][j] = emptyChar;
            }
        }
    }

    private void getPositions(char[][] map, char playerChar, char finishChar, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == playerChar) {
                    this.playerY = i;
                    this.playerX = j;
                } else if (map[i][j] == finishChar) {
                    this.finishY = i;
                    this.finishX = j;
                }
            }
        }
    }

    private void saveEnemiesPositions(char[][] map, char enemyChar, int size) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == enemyChar) {
                    this.enemiesPositions.add(index, new Enemy(j, i, map));
                    index++;
                }
            }
        }
    }

    public char[][] getMap() {
        return (map);
    }

    public int getPlayerX() {
        return (playerX);
    }

    public int getPlayerY() {
        return (playerY);
    }

    public int getFinishY() {
        return (finishY);
    }

    public int getFinishX() {
        return (finishX);
    }

    public List<Enemy> getEnemiesPositions() {
        return (enemiesPositions);
    }
}
