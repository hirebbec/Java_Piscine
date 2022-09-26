package com.company.app;

import com.company.logic.*;

import java.util.Properties;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        if (args.length != 4){
            System.err.println("invalid argument");
            System.exit(-1);
        }
        if (!args[0].matches("--enemiesCount=\\d+") || !args[1].matches("--wallsCount=\\d+") || !args[2].matches("--size=\\d+") || !args[3].matches("--profile=\\w+")){
            System.err.println("invalid argument");
            System.exit(-1);
        }
        int k = 0;
        Player player;
        MapGenerator mapGenerator;
        ArgsParser argsParser = new ArgsParser(args);
        Properties properties = Settings.getSettings(ArgsParser.profile);
        MapSettings mapSettings = new MapSettings(
                ArgsParser.size,
                ArgsParser.size,
                ArgsParser.enemiesCount,
                ArgsParser.wallsCount,
                ArgsParser.profile,
                properties.getProperty("empty.char").charAt(0),
                properties.getProperty("player.char").charAt(0),
                properties.getProperty("enemy.char").charAt(0),
                properties.getProperty("wall.char").charAt(0),
                properties.getProperty("goal.char").charAt(0));
        if ((mapSettings.getEnemiesCount() + mapSettings.getWallsCount() - 2) >= mapSettings.getHeight() * mapSettings.getWidth()){
            System.out.println("Wrong arguments, walls count + enemies count is too big");
            System.exit(-1);
        }
        while (true) {
            mapGenerator = new MapGenerator(
                    mapSettings.getWidth(),
                    mapSettings.getWallsCount(),
                    mapSettings.getEnemiesCount(),
                    mapSettings.getEmptyChar(),
                    mapSettings.getPlayerChar(),
                    mapSettings.getEnemyChar(),
                    mapSettings.getWallChar(),
                    mapSettings.getFinishChar()
            );
            MapChecker mapChecker = new MapChecker(mapGenerator.getPlayerX(), mapGenerator.getPlayerY(), mapGenerator.getMap());
            if (mapChecker.Check(mapGenerator.getFinishX(), mapGenerator.getFinishY(), mapSettings) == 1) {
                player = new Player(mapGenerator.getPlayerX(), mapGenerator.getPlayerY(), mapGenerator.getMap());
                break;
            }
        }
        Enemy[] enemies = mapGenerator.getEnemiesPositions().toArray(new Enemy[0]);
        if (mapSettings.getMode().equals("production")) {
            while (true) {
                    new Printer(mapGenerator, mapSettings, properties).printMap();
                player.doStep(mapSettings);
                for (int i = 0; i < mapSettings.getEnemiesCount(); i++) {
                    enemies[i].doStep(player.getX(), player.getY(), mapSettings);
                }
            }
        } else if (mapSettings.getMode().equals("dev")) {
            while (true) {
                    new Printer(mapGenerator, mapSettings, properties).printMap();
                System.out.println("Your turn: input \"WASD\"");
                player.doStep(mapSettings);
                    new Printer(mapGenerator, mapSettings, properties).printMap();
                while (k < mapSettings.getEnemiesCount()) {
                    System.out.println("Enemy turn: input '8'");
                    Scanner scanner = new Scanner(System.in);
                    switch (scanner.nextLine()) {
                        case "8":
                            enemies[k].doStep(player.getX(), player.getY(), mapSettings);
                            k++;
                            break;
                        case "9":
                            System.out.println("You lose");
                            System.exit(0);
                        default:
                            System.out.println("Enemy turn: input '8'");
                    }
                    new Printer(mapGenerator, mapSettings, properties).printMap();
                }
                k = 0;
                System.out.println();
            }
        }
    }
}