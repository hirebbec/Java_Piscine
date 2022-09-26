package com.company.logic;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class ArgsParser {
    public ArgsParser(String[] args) {
        JCommander.newBuilder()
                .addObject(this)
                .build()
                .parse(args);
    }

    @Parameter(names = "--enemiesCount")
    public static int enemiesCount;
    @Parameter(names = "--wallsCount")
    public static int wallsCount;
    @Parameter(names = "--size")
    public static int size;
    @Parameter(names = "--profile")
    public static String profile;
}
