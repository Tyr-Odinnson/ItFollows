package com.example.itfollows;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GameScene extends View {
    private Bitmap monster;
    private Paint mPaint;
    private Point touchPoint;
    public GameScene(Context context) {
        super (context);
    }

    public GameScene(Context context, AttributeSet attrs) {
        super (context, attrs);
    }

    @Override
    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
        if (mPaint == null) {
            mPaint = new Paint();
            monster = BitmapFactory.decodeResource(getContext().getResources(),
            R.drawable.ic_monster);
            touchPoint = new Point();
        }
        canvas.drawBitmap(monster, touchPoint.x - monster.getWidth()/2, touchPoint.y - monster.getHeight()/2,  mPaint);
    }
    public boolean onTouchEvent(MotionEvent event) {
        touchPoint.set((int)event.getX(), (int)event.getY());
        invalidate();
        return true;
    }

}
