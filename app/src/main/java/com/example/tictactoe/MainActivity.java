package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.tictactoe.Switcher.isO;
import static com.example.tictactoe.Switcher.isX;

public class MainActivity extends AppCompatActivity {
    TextView edit0_0,edit0_1,edit0_2,edit1_0,edit1_1,edit1_2,edit2_0,edit2_1,edit2_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit0_0 = (TextView) findViewById(R.id.textView0_0);
        edit0_1 = (TextView) findViewById(R.id.textView0_1);
        edit0_2 = (TextView) findViewById(R.id.textView0_2);
        edit1_0 = (TextView) findViewById(R.id.textView1_0);
        edit1_1 = (TextView) findViewById(R.id.textView1_1);
        edit1_2 = (TextView) findViewById(R.id.textView1_2);
        edit2_0 = (TextView) findViewById(R.id.textView2_0);
        edit2_1 = (TextView) findViewById(R.id.textView2_1);
        edit2_2 = (TextView) findViewById(R.id.textView2_2);
        TicTac.Fill();
        edit0_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isX)
                {
                    TicTac.PushX(0,0);
                    edit0_0.setText("X" + TicTac.tictac[0][0]);
                    Switcher.offXonO();
                }
                else if(isO)
                {
                    TicTac.PushO(0,0);
                    edit0_0.setText("O" + TicTac.tictac[0][0]);
                    Switcher.offOonX();
                }
                if(TicTac.win)
                {
                    TicTac.Fill();
                    Toast.makeText(getApplicationContext(),"Победа",Toast.LENGTH_LONG).show();
                }
            }
        });
        edit0_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isX)
                {
                    TicTac.PushX(0,1);
                    edit0_1.setText("X"+ TicTac.tictac[0][1]);
                    Switcher.offXonO();
                }
                else if(isO)
                {
                    TicTac.PushO(0,1);
                    edit0_1.setText("O"+ TicTac.tictac[0][1]);
                    Switcher.offOonX();
                }
                if(TicTac.win)
                {
                    TicTac.Fill();
                    Toast.makeText(getApplicationContext(),"Победа",Toast.LENGTH_LONG).show();
                }
            }
        });
        edit0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isX)
                {
                    TicTac.PushX(0,2);
                    edit0_2.setText("X"+ TicTac.tictac[0][2]);
                    Switcher.offXonO();
                }
                else if(isO)
                {
                    TicTac.PushO(0,2);
                    edit0_2.setText("O"+ TicTac.tictac[0][2]);
                    Switcher.offOonX();
                }
                if(TicTac.win)
                {
                    TicTac.Fill();
                    Toast.makeText(getApplicationContext(),"Победа",Toast.LENGTH_LONG).show();
                }
            }
        });
        edit1_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isX)
                {
                    TicTac.PushX(1,0);
                    edit1_0.setText("X"+ TicTac.tictac[1][0]);
                    Switcher.offXonO();
                }
                else if(isO)
                {
                    TicTac.PushO(1,0);
                    edit1_0.setText("O"+ TicTac.tictac[1][0]);
                    Switcher.offOonX();
                }
                if(TicTac.win)
                {
                    TicTac.Fill();
                    Toast.makeText(getApplicationContext(),"Победа",Toast.LENGTH_LONG).show();
                }
            }
        });
        edit1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isX)
                {
                    TicTac.PushX(1,1);
                    edit1_1.setText("X"+ TicTac.tictac[1][1]);
                    Switcher.offXonO();
                }
                else if(isO)
                {
                    TicTac.PushO(1,1);
                    edit1_1.setText("O"+ TicTac.tictac[1][1]);
                    Switcher.offOonX();
                }
                if(TicTac.win)
                {
                    TicTac.Fill();
                    Toast.makeText(getApplicationContext(),"Победа",Toast.LENGTH_LONG).show();
                }
            }
        });
        edit1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isX)
                {
                    TicTac.PushX(1,2);
                    edit1_2.setText("X"+ TicTac.tictac[1][2]);
                    Switcher.offXonO();
                }
                else if(isO)
                {
                    TicTac.PushO(1,2);
                    edit1_2.setText("O"+ TicTac.tictac[1][2]);
                    Switcher.offOonX();
                }
                if(TicTac.win)
                {
                    TicTac.Fill();
                    Toast.makeText(getApplicationContext(),"Победа",Toast.LENGTH_LONG).show();
                }
            }
        });
        edit2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isX)
                {
                    TicTac.PushX(2,0);
                    edit2_0.setText("X"+ TicTac.tictac[2][0]);
                    Switcher.offXonO();
                }
                else if(isO)
                {
                    TicTac.PushO(2,0);
                    edit2_0.setText("O"+ TicTac.tictac[2][0]);
                    Switcher.offOonX();
                }
                if(TicTac.win)
                {
                    TicTac.Fill();
                    Toast.makeText(getApplicationContext(),"Победа",Toast.LENGTH_LONG).show();
                }
            }
        });
        edit2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isX)
                {
                    TicTac.PushX(2,1);
                    edit2_1.setText("X"+ TicTac.tictac[2][1]);
                    Switcher.offXonO();
                }
                else if(isO)
                {
                    TicTac.PushO(2,1);
                    edit2_1.setText("O"+ TicTac.tictac[2][1]);
                    Switcher.offOonX();
                }
                if(TicTac.win)
                {
                    TicTac.Fill();
                    Toast.makeText(getApplicationContext(),"Победа",Toast.LENGTH_LONG).show();
                }
            }
        });edit2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isX)
                {
                    TicTac.PushX(2,2);
                    edit2_2.setText("X"+ TicTac.tictac[2][2]);
                    Switcher.offXonO();
                }
                else if(isO)
                {
                    TicTac.PushO(2,2);
                    edit2_2.setText("O"+ TicTac.tictac[2][2]);
                    Switcher.offOonX();
                }
                if(TicTac.win)
                {
                    TicTac.Fill();
                    Toast.makeText(getApplicationContext(),"Победа",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}