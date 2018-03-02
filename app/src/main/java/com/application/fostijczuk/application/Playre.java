package com.application.fostijczuk.application;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;


public class Playre extends Dot {

    public Point point;
    public int size;

    private static Paint getPaint(){

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        return  paint;
    }

    public  Playre(Point start , int size){
        super(start,getPaint(),size);
        point = start;
        this.size = size;
    }

    public int getX(){
        return point.x;
    }

    public int getY(){
        return point.y;
    }



    public  void goTo(int x,int y){
        point.x = x;
        point.y = y;

    }


}
