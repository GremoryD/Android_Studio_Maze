package com.application.fostijczuk.application;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;


public class Playre implements Drawable {

    public Point point;
    public int size;
    private Paint paint;

    public  Playre(Point start , int size){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        point = start;
        this.size = size;
    }

    public int getX(){
        return point.x;
    }

    public int getY(){
        return point.y;
    }



    public  void Move(int x,int y){
        point.x += x;
        point.y += x;

    }

    @Override
    public void draw(Canvas canvas, Rect rect) {
        float sizeP =  (float)(rect.right-rect.left)/this.size;
        canvas.drawRect( rect.left+point.x*sizeP , rect.top+point.y*sizeP ,rect.left+ +point.x*sizeP+sizeP, rect.top+ point.y*sizeP+sizeP ,paint);
    }
}
