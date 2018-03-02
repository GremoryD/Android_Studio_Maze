package com.application.fostijczuk.application;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;


public class Maze implements Drawable {
    private Paint wallPaint;
    private final boolean[][] array;
    private final int size;
    private  final Point end = new Point(1,1);
    private Point start = new Point();
    private  int beatScore = 0;

    public  Maze(int size){
        wallPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        wallPaint.setColor(Color.DKGRAY);
        this.size = size;
        array = new boolean[size][size];
        ganerateMaze();
    }

    public int GetSize(){
        return size;
    }

    private void ganerateMaze(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                array[i][j]= i%2!=0 && j%2!=0 && i<size-1 && j<size-1;
            }
        }
        Random randd = new Random();
        Stack<Point> stack = new Stack<>();
        stack.push(end);
        while (stack.size()>0){
            Point current = stack.peek();
            List<Point>  unusedNeigbords = new LinkedList<>();

            if(current.x > 2){
                if(!isUsedCell(current.x-2,current.y)){
                    unusedNeigbords.add(new Point(current.x-2,current.y));
                }
            }

            if(current.y > 2){
                if(!isUsedCell(current.x,current.y-2)){
                    unusedNeigbords.add(new Point(current.x,current.y-2));
                }
            }

            if(current.x < size-2){
                if(!isUsedCell(current.x-2,current.y)){
                    unusedNeigbords.add(new Point(current.x+2,current.y));
                }
            }

            if(current.y < size-2){
                if(!isUsedCell(current.x,current.y+2)){
                    unusedNeigbords.add(new Point(current.x,current.y+2));
                }
            }
            if(unusedNeigbords.size()>0){
                int rnd = randd.nextInt(unusedNeigbords.size());
                Point direction = unusedNeigbords.get(rnd);
                int diffX = (direction.x-current.x)/2;
                int diffY = (direction.y-current.y)/2;
                array[current.y+diffY][current.x+diffX]= true;
                stack.push(direction);
            }else {
                if(stack.size()  > beatScore){
                    beatScore = stack.size();
                    start=current;
                }
                stack.pop();
            }
        }
    }

    public boolean canPlayerGoTo(int x,int y){
        return array[y][x];
    }

    public  boolean isCrossroads(int x,int y){
        return isUsedCell(x,y);
    }

    private  boolean isUsedCell(int x,int y ){
        if(x<0 || y<0 || x>=size-1 || y>=size-1){
            return true;
        }
        return array[y-1][x] || array[y][x-1] || array[y+1][x] || array[y][x+1];
    }

    @Override
    public void draw(Canvas canvas, Rect rect) {
        float cellsize = (float)(rect.right-rect.left)/size;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                 if(!array[i][j]){
                     float left = j*cellsize+rect.left;
                     float top = i*cellsize+rect.top;
                     canvas.drawRect(left,top,left+cellsize,top+cellsize, wallPaint);
                 }
            }
        }
    }

    public Point getStart() {
        return start;
    }


    public Point getEnd() {
        return end;
    }
}
