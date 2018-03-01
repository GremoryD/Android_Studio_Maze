package com.application.fostijczuk.application;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;


public class MazeView extends View {
    private  GameManager gamemanager;

    public MazeView(Context context,GameManager gamemana) {
        super(context);
        this.gamemanager = gamemana;
        gamemanager.setView(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        gamemanager.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        gamemanager.setScreenSize(w,h);
    }
}
