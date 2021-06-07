package com.example.tictactoe;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

class Point {
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "[" + x + ", " + y + "]";
    }
}
class PointsAndScores {
    int score;
    Point point;

    PointsAndScores(int score, Point point){
        this.score = score;
        this.point = point;
    }
}

    public class MinimaxAI {

    }