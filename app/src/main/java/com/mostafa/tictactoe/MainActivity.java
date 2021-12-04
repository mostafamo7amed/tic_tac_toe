package com.mostafa.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;

public class MainActivity extends AppCompatActivity {
     KenBurnsView kbv;
     Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kbv =findViewById(R.id.kbv);
        context=this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent (context,TypePlay.class);
                startActivity(intent);
                finish();
                AccelerateDecelerateInterpolator adi=new AccelerateDecelerateInterpolator();
                RandomTransitionGenerator generator=new RandomTransitionGenerator(800,adi);
                kbv.setTransitionGenerator(generator);
            }
        },2000);
    }
}