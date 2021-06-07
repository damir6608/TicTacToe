package com.example.tictactoe;

public class Switcher {
    public static boolean isX = true;
    public static boolean isO = false;

    public static void offXonO()
    {
        isO = true;
        isX = false;
    }
    public static void offOonX()
    {
        isX = true;
        isO = false;
    }

}
