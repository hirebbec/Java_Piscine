package com.company.logic;

import java.util.Scanner;

public class Player {
    private int x;
    private int y;
    private final char [][]map;

    public Player(int x, int y, char [][]map){
        this.x = x;
        this.y = y;
        this.map = map;
    }


    public void doStep(MapSettings settings){
        String cmd;
        int x = getX(), y = getY();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            x = getX();
            y = getY();
            cmd = scanner.nextLine();
            switch (cmd) {
                case "W":
                    y--;
                    break;
                case "S":
                    y++;
                    break;
                case "A":
                    x--;
                    break;
                case "D":
                    x++;
                    break;
                case "9":
                    System.out.println("loser");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Wrong command");
                    continue;
            }
            if (x > -1 && y > -1 && x < this.map[0].length && y < this.map[0].length){
                if (map[y][x] == settings.getEnemyChar()){
                    System.out.println("loser");
                    System.exit(0);
                }
                else if (map[y][x] == settings.getFinishChar()){
                    System.out.println("GRATZ");
                    System.exit(1);
                }
                else if (map[y][x] != settings.getWallChar()) {
                    this.map[this.y][this.x] = settings.getEmptyChar();
                    this.y = y;
                    this.x = x;
                    this.map[this.y][this.x] = settings.getPlayerChar();
                }
                else {
                    System.err.println("Еhe player crashed into the wall, he misses his turn");
                    break ;
                }
            }
            else {
                System.err.println("Player out of map");
                System.exit(-1);
            }
            break ;
        }
    }

    public int getY() {
        int Y = y;
        return Y;
    }

    public int getX() {
        int X = x;
        return X;
    }
}
