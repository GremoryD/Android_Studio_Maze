package com.application.fostijczuk.application;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;


public class Playre implements Drawable {

    public Point point;

    private Paint paint;

    public  Playre(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        point = new Point(0,0);
    }
    public  void Move(int x,int y){
        point.x += x;
        point.y += x;

    }

    @Override
    public void draw(Canvas canvas, Rect rect) {
        canvas.drawRect( point.x , point.y ,point.x+50 , point.y+50,paint);
    }
}
