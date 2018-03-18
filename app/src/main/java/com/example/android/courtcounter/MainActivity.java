package com.example.android.courtcounter;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    int team1 = 0; //for Team A scores
    int team2 = 0; //for Team B scores
    boolean counterRunning = false; //for counter status

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Add 3 Points to Team A
     */
    public void addThreeTeamA(View v) {
        displayForTeamA(3);
    }

    /**
     * Add 2 Points to Team A
     */
    public void addTwoTeamA(View v) {
        displayForTeamA(2);
    }

    /**
     * Add 1 Points to Team A
     */
    public void addOneTeamA(View v) {
        displayForTeamA(1);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        team1 = team1 + score;
        scoreView.setText(String.valueOf(team1));
    }

    /**
     * Add 3 Points to Team B
     */
    public void addThreeTeamB(View v) {
        displayForTeamB(3);
    }


    /**
     * Add 2 Points to Team B
     */
    public void addTwoTeamB(View v) {
        displayForTeamB(2);
    }


    /**
     * Add 1 Points to Team B
     */
    public void addOneTeamB(View v) {
        displayForTeamB(1);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        team2 = team2 + score;
        scoreView.setText(String.valueOf(team2));
    }

    /**
    * Count Down Timer for result display
     */
    public void counter(View view) {

        final TextView mTextField = findViewById(R.id.counter);
        final TextView mGameStats = findViewById(R.id.game_status);
        final Button btn = findViewById(R.id.start);
        final Button btn1 = findViewById(R.id.team_a1);
        final Button btn2 = findViewById(R.id.team_a2);
        final Button btn3 = findViewById(R.id.team_a3);
        final Button btn4 = findViewById(R.id.team_b1);
        final Button btn5 = findViewById(R.id.team_b2);
        final Button btn6 = findViewById(R.id.team_b3);
        final Button reset = findViewById(R.id.reset);

        btn.setEnabled(false);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        reset.setEnabled(false);
        /**
         * Countdown function
         */
        CountDownTimer mCounter = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                mGameStats.setText("Game Started...");
                mTextField.setText(String.format("Time Left: %s", String.format("%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))));
            }

            public void onFinish() {
                reset.setEnabled(true);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);

                if (team1 == team2)
                    mGameStats.setText("Tie Game. Better luck next time!!!");

                else if (team1 > team2)
                    mGameStats.setText("\"Congratulations,Team " + (getString(R.string.teamA)) + " is winner.!!!\"");
                    //mGameStats.setText(String.format("Congratulations, %s is winner.!!!" + (getString(R.string.teamA)) ));

                else
                    mGameStats.setText("\"Congratulations,Team " + (getString(R.string.teamB)) + " is winner.!!!\"");
                //mGameStats.setText(String.format("Congratulations, %s is winner.!!!" + getString(R.string.teamB) ));

                //mGameStats.setText(String.format(" %d : %d : %d",team1,team2,(team1+team2)));
                mTextField.setText("Game finished.!!!");


            }
        };
        if (!counterRunning) {
            counterRunning = true;
            mCounter.start();
        }

    }

    public void reset(View view) {
        /**
         * Reset game details
         */
        final TextView mTextField = findViewById(R.id.counter);
        final TextView mGameStats = findViewById(R.id.game_status);
        final Button btn = findViewById(R.id.start);
        final Button btn1 = findViewById(R.id.team_a1);
        final Button btn2 = findViewById(R.id.team_a2);
        final Button btn3 = findViewById(R.id.team_a3);
        final Button btn4 = findViewById(R.id.team_b1);
        final Button btn5 = findViewById(R.id.team_b2);
        final Button btn6 = findViewById(R.id.team_b3);
        final TextView scoreView1 = findViewById(R.id.team_b_score);
        final TextView scoreView = findViewById(R.id.team_a_score);
        counterRunning = false;
        team2 = 0;
        team1 = 0;
        btn.setEnabled(true);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        mTextField.setText((getString(R.string.time)));
        scoreView.setText((getString(R.string._zero)));
        scoreView1.setText((getString(R.string._zero)));
        mGameStats.setText((getString(R.string.game)));

    }
}
