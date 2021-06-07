package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;

public class PlayAnimation extends AppCompatActivity {

    ImageView fieldOfToe;
    RelativeLayout relativeLayout;
    Animation imgAnimation, layoutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_play_animation);

        imgAnimation = AnimationUtils.loadAnimation(PlayAnimation.this,R.anim.left_to_right);
        layoutAnimation = AnimationUtils.loadAnimation(PlayAnimation.this,R.anim.left_to_right);

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
                        fieldOfToe.setAnimation(imgAnimation);

                    }
                },1000);

            }
        }, 500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PlayAnimation.this,AITicTacToe.class);

                startActivity(intent);
            }
        },3000);
    }
}