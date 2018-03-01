package com.application.fostijczuk.application;


import android.graphics.Canvas;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameManager extends GestureDetector.SimpleOnGestureListener {

    private List<Drawable> drawebles;
    private View view;
    private  Playre player;

    public GameManager(){
        player = new Playre();
        drawebles = new ArrayList<>();
        drawebles.add(player);
        drawebles.add(new Maze());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int diffX=0,diffY=0;
        diffX= Math.round( e2.getX()-e1.getX());
        diffY=Math.round( e2.getY()-e1.getY());
        player.Move(diffX,diffY);
        view.invalidate();
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    public void draw(Canvas canvas){
        for (Drawable drawableItems:drawebles  ) {
            drawableItems.draw(canvas);
        }
    }

    public void setView(View view) {
        this.view = view;
    }



}
