package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MenuGame extends AppCompatActivity {
    Button aiPlayer,twoPlayers;
    RelativeLayout relativeLayout;
    Animation imgAnimation, layoutAnimation,out_bottom,in_bottom,out_top,in_top,rotate;;
    ImageView settings;
    MediaPlayer mediaPlayer;

    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu_game);
        ChooseIcons.icon1 = getDrawable(R.drawable.java);
        ChooseIcons.icon2 = getDrawable(R.drawable.python);
        relativeLayout = findViewById(R.id.relMain);
        aiPlayer = findViewById(R.id.btnAIPlayer);
        twoPlayers = findViewById(R.id.btnTwoPlayer);
        settings = findViewById(R.id.settings);

        dialog = new Dialog(this);


         mediaPlayer = MediaPlayer.create(this,R.raw.multyashnyiy);

        rotate = AnimationUtils.loadAnimation(MenuGame.this,R.anim.rotate);
        imgAnimation = AnimationUtils.loadAnimation(MenuGame.this,R.anim.left_to_right);

        out_bottom = AnimationUtils.loadAnimation(MenuGame.this,R.anim.out_bottom);
        in_bottom = AnimationUtils.loadAnimation(MenuGame.this,R.anim.in_bottom);

        out_top = AnimationUtils.loadAnimation(MenuGame.this,R.anim.out_top);
        in_top = AnimationUtils.loadAnimation(MenuGame.this,R.anim.in_top);

        layoutAnimation = AnimationUtils.loadAnimation(MenuGame.this,R.anim.out_bottom);
        Intent intent = new Intent(MenuGame.this,AITicTacToe.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        aiPlayer.setVisibility(View.VISIBLE);
                        twoPlayers.setVisibility(View.VISIBLE);
                      settings.setVisibility(View.VISIBLE);

                       settings.startAnimation(out_top);
                        aiPlayer.startAnimation(out_bottom);
                        twoPlayers.startAnimation(out_bottom);


                    }
                },2300);

            }
        }, 0);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.start();
                openSettingsDialog();
            }
        });
        aiPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                intent.putExtra("check",true);
                startActivity(intent);
            }
        });

        twoPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                intent.putExtra("check",false);
                startActivity(intent);
            }
        });
    }

    private void openSettingsDialog() {
        dialog.setContentView(R.layout.setting_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imgClosedialog = dialog.findViewById(R.id.imageViewClosed);
        Button btnOK = dialog.findViewById(R.id.btnOK);

        ImageView choose_alien_astronaut,choose_avocado_strawberry,choose_burger_borcht,choose_coding_dns,choose_cross_nolik,choose_java_python;

        choose_alien_astronaut = dialog.findViewById(R.id.choose_alien_astronaut2);
        choose_avocado_strawberry = dialog.findViewById(R.id.choose_cross_nolik2);
        choose_burger_borcht = dialog.findViewById(R.id.choose_alien_astronaut);
        choose_coding_dns = dialog.findViewById(R.id.choose_coding_dns);
        choose_cross_nolik = dialog.findViewById(R.id.choose_cross_nolik);
        choose_java_python = dialog.findViewById(R.id.choose_java_python);


        choose_alien_astronaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                ChooseIcons.icon1 = getDrawable(R.drawable.alien);
                ChooseIcons.icon2 = getDrawable(R.drawable.astronaut);
                choose_alien_astronaut.startAnimation(rotate);

            }
        });
        choose_avocado_strawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                ChooseIcons.icon1 = getDrawable(R.drawable.avocado);
                ChooseIcons.icon2 = getDrawable(R.drawable.strawberry);
                choose_avocado_strawberry.startAnimation(rotate);
            }
        });
        choose_burger_borcht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                ChooseIcons.icon1 = getDrawable(R.drawable.burger_sandwich);
                ChooseIcons.icon2 = getDrawable(R.drawable.borscht);
                choose_burger_borcht.startAnimation(rotate);
            }
        });
        choose_coding_dns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                ChooseIcons.icon1 = getDrawable(R.drawable.coding);
                ChooseIcons.icon2 = getDrawable(R.drawable.dns);
                choose_coding_dns.startAnimation(rotate);
            }
        });
        choose_cross_nolik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                ChooseIcons.icon1 = getDrawable(R.drawable.cross);
                ChooseIcons.icon2 = getDrawable(R.drawable.nolik);
                choose_cross_nolik.startAnimation(rotate);
            }
        });
        choose_java_python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                ChooseIcons.icon1 = getDrawable(R.drawable.java);
                ChooseIcons.icon2 = getDrawable(R.drawable.python);
                choose_java_python.startAnimation(rotate);
            }
        });

        imgClosedialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mediaPlayer.start();
                dialog.dismiss();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}