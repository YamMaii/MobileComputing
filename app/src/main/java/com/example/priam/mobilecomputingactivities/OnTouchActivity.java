package com.example.priam.mobilecomputingactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class OnTouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_touch);

        final ImageView imgV = (ImageView) findViewById(R.id.swipedImg);

        imgV.setOnTouchListener(new View.OnTouchListener() {
            float initX = 0, initY = 0, finalX = 0, finalY = 0;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        initX = motionEvent.getX();
                        initY = motionEvent.getY();
                        Toast.makeText(getApplicationContext(), ""+String.format("Value of X:"+initX+"Value of Y:"+initY), Toast.LENGTH_SHORT).show();
                        return true;
                    case MotionEvent.ACTION_UP:
                        finalX = motionEvent.getX();
                        finalY = motionEvent.getY();
                        displayAction(initX, finalX, initY, finalY);
                        return true;
                }
                return false;
            }
        });


    }

    public void displayAction(float initX, float finalX, float initY, float finalY){
        String msg = "";

        if(initX < finalX){
            Toast.makeText(getApplicationContext(), "SWIPED LEFT TO RIGHT", Toast.LENGTH_SHORT).show();
        }else if(initX > finalX){
            Toast.makeText(getApplicationContext(), "SWIPED RIGHT TO LEFT", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(getApplicationContext(), ""+msg, Toast.LENGTH_SHORT).show();

        if(initY < finalY){
            Toast.makeText(getApplicationContext(), "SWIPED UP TO DOWN", Toast.LENGTH_SHORT).show();
        }else if(initY > finalY){
            Toast.makeText(getApplicationContext(), "SWIPED DOWN TO UP", Toast.LENGTH_SHORT).show();
        }
    }
}
