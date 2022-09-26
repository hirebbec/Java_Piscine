package com.company.logic;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import java.util.Properties;

public class Printer {
    private static char[][] map;
    private final int mapSize;
    private final MapSettings mapSettings;

    String emptyColor;
    String enemyColor;
    String playerColor;
    String wallColor;
    String finishColor;

    public Printer(MapGenerator map, MapSettings mapSettings, Properties properties){
        this.map = map.getMap();
        this.mapSettings = mapSettings;
        this.mapSize = map.getMap().length;

        this.emptyColor = properties.getProperty("empty.color");
        this.enemyColor = properties.getProperty("enemy.color");
        this.playerColor = properties.getProperty("player.color");;
        this.wallColor = properties.getProperty("wall.color");
        this.finishColor = properties.getProperty("goal.color");
    }

    public void printMap() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == mapSettings.getEmptyChar()) {
                    System.out.print(Ansi.colorize(mapSettings.getEmptyChar()+"", getAttributeColor(emptyColor)));
                } else if (map[i][j] == mapSettings.getEnemyChar()) {
                    System.out.print(Ansi.colorize(mapSettings.getEnemyChar()+"", getAttributeColor(enemyColor)));
                } else if (map[i][j] == mapSettings.getPlayerChar()) {
                    System.out.print(Ansi.colorize(mapSettings.getPlayerChar()+"", getAttributeColor(playerColor)));
                } else if (map[i][j] == mapSettings.getWallChar()) {
                    System.out.print(Ansi.colorize(mapSettings.getWallChar()+"", getAttributeColor(wallColor)));
                } else if (map[i][j] == mapSettings.getFinishChar()) {
                    System.out.print(Ansi.colorize(mapSettings.getFinishChar()+"", getAttributeColor(finishColor)));
                }
            }
            System.out.println();
        }
    }

    private Attribute getAttributeColor(String color){
        switch (color) {
            case "RED":
                return Attribute.RED_BACK();
            case "GREEN":
                return Attribute.GREEN_BACK();
            case "BLUE":
                return Attribute.BLUE_BACK();
            case "BLACK":
                return Attribute.BLACK_BACK();
            case "WHITE":
                return Attribute.WHITE_BACK();
            case "MAGENTA" :
                return Attribute.MAGENTA_BACK();
            case "YELLOW" :
                return Attribute.YELLOW_BACK();
            case "BRIGHT_RED":
                return Attribute.BRIGHT_RED_BACK();
            case "BRIGHT_GREEN":
                return Attribute.BRIGHT_GREEN_BACK();
            case "BRIGHT_BLUE":
                return Attribute.BRIGHT_BLUE_BACK();
            case "BRIGHT_BLACK":
                return Attribute.BRIGHT_BLACK_BACK();
            case "BRIGHT_WHITE":
                return Attribute.BRIGHT_WHITE_BACK();
            default:
                throw new IllegalArgumentException("Invalid argument");
        }
    }
}
