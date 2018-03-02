package com.application.fostijczuk.application;


import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameManager extends GestureDetector.SimpleOnGestureListener {

    private List<Drawable> drawebles= new ArrayList<>();
    private View view;
    private  Playre player;
    private Exit exit;
    private Maze maze;
    private int size ;

    private Rect rect = new Rect();

    public GameManager(){
        this.Create(15);
    }

    private void Create(int maze_size){
        drawebles.clear();
        maze = new Maze(maze_size);
        player= new Playre(maze.getStart(),maze_size);
        drawebles.add(maze);
        exit=new Exit(maze.getEnd(),maze_size);
        drawebles.add(exit);
        drawebles.add(player);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int diffX=0,diffY=0;
        diffX= Math.round( e2.getX()-e1.getX());
        diffY=Math.round( e2.getY()-e1.getY());
        if(Math.abs(diffX)>Math.abs(diffY)){
            diffX = diffX>0 ? 1:-1;
            diffY=0;
        }else {
            diffY = diffY>0 ? 1:-1;
            diffX=0;
        }
        int stepX=player.getX(),stepY=player.getY();
        while(maze.canPlayerGoTo(stepX+diffX,stepY+diffY)){
                stepX+=diffX;
                stepY+=diffY;
             if(diffX!=0){
                    if(maze.canPlayerGoTo(stepX,stepY+1) || maze.canPlayerGoTo(stepX,stepY-1)){
                        break;
                    }
                }
            if(diffY!=0){
                if(maze.canPlayerGoTo(stepX+1,stepY) || maze.canPlayerGoTo(stepX-1,stepY)){
                    break;
                }
            }

            player.goTo(stepX,stepY);


        }

        if(exit.getPoint().equals(player.getPoint())){
            this.Create(maze.GetSize()+1);
        }

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
