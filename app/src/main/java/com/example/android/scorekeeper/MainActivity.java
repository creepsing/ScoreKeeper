package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int scoreA = 0;
    public int scoreB = 0;
    public int strikeA = 0;
    public int strikeB = 0;
    public int ballA = 0;
    public int ballB = 0;
    public int outA = 0;
    public int outB = 0;
    public boolean isApitching = true;

    // team A functions start
    private void addScoreTeamA(View v){
        if(isApitching)
            return;

        scoreA++;
        display();
    }

    private void addStrikeTeamA(View v){
        if(isApitching)
            return;

        if(strikeA<3)
            strikeA++;
        if(strikeA==3){
            strikeA = 0;
            addOutTeamA(v);
        }
        display();

    }

    private void addBallTeamA(View v){
        if(isApitching)
            return;

        if(ballA<4)
            ballA++;
        display();
    }

    private void addOutTeamA(View v){
        if(isApitching)
            return;

        if(outA<3)
            outA++;
        if(outA==3) {
            strikeA = 0;
            ballA = 0;
            outA = 0;
            isApitching = !isApitching;
        }
    }
    // team A functions end


    // team B functions start
    private void addScoreTeamB(View v){
        if(!isApitching)
            return;

        scoreB++;
        display();
    }

    private void addStrikeTeamB(View v){
        if(!isApitching)
            return;

        if(strikeB<3)
            strikeB++;
        if(strikeB==3){
            strikeB = 0;
            addOutTeamB(v);
        }
        display();

    }

    private void addBallTeamB(View v){
        if(!isApitching)
            return;

        if(ballB<4)
            ballB++;
        display();
    }

    private void addOutTeamB(View v){
        if(!isApitching)
            return;

        if(outB<3)
            outB++;
        if(outB==3) {
            strikeB = 0;
            ballB = 0;
            outB = 0;
            isApitching = !isApitching;
        }
    }
    // team B functions end


    private void display(){

    }



}
