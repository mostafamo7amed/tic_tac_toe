package com.mostafa.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
     TextView playerOneScore,playerTwoScore,playerState;
     Button [] buttons=new Button[9];
     Button rest;
     int playerOneScoreCount,playerTwoScoreCount,roundCount;
    boolean activePlayer;

    // p1==0
    // p2==1
    // empty=2
    int [] gameState={2,2,2,2,2,2,2,2,2};
    int [][] winningPosition={
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        playerOneScore= findViewById(R.id.playerOneScore);
        playerTwoScore= findViewById(R.id.playerTwoScore);
        playerState= findViewById(R.id.playerState);
        rest= findViewById(R.id.btu_rest);

        for (int i=0;i<buttons.length;i++)
        {
            String btuID="but_"+ i;
            int resID=getResources().getIdentifier(btuID,"id",getPackageName());
            buttons[i]= findViewById(resID);
            buttons[i].setOnClickListener(this);
        }
        roundCount=0;
        playerOneScoreCount=0;
        playerTwoScoreCount=0;
        activePlayer=true;


    }
    @Override
    public void onClick(View v) {
        if (!((Button)v).getText().toString().equals(""))
        {
            return;
        }
        String buutonID = v.getResources().getResourceEntryName(v.getId());
        int gamestatepointer = Integer.parseInt(buutonID.substring(buutonID.length()-1));
        if (activePlayer)
        {
            ((Button)v).setText("X");
            ((Button)v).setTextColor(Color.parseColor("#000000"));
            ((Button)v).setTextSize(60);
            gameState[gamestatepointer]=0;
        }
        else
        {

            ((Button)v).setText("O");
            ((Button)v).setTextColor(Color.parseColor("#000000"));
            ((Button)v).setTextSize(60);
            gameState[gamestatepointer]=1;
        }
        roundCount++;
        if(chickWinner()){
            if (activePlayer)
            {
                playerOneScoreCount++;
                updatePlayer();
                Toast.makeText(this,"Player One Won!",Toast.LENGTH_SHORT).show();
            }
            else{
                playerTwoScoreCount++;
                updatePlayer();
                Toast.makeText(this,"Player Two Won!",Toast.LENGTH_SHORT).show();
            }
            playAgain();
        }else if(roundCount==9)
        {
            playAgain();
            Toast.makeText(this,"No Winner!",Toast.LENGTH_SHORT).show();
        }else {
            activePlayer=!activePlayer;
        }
        if(playerOneScoreCount>playerTwoScoreCount){
            playerState.setText(R.string.playerOneState);
        }else if(playerOneScoreCount<playerTwoScoreCount){
            playerState.setText(R.string.playerTwoState);
        }else{
            playerState.setText(R.string.draw);
        }
        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAgain();
                playerOneScoreCount=0;
                playerTwoScoreCount=0;
                playerState.setText("");
                updatePlayer();
            }
        });

    }

    public boolean chickWinner()
    {
        boolean winnerResult=false;
        for (int [] winingPositions :winningPosition)
        {
            if (gameState[winingPositions[0]] == gameState[winingPositions[1]] &&
                    gameState[winingPositions[1]] == gameState[winingPositions[2]] &&
                    gameState[winingPositions[0]] != 2) {
                winnerResult = true;
                break;
            }

        }
        return winnerResult;
    }

    @SuppressLint("SetTextI18n")
    public void updatePlayer()
    {
        playerOneScore.setText(Integer.toString(playerOneScoreCount));
        playerTwoScore.setText(Integer.toString(playerTwoScoreCount));
    }
    public void playAgain()
    {
        roundCount=0;
        activePlayer=true;
        for (int i=0;i<buttons.length;i++)
        {
            gameState[i]=2;
            buttons[i].setText("");
        }
    }

}