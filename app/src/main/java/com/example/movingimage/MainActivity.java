package com.example.movingimage;

import android.graphics.Point;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int screenWidth,screenHeight;
    ImageView imageView_red;
    ImageView imageView_green;
    ImageView imageView_blue;
    ImageView imageView_black;
    ImageView imageView_yellow;

    private float imageRedY;

    private float imageBlueY;

    private float imageYellowY;

    private float imageBlackY;

    private float imageGreenY;
    int i=1;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_red = findViewById(R.id.red_circle);
        imageView_black = findViewById(R.id.black_circle);
        imageView_blue = findViewById(R.id.blue_circle);
        imageView_green = findViewById(R.id.green_circle);
        imageView_yellow = findViewById(R.id.yellow_circle);
        constraintLayout = findViewById(R.id.stone_container);



        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        imageView_red.setY(new Random().nextInt(screenHeight-300)+150);
        imageView_green.setY(new Random().nextInt(screenHeight-300)+150);
        imageView_blue.setY(new Random().nextInt(screenHeight-300)+150);
        imageView_yellow.setY(new Random().nextInt(screenHeight-300)+150);
        imageView_black.setY(new Random().nextInt(screenHeight-300)+150);

        imageView_red.setX(new Random().nextInt(screenWidth));
        imageView_green.setX(new Random().nextInt(screenWidth));
        imageView_blue.setX(new Random().nextInt(screenWidth));
        imageView_yellow.setX(new Random().nextInt(screenWidth));
        imageView_black.setX(new Random().nextInt(screenWidth));


        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i*(-1);
            }
        });

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePosRed();
                        changePosGreen();
                        changePosBlue();
                        changePosYellow();
                        changePosBlack();
                    }
                });
            }
        },0,2);
    }

    private void changePosRed()
    {
        imageRedY = imageView_red.getY();
        if(i==1) {
            if(imageRedY < 1)
                imageRedY-=0;
            else
                imageRedY-=1;
        }
        else
            if(imageRedY > (screenHeight-280))
                imageRedY+=0;
            else
                imageRedY+=1;

        imageView_red.setY(imageRedY);
    }

    private void changePosGreen()
    {
        imageGreenY = imageView_green.getY();
        if(i==1) {
            if(imageGreenY < 1)
                imageGreenY-=0;
            else
                imageGreenY-=1;
        }
        else
        if(imageGreenY > (screenHeight-280))
            imageGreenY+=0;
        else
            imageGreenY+=1;

        imageView_green.setY(imageGreenY);
    }

    private void changePosYellow()
    {
        imageYellowY = imageView_yellow.getY();
        if(i==1) {
            if(imageYellowY < 1)
                imageYellowY-=0;
            else
                imageYellowY-=1;
        }
        else
        if(imageYellowY > (screenHeight-280))
            imageYellowY+=0;
        else
            imageYellowY+=1;

        imageView_yellow.setY(imageYellowY);
    }

    private void changePosBlue()
    {
        imageBlueY = imageView_blue.getY();
        if(i==1) {
            if(imageBlueY < 1)
                imageBlueY-=0;
            else
                imageBlueY-=1;
        }
        else
        if(imageBlueY > (screenHeight-280))
            imageBlueY+=0;
        else
            imageBlueY+=1;

        imageView_blue.setY(imageBlueY);
    }

    private void changePosBlack()
    {
        imageBlackY = imageView_black.getY();
        if(i==1) {
            if(imageBlackY < 1)
                imageBlackY-=0;
            else
                imageBlackY-=1;
        }
        else
        if(imageBlackY > (screenHeight-280))
            imageBlackY+=0;
        else
            imageBlackY+=1;

        imageView_black.setY(imageBlackY);
    }


}
