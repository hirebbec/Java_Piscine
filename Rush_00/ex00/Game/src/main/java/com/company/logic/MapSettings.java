package com.company.logic;

import java.util.Random;

public class MapSettings {
    private int width;
    private int height;
    private int enemiesCount;
    private int wallsCount;
    private String mode;
    private char emptyChar;
    private char playerChar;
    private char enemyChar;
    private char wallChar;
    private char finishChar;
    private char phantomChar;
    private char[][] map;

    public MapSettings(
            int height,
            int width,
            int enemiesCount,
            int wallsCount,
            String mode,
            char emptyChar,
            char playerChar,
            char enemyChar,
            char wallChar,
            char finishChar
    ) {

        this.height = height;
        this.width = width;
        this.enemiesCount = enemiesCount;
        this.wallsCount = wallsCount;
        this.mode = mode;
        this.emptyChar = emptyChar;
        this.playerChar = playerChar;
        this.enemyChar = enemyChar;
        this.wallChar = wallChar;
        this.finishChar = finishChar;
        this.phantomChar = generatePhantomChar(wallChar, enemyChar, emptyChar, playerChar, finishChar);
        validateChars(wallChar, enemyChar, emptyChar, playerChar, finishChar);
    }

    private char generatePhantomChar(char wallChar, char enemyChar, char emptyChar, char playerChar, char finishChar) {
        Random r = new Random();
        char c = ' ';
        boolean charIsAdded = false;
        while (!charIsAdded) {
            c = (char)(r.nextInt(26) + 'A');
            if (c != wallChar && c != enemyChar && c != emptyChar && c != playerChar && c != finishChar) {
                charIsAdded = true;
            }
        }
        return (c);
    }

    private void validateChars(char wallChar, char enemyChar, char emptyChar, char playerChar, char finishChar) {
        if (wallChar == enemyChar || wallChar == emptyChar || wallChar == playerChar || wallChar == finishChar) {
            System.err.println("Config error");
            System.exit(-1);
        }
        if (enemyChar == emptyChar || enemyChar == finishChar || enemyChar == playerChar) {
            System.err.println("Config error");
            System.exit(-1);
        }
        if (emptyChar == playerChar || emptyChar == finishChar) {
            System.err.println("Config error");
            System.exit(-1);
        }
        if (playerChar == finishChar) {
            System.err.println("Config error");
            System.exit(-1);
        }
    }

    public String getMode() {
        return (mode);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getEnemiesCount() {
        return enemiesCount;
    }

    public void setEnemiesCount(int enemiesCount) {
        this.enemiesCount = enemiesCount;
    }

    public int getWallsCount() {
        return wallsCount;
    }

    public void setWallsCount(int wallsCount) {
        this.wallsCount = wallsCount;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public char getEmptyChar() {
        return emptyChar;
    }

    public void setEmptyChar(char emptyChar) {
        this.emptyChar = emptyChar;
    }

    public char getPlayerChar() {
        return playerChar;
    }

    public void setPlayerChar(char playerChar) {
        this.playerChar = playerChar;
    }

    public char getEnemyChar() {
        return enemyChar;
    }

    public void setEnemyChar(char enemyChar) {
        this.enemyChar = enemyChar;
    }

    public char getWallChar() {
        return wallChar;
    }

    public void setWallChar(char wallChar) {
        this.wallChar = wallChar;
    }

    public char getFinishChar() {
        return finishChar;
    }

    public void setFinishChar(char finishChar) {
        this.finishChar = finishChar;
    }

    public char getPhantomChar() {
        return phantomChar;
    }

    public void setPhantomChar(char phantomChar) {
        this.phantomChar = phantomChar;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }
}