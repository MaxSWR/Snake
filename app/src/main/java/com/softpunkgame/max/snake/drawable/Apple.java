package com.softpunkgame.max.snake.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Apple {
    private int aX, aY;
    private Paint paintApple;

    public Apple(int x, int y) {
        aX = x;
        aY = y;

        paintApple = new Paint();
        paintApple.setColor(Color.RED);
    }

    public void draw(Canvas c, int padY, int bS) {
        c.drawRect(aX * bS, padY + aY * bS, aX * bS + bS, padY + aY * bS + bS, paintApple);
    }

    public int getaX() {
        return aX;
    }

    public int getaY() {
        return aY;
    }
}
