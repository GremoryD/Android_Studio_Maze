package com.application.fostijczuk.application;


import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameManager extends GestureDetector.SimpleOnGestureListener {

    private List<Drawable> drawebles;
    private View view;
    private  Playre player;
    private Maze maze;

    private Rect rect = new Rect();
    private int size ;
    public GameManager(){
        player = new Playre();
        drawebles = new ArrayList<>();
        maze = new Maze(35);
        drawebles.add(player);
        drawebles.add(maze);
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
            drawableItems.draw(canvas,rect);
        }
    }

    public void setView(View view) {
        this.view = view;
    }
    public void  setScreenSize(int width,int height){
            size = Math.min(width,height);
            rect.set((width-size)/2,(height-size)/2,(width+size)/2,(height+size)/2);
    }


}
