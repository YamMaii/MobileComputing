package com.example.priam.mobilecomputingactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class OnTouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_touch);

        final ImageView imgV = (ImageView) findViewById(R.id.swipedImg);
        final EditText x1 = (EditText) findViewById(R.id.x1Text);
        final EditText x2 = (EditText) findViewById(R.id.x2Text);
        final EditText differenceX = (EditText) findViewById(R.id.diffX);
        final EditText y1 = (EditText) findViewById(R.id.y1Text);
        final EditText y2 = (EditText) findViewById(R.id.y2Text);
        final EditText differenceY = (EditText) findViewById(R.id.diffY);
        final EditText swiped = (EditText) findViewById(R.id.swipedText);
        final EditText quadrant = (EditText) findViewById(R.id.quadrantText);

        imgV.setOnTouchListener(new View.OnTouchListener() {
            float initX = 0, initY = 0, finalX = 0, finalY = 0, diffX, diffY,imgHv, imgWv;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        initX = motionEvent.getX();
                        initY = motionEvent.getY();
                        x1.setText(""+initX);
                        y1.setText(""+initY);
                        return true;
                    case MotionEvent.ACTION_UP:
                        finalX = motionEvent.getX();
                        finalY = motionEvent.getY();
                        x2.setText(""+finalX);
                        y2.setText(""+finalY);
                        diffX = initX - finalX;
                        diffY = initY - finalY;
                        differenceX.setText(""+diffX);
                        differenceY.setText(""+diffY);

                        String setmsgX = "";

                        if(initX < finalX){
                            setmsgX = "SWIPED LEFT TO RIGHT ";
                        }else if(initX > finalX){
                            setmsgX = "SWIPED RIGHT TO LEFT ";
                        }

                        if(initY < finalY){
                            swiped.setText(setmsgX + "and " +"UP TO DOWN");
                        }else if(initY > finalY){
                            swiped.setText(setmsgX + "and " +"DOWN TO UP");
                        }
                        imgHv = imgV.getHeight()/2;
                        imgWv = imgV.getWidth()/2;

                        if (finalX>imgWv && finalY<imgHv){
                            quadrant.setText("Quadrant 1");
                        }else if (finalX<imgWv && finalY<imgHv){
                            quadrant.setText("Quadrant 2");
                        }else if (finalX<imgWv && finalY>imgHv){
                            quadrant.setText("Quadrant 3");
                        }else if (finalX>imgWv && finalY>imgHv){
                            quadrant.setText("Quadrant 4");
                        }
                        return true;
                }
                return false;
            }
        });


    }
}
