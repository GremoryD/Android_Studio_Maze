package com.application.fostijczuk.application;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private  MazeView view_;
    private GestureDetector gestdet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameManager gamemanager = new GameManager();
        view_=new MazeView(this , gamemanager);
        gestdet = new GestureDetector(this, gamemanager );

        setContentView(view_);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return gestdet.onTouchEvent(event);
    }
}
