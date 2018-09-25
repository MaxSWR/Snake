package com.softpunkgame.max.snake.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Display;

import com.softpunkgame.max.snake.settings.Settings;

import java.util.Random;

public class Field {
    private int w, h, padX, padY, bS, bX, bY; /* field width and height, paddings for title and
    integer blocks, num of blocks at X and Y*/
    private Paint paddingPaint;
    private Snake snake;
    private Apple apple;
    private Random r;
    private Score score;

    public Field(Display d) {
        bS = Settings.BLOCK_SIZE;
        padX = d.getWidth() % bS;
        w = d.getWidth() - padX;
        bX = w / bS;
        padY = Settings.TOP_TITLE_SIZE + (d.getHeight() - Settings.TOP_TITLE_SIZE) % bS;
        h = d.getHeight() - padY;
        bY = h / bS;

        paddingPaint = new Paint();
        paddingPaint.setColor(Color.RED);

        snake = new Snake(this, bX / 2, bY / 2);
        r = new Random();
        apple = new Apple(r.nextInt(bX), r.nextInt(bY));
        score = new Score();
    }

    public void draw(Canvas c) {
        c.drawColor(Color.BLACK);
        c.drawRect(0, 0, w + padX, padY, paddingPaint);
        c.drawRect(w, 0, w + padX, padY + h, paddingPaint);

        snake.move();
        testApple();
        testEdges();
        snake.draw(c, padY, bS);
        apple.draw(c, padY, bS);
        score.draw(c);
    }

    public void click(int x, int y) {
        if ((snake.getvX() == 1 || snake.getvX() == -1) && y < snake.getpY() * bS + padY) {
            snake.setDirection(Settings.DIRECTION.UP);
        } else if ((snake.getvX() == 1 || snake.getvX() == -1) && y > snake.getpY() * bS + padY) {
            snake.setDirection(Settings.DIRECTION.DOWN);
        } else if ((snake.getvY() == 1 || snake.getvY() == -1) && x > snake.getpX() * bS) {
            snake.setDirection(Settings.DIRECTION.RIGHT);
        } else if ((snake.getvY() == 1 || snake.getvY() == -1) && x < snake.getpX() * bS) {
            snake.setDirection(Settings.DIRECTION.LEFT);
        }
    }

    public void gameOver() {
        snake = new Snake(this, bX / 2, bY / 2);
        apple = new Apple(r.nextInt(bX), r.nextInt(bY));
        score = new Score();
    }

    private void testApple() {
        if (snake.getpX() == apple.getaX() && snake.getpY() == apple.getaY()) {
            apple = new Apple(r.nextInt(bX), r.nextInt(bY));
            snake.grow();
            score.grow();
        }
    }

    private void testEdges() {
        if (snake.getpX() < 0) {
            //snake.setpX(bX - 1);
            gameOver();
        }

        if (snake.getpX() > bX - 1) {
            //snake.setpX(0);
            gameOver();
        }

        if (snake.getpY() < 0) {
            //snake.setpY(bY - 1);
            gameOver();
        }

        if (snake.getpY() > bY - 1) {
            //snake.setpY(0);
            gameOver();
        }
    }
}
