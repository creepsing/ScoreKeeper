package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    public int inning = 1;
    public boolean isAbatting = true;
    public boolean gameEnd = false;


    // team A functions start
    public void addScoreTeamA(View v) {
        if (!isAbatting || gameEnd)
            return;

        scoreA++;
        display();
    }

    public void addStrikeTeamA(View v) {
        if (!isAbatting || gameEnd)
            return;

        if (strikeA < 3)
            strikeA++;
        if (strikeA == 3) {
            strikeA = 0;
            addOutTeamA(v);
        }
        display();

    }

    public void addBallTeamA(View v) {
        if (!isAbatting || gameEnd)
            return;

        if (ballA < 4)
            ballA++;
        display();
    }

    public void addOutTeamA(View v) {
        if (!isAbatting || gameEnd)
            return;
        strikeA = 0;
        ballA = 0;

        if (outA < 3)
            outA++;
        if (outA == 3) {
             outA = 0;
            isAbatting = !isAbatting;
                    }
        display();
    }
    // team A functions end


    // team B functions start
    public void addScoreTeamB(View v) {
        if (isAbatting || gameEnd)
            return;

        scoreB++;
        display();
    }

    public void addStrikeTeamB(View v) {
        if (isAbatting || gameEnd)
            return;

        if (strikeB < 3)
            strikeB++;
        if (strikeB == 3) {
            strikeB = 0;
            addOutTeamB(v);
        }
        display();

    }

    public void addBallTeamB(View v) {
        if (isAbatting || gameEnd)
            return;

        if (ballB < 4)
            ballB++;
        display();
    }

    public void addOutTeamB(View v) {
        if (isAbatting || gameEnd)
            return;
        strikeB = 0;
        ballB = 0;

        if (outB < 3)
            outB++;

        if (outB == 3) {
            outB = 0;
            isAbatting = !isAbatting;
            if(inning == 9)
                gameEnd = true;
            else
                inning++;
        }
        display();
    }
    // team B functions end


    public void resetGame(View v){

        scoreA = 0;
         scoreB = 0;
         strikeA = 0;
         strikeB = 0;
         ballA = 0;
        ballB = 0;
        outA = 0;
        outB = 0;
        inning = 1;
        isAbatting = true;
       gameEnd = false;
       display();
    }

    private void display() {
        TextView aScore = (TextView) findViewById(R.id.teamAscore);
        TextView aStrike = (TextView) findViewById(R.id.teamAstrike);
        TextView aBall = (TextView) findViewById(R.id.teamAball);
        TextView aOut = (TextView) findViewById(R.id.teamAout);
        TextView bScore = (TextView) findViewById(R.id.teamBscore);
        TextView bStrike = (TextView) findViewById(R.id.teamBstrike);
        TextView bBall = (TextView) findViewById(R.id.teamBball);
        TextView bOut = (TextView) findViewById(R.id.teamBout);
        TextView inning_view = (TextView) findViewById(R.id.inning);
        TextView isAbatting_view = (TextView) findViewById(R.id.isAbatting);

        if(gameEnd) {
            strikeA = strikeB = ballA = ballB = outA = outB = 0;
            ((TextView) findViewById(R.id.gameEnd)).setText("Game End");
        }

        aScore.setText("" + scoreA);
        aStrike.setText("" + strikeA);
        aBall.setText("" + ballA);
        aOut.setText("" + outA);

        bScore.setText("" + scoreB);
        bStrike.setText("" + strikeB);
        bBall.setText("" + ballB);
        bOut.setText("" + outB);

        inning_view.setText("" + inning);
        if(isAbatting)
            isAbatting_view.setText("▶");
        else
            isAbatting_view.setText("◀");




    }


}
