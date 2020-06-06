package com.example.rockpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
int tapped = 4;
ImageView UserInput,ComputerInput;


    // stores the tapped option
    // 1 Rock
    // 2 Paper
    // 3 Scissor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Rock(View view) {
        tapped = 1;
    }
    public void Paper(View view){
        tapped = 2;
    }
    public void Scissor(View view){
        tapped = 3;
    }
}