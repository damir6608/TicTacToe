package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.tictactoe.Switcher.isO;
import static com.example.tictactoe.Switcher.isX;

public class AITicTacToe extends AppCompatActivity {
     public ImageView place0_0, place0_1,place0_2,place1_0,place1_1,place1_2,place2_0,place2_1,place2_2,replayGame, iconfFirstPlayer,iconSecondPlayer;
    private Timer mTimer;
    private MyTimerTask mMyTimerTask;
     ImageView Personplayer,AIPlayer, back;
     public boolean isBlue = false;
    Context context;
     public ImageView [][] cells = new ImageView[3][3];
        public int [][] board = new int[3][3];
    Board b = new Board();
    Random rand = new Random();
    int choice = 2;
Drawable first,second,zero;
    ImageView fieldOfToe;
    RelativeLayout relativeLayout;
    Animation imgAnimation, layoutAnimation,out_bottom,in_bottom,out_top,in_top;
    LottieAnimationView mainAnim, funnyBrain,winner,try_again,handshake,hourglass;

    TwoPlayerTicTac twoPlayerTicTac = new TwoPlayerTicTac();
    TextView player1,player2,result;
    MediaPlayer winSound,loseSound,drawSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_a_i_tic_tiac_toe);


        Bundle arg = getIntent().getExtras();

        imgAnimation = AnimationUtils.loadAnimation(AITicTacToe.this,R.anim.left_to_right);

        out_bottom = AnimationUtils.loadAnimation(AITicTacToe.this,R.anim.out_bottom);
        in_bottom = AnimationUtils.loadAnimation(AITicTacToe.this,R.anim.in_bottom);

        out_top = AnimationUtils.loadAnimation(AITicTacToe.this,R.anim.out_top);
        in_top = AnimationUtils.loadAnimation(AITicTacToe.this,R.anim.in_top);


        final MediaPlayer clickSound = MediaPlayer.create(this,R.raw.multyashnyiy);

        winSound = MediaPlayer.create(this,R.raw.win);


        loseSound = MediaPlayer.create(this,R.raw.lose);

        drawSound = MediaPlayer.create(this,R.raw.draw);

        layoutAnimation = AnimationUtils.loadAnimation(AITicTacToe.this,R.anim.left_to_right);

        mainAnim = findViewById(R.id.mainAnim);
        funnyBrain = findViewById(R.id.funnybrain);
        winner = findViewById(R.id.winner);
        handshake = findViewById(R.id.handshake);
        try_again = findViewById(R.id.try_again);
        hourglass = findViewById(R.id.hourglass);
        fieldOfToe = findViewById(R.id.fieldoftoe);
        relativeLayout = findViewById(R.id.relMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fieldOfToe.setVisibility(View.VISIBLE);
                        fieldOfToe.startAnimation(imgAnimation);

                        back.setVisibility(View.VISIBLE);
                        back.startAnimation(out_top);

                        if(arg.getBoolean("check"))
                        {
                            AIPlayer.setVisibility(View.VISIBLE);
                            Personplayer.setVisibility(View.VISIBLE);

                            AIPlayer.startAnimation(out_top);
                            Personplayer.startAnimation(out_top);
                        }
                        else{
                            player1.setVisibility(View.VISIBLE);
                            player1.setTextColor(Color.WHITE);
                            player1.startAnimation(out_top);

                            player2.setVisibility(View.VISIBLE);
                            player2.setTextColor(Color.LTGRAY);
                            player2.startAnimation(out_top);

                            iconfFirstPlayer.setVisibility(View.VISIBLE);
                            iconfFirstPlayer.setImageDrawable(ChooseIcons.icon1);
                            iconfFirstPlayer.startAnimation(out_top);

                            iconSecondPlayer.setVisibility(View.VISIBLE);
                            iconSecondPlayer.setImageDrawable(ChooseIcons.icon2);
                            iconSecondPlayer.startAnimation(out_top);
                        }


                        place0_0.setVisibility(View.VISIBLE);
                        place0_1.setVisibility(View.VISIBLE);
                        place0_2.setVisibility(View.VISIBLE);
                        place1_0.setVisibility(View.VISIBLE);
                        place1_1.setVisibility(View.VISIBLE);
                        place1_2.setVisibility(View.VISIBLE);
                        place2_0.setVisibility(View.VISIBLE);
                        place2_1.setVisibility(View.VISIBLE);
                        place2_2.setVisibility(View.VISIBLE);

                    }
                },1000);

            }
        }, 0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mainAnim.cancelAnimation();


            }
        },2650);

        back = findViewById(R.id.back);
        Personplayer =(ImageView) findViewById(R.id.PeoplePlayer);
        AIPlayer = (ImageView) findViewById(R.id.AIplayer);

        AIPlayer.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_adb_24white));
        Personplayer.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_person_24));

        place0_0 = findViewById(R.id.place0_0);
        place0_1 = findViewById(R.id.place0_1);
        place0_2 = findViewById(R.id.place0_2);
        place1_0 = findViewById(R.id.place1_0);
        place1_1 = findViewById(R.id.place1_1);
        place1_2 = findViewById(R.id.place1_2);
        place2_0 = findViewById(R.id.place2_0);
        place2_1 = findViewById(R.id.place2_1);
        place2_2 = findViewById(R.id.place2_2);

        result = findViewById(R.id.result);


        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);

        iconfFirstPlayer = findViewById(R.id.imagePlayer1);
        iconSecondPlayer = findViewById(R.id.imagePlayer2);

        replayGame = findViewById(R.id.restart_game);
        FillBut();
        FillMas();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Personplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                boolean skipping = true;
                for (int i = 0; i <board.length ; i++) {
                    for (int j = 0; j <board.length ; j++) {
                        if(board[i][j]==1 ||board[i][j]==2)skipping = false;
                    }
                }
                if(skipping)
                {
                    AIPlayer.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_adb_24white));
                    Personplayer.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_person_24));
                    choice = 2;
                }else Toast.makeText(getApplicationContext(),"Продолжите игру!",Toast.LENGTH_SHORT).show();

            }
        });
        AIPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                boolean skipping = true;
                for (int i = 0; i <board.length ; i++) {
                    for (int j = 0; j <board.length ; j++) {
                        if(board[i][j]==1 ||board[i][j]==2)skipping = false;
                    }
                }
                if(skipping)
                {
                    AIPlayer.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_adb_24));
                    Personplayer.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_person_24white));
                    choice = 1;
                    if(choice == 1){

                        Point p = new Point(rand.nextInt(3), rand.nextInt(3));

                        b.placeAMove(p,1);
                        b.displayBoard();
                    }
                }
                else Toast.makeText(getApplicationContext(),"Продолжите игру!",Toast.LENGTH_SHORT).show();

            }
        });


        replayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                winSound.stop();
                drawSound.stop();
                loseSound.stop();
                //todo
                if(handshake.getVisibility()==View.VISIBLE)
                {
                    handshake.startAnimation(in_top);
                }
                if(try_again.getVisibility()==View.VISIBLE)
                {
                    try_again.startAnimation(in_top);
                }
                if(winner.getVisibility()==View.VISIBLE)
                {
                    winner.startAnimation(in_top);
                }
                result.startAnimation(in_bottom);
                result.setVisibility(View.GONE);
                winner.setVisibility(View.GONE);
                handshake.setVisibility(View.GONE);
                try_again.setVisibility(View.GONE);
                if(arg.getBoolean("check"))
                ClearBoard();
                else twoPlayerTicTac.ClearTwoPlayer();
            }
        });

        place0_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                if(arg.getBoolean("check"))
                RunGame(0,0);
                else RungameTwoPlayer(0,0);
            }
        });

        place0_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                if(arg.getBoolean("check"))
                RunGame(1,0);
                else RungameTwoPlayer(1,0);
            }
        });

        place0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                if(arg.getBoolean("check"))
                RunGame(2,0);
                else RungameTwoPlayer(2,0);
            }
        });

        place1_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                if(arg.getBoolean("check"))
                RunGame(0,1);
                else RungameTwoPlayer(0,1);
            }
        });

        place1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                if(arg.getBoolean("check"))
                RunGame(1,1);
                else RungameTwoPlayer(1,1);
            }
        });

        place1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                if(arg.getBoolean("check"))
                RunGame(2,1);
                else RungameTwoPlayer(2,1);
            }
        });

        place2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                if(arg.getBoolean("check"))
                RunGame(0,2);
                else RungameTwoPlayer(0,2);
            }
        });

        place2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                if(arg.getBoolean("check"))
                RunGame(1,2);
                else RungameTwoPlayer(1,2);
            }
        });

        place2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound.start();
                if(arg.getBoolean("check"))
                RunGame(2,2);
                else RungameTwoPlayer(2,2);
            }
        });

    }
    public void getRestart()
    {
        replayGame.setVisibility(View.VISIBLE);
        replayGame.startAnimation(out_bottom);
    }


    public void ClearBoard()
    {
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board.length ; j++) {
                board[i][j]=0;
            }
        }
        OffOnBtn(true);
        b.displayBoard();

        replayGame.startAnimation(in_bottom);
        replayGame.setVisibility(View.GONE);

        AIPlayer.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_adb_24white));
        Personplayer.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_person_24));
        choice = 2;
    }
    public void OffOnBtn(boolean Switch)
    {
        for (int i = 0; i <cells.length ; i++) {
            for (int j = 0; j <cells.length ; j++) {

                    cells[i][j].setEnabled(Switch);

            }
        }
    }
    public void SwitchEnabled(ImageView Switch,boolean flag)
    {
        for (int i = 0; i <cells.length ; i++) {
            for (int j = 0; j <cells.length ; j++) {
                if(cells[i][j]!=Switch)
                {
                    cells[i][j].setEnabled(flag);
                }
            }
        }
        b.displayBoard();
    }

    public void RungameTwoPlayer(int x,int y)
    {
        cells[y][x].setEnabled(false);
        SwitchEnabled(cells[y][x],false);
        if(!twoPlayerTicTac.isGameOver())
        {
            if(isX)
            {
                player1.setTextColor(Color.GRAY);
                player2.setTextColor(Color.WHITE);
                hourglass.setVisibility(View.VISIBLE);
                hourglass.startAnimation(out_top);
                board[x][y] = 1;
                twoPlayerTicTac.displayBoardTwoPlayer();

                Switcher.offXonO();
            }
            else if(isO)
            {
                player2.setTextColor(Color.GRAY);
                player1.setTextColor(Color.WHITE);
                hourglass.setVisibility(View.VISIBLE);
                hourglass.startAnimation(out_top);
                board[x][y] = 2;
                twoPlayerTicTac.displayBoardTwoPlayer();
                Switcher.offOonX();
            }
        }
        OffOnBtn(true);
        twoPlayerTicTac.displayBoardTwoPlayer();
    }

    public void RunGame(int x,int y)
    {
        cells[y][x].setEnabled(false);
        SwitchEnabled(cells[y][x],false);
        if (!b.isGameOver()){
            b.placeAMove(b.userMove(x,y),2);
            b.displayBoard();
           if (b.isGameOver()) {
                return;
            }

            funnyBrain.setVisibility(View.VISIBLE);

            mTimer = new Timer();
            mMyTimerTask = new MyTimerTask();
            mTimer.schedule(mMyTimerTask, 2600);

        }

    }
    public  void FillBut(){

        cells[0][0] = place0_0;
        cells[1][0] = place0_1;
        cells[2][0] = place0_2;
        cells[0][1] = place1_0;
        cells[1][1] = place1_1;
        cells[2][1] = place1_2;
        cells[0][2] = place2_0;
        cells[1][2] = place2_1;
        cells[2][2] = place2_2;

    }
    public void FillMas(){

        for (int i = 0; i<3;i++)
        {
            for(int j = 0;j<3;j++)
            {
                board[i][j] = 0;
            }
        }
    }


    class Board {
        List<Point> availablePoints; // Создаём переменную для хранения доступных точек
        Scanner scan = new Scanner(System.in);


        public Board(){

        }


        /**
         * Проверка окончания игры
         * @return true or false
         */
        public boolean isGameOver(){
            return  (checkDraw()||checkWin(1) || checkWin(2) || getAvailableStates().isEmpty());
        }




        public Point userMove(int x, int y){

            return new Point(x, y);
        }

        /**
         * Вывод состояния игровой доски на экран
         */
        public void displayBoard(){
           for(int i = 0;i<3;i++)
           {
               for (int j = 0;j<3;j++)
               {
                   if(board[i][j]==1)
                   {
                       cells[i][j].setImageDrawable(ChooseIcons.icon1);
                       cells[i][j].setEnabled(false);
                   }
                   else if(board[i][j]==0)
                   {
                       cells[i][j].setImageDrawable(getResources().getDrawable(R.drawable.ic_round_hourglass_empty_24));

                   }
                   else if(board[i][j]==2)
                   {
                       cells[i][j].setImageDrawable(ChooseIcons.icon2);
                       cells[i][j].setEnabled(false);
                   }

               }
           }
           if(checkDraw())
           {

               drawSound.start();
               result.setText("Ничья!");
               result.setVisibility(View.VISIBLE);
               result.startAnimation(out_bottom);
               OffOnBtn(false);
               handshake.setVisibility(View.VISIBLE);
               handshake.startAnimation(out_top);
               getRestart();
           }
           if(b.checkWin(1)) {
               loseSound.start();
               result.setText("Выиграл бот!");
               result.setVisibility(View.VISIBLE);
               result.startAnimation(out_bottom);
               OffOnBtn(false);
               try_again.setVisibility(View.VISIBLE);
               try_again.startAnimation(out_top);
                getRestart();
            } else if (b.checkWin(2)) {
               winSound.start();
                result.setText("Вы выиграли!");
               result.setVisibility(View.VISIBLE);
               result.startAnimation(out_bottom);
               OffOnBtn(false);
                winner.setVisibility(View.VISIBLE);
               winner.startAnimation(out_top);
                getRestart();
            }

        }


        public boolean checkDraw()
        {
            int ans = 0;
            for(int i = 0;i<3;i++)
            {
                for (int j = 0;j<3;j++)
                {
                    if(board[i][j]==1 ||board[i][j]==2)
                    {
                        ans++;
                    }
                }
            }
            return ans == 9&&!b.checkWin(1)&&!b.checkWin(2);

        }

        public boolean checkWin(int playerSymbol){
            boolean checkLine, checkColumns, checkDiagonalA, checkDiagonalB;
            for (int i = 0; i < board.length; i++){
                checkLine = true;
                checkColumns = true;
                checkDiagonalA = true;
                checkDiagonalB = true;
                for (int j = 0; j < board.length; j++){
                    checkLine &= (board[i][j] == playerSymbol);
                    checkColumns &= (board[j][i] == playerSymbol);
                    checkDiagonalA &= (board[j][j] == playerSymbol);
                    checkDiagonalB &= (board[board.length - 1 - j][j] == playerSymbol);
                }
                if (checkLine || checkColumns || checkDiagonalA || checkDiagonalB) return true;
            }
            return false;
        }

        /**
         * Получить доступные состояния ходов
         * @return Возврат доступных точек для хода
         */
        public List<Point> getAvailableStates(){
            availablePoints = new ArrayList<Point>();
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(board[i][j] == 0) {
                        availablePoints.add(new Point(i, j));
                    }
                }
            }
            return availablePoints;
        }

        /**
         * Сделать ход
         * @param point координаты хода
         * @param playerSymbol символ игрока, или компьютера
         */
        public void placeAMove(Point point, int playerSymbol){
            board[point.x][point.y] = playerSymbol;
        }

        /**
         * Выбрать лучший ход
         * @return Координаты хода
         */
        public Point returnBestMove(){
            int MAX = - 100000;
            int best = -1;
            for (int i = 0; i < rootsChildrenScores.size(); ++i){
                if (MAX < rootsChildrenScores.get(i).score){
                    MAX = rootsChildrenScores.get(i).score;
                    best = i;
                }
            }
            return rootsChildrenScores.get(best).point;
        }

        /**
         * Возврат минимального значения
         * @param List
         * @return индекс минимального значения
         */
        public int returnMin(List<Integer> List){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < List.size(); ++i){
                if(List.get(i) < min){
                    min = List.get(i);
                    index = i;
                }
            }
            return List.get(index);
        }

        /**
         * Возврат максимального значения
         * @param List
         * @return индекс максимального значения
         */
        public int returnMax(List<Integer> List){
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int i = 0; i < List.size(); ++i){
                if(List.get(i) > max){
                    max = List.get(i);
                    index = i;
                }
            }
            return List.get(index);
        }

        /**
         * Создаём переменную для хранения координат и очков доступных клеток
         */
        List<PointsAndScores> rootsChildrenScores;

        /**
         * Вызов метода МиниМакс
         * @param depth глубина хода
         * @param turn очередь ходов игроков
         */
        public void callMiniMax(int depth, int turn){
            rootsChildrenScores = new ArrayList<PointsAndScores>();
            miniMax(depth, turn);
        }

        /**
         * Метод МиниМакс
         * @param depth глубина хода
         * @param turn поочередность ходов
         * @return Возвращаем максимальное значение, если ходит компьютер, или минимальное значение, если ходит человек
         */
        public int miniMax(int depth, int turn){

            if (checkWin(1)) return  +1;
            if (checkWin(2)) return  -1;

            List<Point> pointsAvailable = getAvailableStates(); // Переменная, которая получает список доступных точек
            if (pointsAvailable.isEmpty()) return 0;

            List<Integer> scores = new ArrayList<Integer>(); // Переменная хранения счета ходов

            for(int i = 0; i < pointsAvailable.size(); ++i){
                Point point = pointsAvailable.get(i);
                if (turn == 1) { // Ход компьютера
                    placeAMove(point, 1); // Совершение хода компьютера в доступную точку поля
                    int currentScore = miniMax(+1, 2); // Переменная текущего счета, которая вызывает метод miniMAx и передает новые параметры методу меняя очередь хода игрока
                    scores.add(currentScore); // Передаём результаты хода переменной подсчёта очков хода

                    if (depth == 0)
                        rootsChildrenScores.add(new PointsAndScores(currentScore, point)); // Добавление в переменную список индексов клеток и очков заработанных с этой клетки

                }else if (turn == 2){ // Совершение хода в доступную точку за человека
                    placeAMove(point, 2);

                    scores.add(miniMax(+1, 1)); // Передаем результат хода в переменную подсчёта очков хода, вызываем метод miniMax с новыми параметрами
                }
                board[point.x][point.y] = 0; // Очистка клетки поля
            }
            return turn == 1 ? returnMax(scores) : returnMin(scores); // Возвращаем максимальное значение, если ходит компьютер, или минимальное значение, если ходит человек
        }
    }
    class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    b.callMiniMax(0,1);
                    b.placeAMove(b.returnBestMove(),1);
                    OffOnBtn(true);
                    b.displayBoard();
                    funnyBrain.setVisibility(View.GONE);
                }
            });
        }
    }
    public class TwoPlayerTicTac
    {
        public TwoPlayerTicTac(){}

        public void ClearTwoPlayer(){
            for (int i = 0; i <board.length ; i++) {
                for (int j = 0; j <board.length ; j++) {
                    board[i][j] = 0;
                }
            }
            replayGame.startAnimation(in_bottom);
            replayGame.setVisibility(View.GONE);

            OffOnBtn(true);
            displayBoardTwoPlayer();
        }
        public boolean isGameOver()
        {
            return  (b.checkDraw()||b.checkWin(1) || b.checkWin(2));
        }


        public void displayBoardTwoPlayer(){
            for(int i = 0;i<3;i++)
            {
                for (int j = 0;j<3;j++)
                {
                    if(board[i][j]==1)
                    {
                        cells[i][j].setImageDrawable(ChooseIcons.icon1);
                        cells[i][j].setEnabled(false);
                    }
                    else if(board[i][j]==0)
                    {
                        cells[i][j].setImageDrawable(getResources().getDrawable(R.drawable.ic_round_hourglass_empty_24));

                    }
                    else if(board[i][j]==2)
                    {
                        cells[i][j].setImageDrawable(ChooseIcons.icon2);
                        cells[i][j].setEnabled(false);
                    }

                }
            }
            if(b.checkDraw())
            {
                drawSound.start();
                result.setText("Ничья!");
                result.setVisibility(View.VISIBLE);
                result.startAnimation(out_bottom);
                hourglass.setVisibility(View.GONE);
                OffOnBtn(false);
                handshake.setVisibility(View.VISIBLE);
                handshake.startAnimation(out_top);
                getRestart();
            }
            if(b.checkWin(1)) {
                winSound.start();
                result.setText("Победа игрок1!");
                result.setVisibility(View.VISIBLE);
                result.startAnimation(out_bottom);
                hourglass.setVisibility(View.GONE);
                OffOnBtn(false);
                winner.setVisibility(View.VISIBLE);
                winner.startAnimation(out_top);
                getRestart();
            } else if (b.checkWin(2)) {
                winSound.start();
                result.setText("Победа игрок2!");
                result.setVisibility(View.VISIBLE);
                result.startAnimation(out_bottom);
                hourglass.setVisibility(View.GONE);
                OffOnBtn(false);
                winner.setVisibility(View.VISIBLE);
                winner.startAnimation(out_top);
                getRestart();
            }

        }
    }
}
