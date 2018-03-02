package com.application.fostijczuk.application;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Dot implements Drawable{
    private int size;
    protected Point point;
    protected Paint paint;

    public Dot(Point point,Paint paint ,int size){
        this.point=point;
        this.paint=paint;
        this.size=size;
    }
    public Point getPoint(){
        return point;
    }


    @Override
    public void draw(Canvas canvas, Rect rect) {
        float sizeP =  (float)(rect.right-rect.left)/this.size;
        canvas.drawRect( rect.left+point.x*sizeP , rect.top+point.y*sizeP ,rect.left+ +point.x*sizeP+sizeP, rect.top+ point.y*sizeP+sizeP ,paint);

    }
}
