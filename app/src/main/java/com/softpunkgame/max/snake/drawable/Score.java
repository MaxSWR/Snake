package com.softpunkgame.max.snake.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.softpunkgame.max.snake.settings.Settings;

public class Score {
    private int score;
    private Paint paintScore;

    public Score() {
        score = 0;
        paintScore = new Paint();
        paintScore.setColor(Color.WHITE);
        paintScore.setTextSize(Settings.TOP_TITLE_SIZE);
    }

    public void draw(Canvas c) {
        c.drawText("score: " + score, 0, Settings.TOP_TITLE_SIZE, paintScore);
    }

    public void grow() {
        score++;
    }
}
