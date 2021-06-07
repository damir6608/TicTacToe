package com.example.tictactoe;

public class TicTac {
    public static int [][] tictac  =new int [3][3];
    public static boolean win = false;
    public static boolean lose = false;
    public static void Fill()
    {
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                tictac[j][i] = 0;
            }
        }
        TicTac.win = false;
    }

    public static void PushX(int x,int y)
    {
        for (int i = 0; i <3 ; i++)
        {
            for (int j = 0; j <3; j++)
            {
                if(j==x && i==y) {
                    tictac[j][i] = 1;
                }
            }
        }
        for (int i = 0; i <3 ; i++)
        {
            int winLine=0;
            int winСolumn = 0;
            int winRightDiagonal = 0;
            int winLeftDiagonal = 0;
            for (int j = 0; j <3; j++)
            {
                if(tictac[j][i]==1) {//проверка на строки
                    winLine++;
                }
                if(tictac[i][j]==1) {//проверка на столбцы
                    winСolumn++;
                }
                if(tictac[j][j]==1) {//проверка на правую диагональ
                    winRightDiagonal++;
                }
                if(tictac[2-j][j]==1) {//проверка на правую диагональ
                    winLeftDiagonal++;
                }
            }
            if(winLine==3||winСolumn==3||winRightDiagonal==3||winLeftDiagonal==3)
            {
                TicTac.win = true;
            }
        }
    }
    public static void PushO(int x,int y)
    {
        for (int i = 0; i <3 ; i++)
        {
            for (int j = 0; j <3; j++)
            {
                if(j==x && i==y) {
                    tictac[j][i] = 2;
                }
            }
        }
        for (int i = 0; i <3 ; i++)
        {
            int winLine=0;
            int winСolumn = 0;
            int winRightDiagonal = 0;
            int winLeftDiagonal = 0;
            for (int j = 0; j <3; j++)
            {
                if(tictac[j][i]==2) {//проверка на строки
                    winLine++;
                }
                if(tictac[i][j]==2) {//проверка на столбцы
                    winСolumn++;
                }
                if(tictac[j][j]==2) {//проверка на правую диагональ
                    winRightDiagonal++;
                }
                if(tictac[2-j][j]==2) {//проверка на правую диагональ
                    winLeftDiagonal++;
                }
            }
            if(winLine==3||winСolumn==3||winRightDiagonal==3||winLeftDiagonal==3)
            {
                TicTac.win = true;
            }
        }



    }

}
