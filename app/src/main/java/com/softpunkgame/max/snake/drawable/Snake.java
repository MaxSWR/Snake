package com.softpunkgame.max.snake.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.softpunkgame.max.snake.settings.Settings;

import java.util.ArrayList;

public class Snake {
    private int pX, pY, length, vX, vY; // person X and Y, body length, velocity X,Y
    private ArrayList<int[]> body;
    private Paint snakePaint;
    private Field field;

    public Snake(Field f, int x, int y) {
        field = f;
        pX = x;
        pY = y;
        vX = 0;
        vY = 1;
        length = Settings.SNAKE_START_LENGTH;
        body = new ArrayList<>();

        snakePaint = new Paint();
        snakePaint.setColor(Color.GREEN);
    }

    public void move() {
        pX += vX;
        pY += vY;
    }

    public void draw(Canvas c, int padY, int bS) {
        body.add(0, new int[]{pX, pY});
        int x, y;

        for (int i = 0; i < body.size(); i++) {
            x = body.get(i)[0] * bS;
            y = padY + body.get(i)[1] * bS;

            if (i != 0 && pX == body.get(i)[0] && pY == body.get(i)[1]) {
                field.gameOver();
            }

            c.drawRect(x, y, x + bS - 2, y + bS - 2, snakePaint);
        }

        while (body.size() > length) {
            body.remove(body.size() - 1);
        }

    }

    public void grow() {
        length++;
    }

    public int getpX() {
        return pX;
    }

    public void setpX(int pX) {
        this.pX = pX;
    }

    public int getpY() {
        return pY;
    }

    public void setpY(int pY) {
        this.pY = pY;
    }

    public void setvX(int vX) {
        this.vX = vX;
    }

    public void setvY(int vY) {
        this.vY = vY;
    }

    public int getvX() {
        return vX;
    }

    public int getvY() {
        return vY;
    }

    public void setDirection(Settings.DIRECTION d) {
        switch (d) {
            case DOWN:
                if (vY == -1)
                    break;

                vX = 0;
                vY = 1;
                break;

            case UP:
                if (vY == 1)
                    break;

                vX = 0;
                vY = -1;
                break;

            case LEFT:
                if (vX == 1)
                    break;

                vX = -1;
                vY = 0;
                break;

            case RIGHT:
                if (vX == -1)
                    break;

                vX = 1;
                vY = 0;
                break;
        }
    }
}
