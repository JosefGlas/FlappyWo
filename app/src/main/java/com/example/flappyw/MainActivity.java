package com.example.flappyw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button Startbutton;
    View highscoreview;
    private SharedPreferences myPreferences;
    int highscore;
    private String sharedFile = "com.example.flappyw";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Constants.SCREEN_HEIGHT= displayMetrics.heightPixels;
        Constants.SCREEN_WIDTH= displayMetrics.widthPixels;




        myPreferences = getSharedPreferences(sharedFile, MODE_PRIVATE);
        highscore = myPreferences.getInt("highscore",0);

      TextView highscoreview = (TextView) findViewById(R.id.mainhigh);
        highscoreview.setText("Highscore: " + Integer.toString(highscore));



/*        Startbutton = (Button)findViewById(R.id.buttonstart);
        Startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Spielstart = new Intent(MainActivity.this,GameView.class);
                startActivity(Spielstart);
                setContentView(R.layout.game_view);

            }
        });*/


    }

    public void startGame(View view) {
        Intent go = new Intent(MainActivity.this, com.example.flappyw.StartGame.class);
        startActivity(go);
        overridePendingTransition(R.transition.transition_quick,R.transition.transition_quick);

        finish();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*Intent backmain = new Intent(MainActivity.this,MainActivity.class);
        startActivity(backmain);
        overridePendingTransition(R.transition.transition_quick,R.transition.transition_quick);
        finish();*/
        onPause();
    }

    public void startSound(View view) {
        Intent sound = new Intent(MainActivity.this,Soundrecorder.class);
        startActivity(sound);
        overridePendingTransition(R.transition.transition_quick,R.transition.transition_quick);
        finish();

    }
}
