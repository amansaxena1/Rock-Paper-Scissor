package com.example.rockpaper;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
int tapped = 3;
int system = 3;
int UserScore = 0;
int SystemScore = 0;
boolean check = true;
ImageView UserInput, ComputerInput;
TextView GameState;
TextView SScore,UScore;
Button Reset;

    // stores the tapped option
    // 0 Rock
    // 1 Paper
    // 2 Scissor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserInput = (ImageView) findViewById(R.id.UserInput);
        ComputerInput = (ImageView) findViewById(R.id.ComputerInput);
        GameState = (TextView) findViewById(R.id.GameState);
        SScore = (TextView) findViewById(R.id.SScore);
        UScore = (TextView) findViewById(R.id.UScore);
        Reset = findViewById(R.id.Reset);
    }
    Random rand = new Random();
    public void Rock(View view) {
        tapped = 0;
        system = rand.nextInt(3);
        UserInput.setImageResource(R.drawable.rock);
        if(system == 0) {
            ComputerInput.setImageResource(R.drawable.rock);
        }
        if(system == 1) {
            ComputerInput.setImageResource(R.drawable.paper);
        }
        if(system == 2) {
            ComputerInput.setImageResource(R.drawable.scissor);
        }
        winner(tapped,system);
    }
    public void Paper(View view){
        tapped = 1;
        system = rand.nextInt(3);
        UserInput.setImageResource(R.drawable.paper);
        if(system == 0) {
            ComputerInput.setImageResource(R.drawable.rock);
        }
        if(system == 1) {
            ComputerInput.setImageResource(R.drawable.paper);
        }
        if(system == 2) {
            ComputerInput.setImageResource(R.drawable.scissor);
        }
        winner(tapped,system);
    }
    public void Scissor(View view){
        tapped = 2;
        system = rand.nextInt(3);
        UserInput.setImageResource(R.drawable.scissor);
        if(system == 0) {
            ComputerInput.setImageResource(R.drawable.rock);
        }
        if(system == 1) {
            ComputerInput.setImageResource(R.drawable.paper);
        }
        if(system == 2) {
            ComputerInput.setImageResource(R.drawable.scissor);
        }
        winner(tapped,system);
    }
    public void winner(int tapped, int system){
        if( (tapped == 0 && system == 2) || (tapped == 1 && system == 0) || (tapped == 2 && system ==1)){
            UserwWon();
        }
        else if((tapped == 0 && system == 0) || (tapped == 1 && system == 1) || (tapped == 2 && system == 2)){
            Tie();
        }
        else{
            SystenWon();
        }
    }
    public void UserwWon(){
        UserScore = UserScore + 1;
        GameState.setText("Yeeeeeeeee");
        UScore.setText("" + UserScore);
        Victory();
    }
    public void Tie(){
        GameState.setText("TIE");
    }
    public void SystenWon(){
        SystemScore = SystemScore + 1;
        GameState.setText("Oopssssss");
        SScore.setText("" + SystemScore);
        Victory();
    }
    public void Victory(){
        if(UserScore == 5){
            GameState.setText("YOU WON");
            Reset.setAlpha(1f);
        }
        if(SystemScore == 5){
            GameState.setText("COMPUTER WINS");
            Reset.setAlpha(1f);
        }
    }
    public void Restart(View View){
        GameState.setText("Choose One");
        Reset.setAlpha(0f);
        SScore.setText("0");
        UScore.setText("0");
        ComputerInput.setImageResource(R.drawable.question);
        UserInput.setImageResource(R.drawable.question);

        SystemScore = 0;
        UserScore = 0;
    }
}