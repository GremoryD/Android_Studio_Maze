package com.application.fostijczuk.application;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class Maze implements Drawable {
    private Paint paint;

    public  Maze(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.DKGRAY);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(0,0,50,50,paint);
    }
}
