package com.softpunkgame.max.snake;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.softpunkgame.max.snake.drawview.DrawView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ConstraintLayout main = findViewById(R.id.main);
        Display display = getWindowManager().getDefaultDisplay();
        DrawView d = new DrawView(this, display);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(display.getWidth(), display.getHeight());
        d.setLayoutParams(params);
        main.addView(d);
    }
}
