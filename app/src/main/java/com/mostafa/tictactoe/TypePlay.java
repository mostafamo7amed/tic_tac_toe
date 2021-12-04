package com.mostafa.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class TypePlay extends AppCompatActivity {
    Button single,multi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_play);
        single=(Button)findViewById(R.id.single);
        multi=(Button)findViewById(R.id.multi);
        Animation animation2= AnimationUtils.loadAnimation(this,R.animator.btu2_animation);
        Animation animation= AnimationUtils.loadAnimation(this,R.animator.btu_animation);
        multi.setAnimation(animation2);
        single.setAnimation(animation);

    }

    public void multiPlayer(View view) {
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}