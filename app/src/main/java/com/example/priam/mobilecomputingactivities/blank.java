package com.example.priam.mobilecomputingactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class blank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        final Button button = (Button) findViewById(R.id.swipedBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v){
                Intent intent = new Intent(blank.this, OnTouchActivity.class);
                startActivity(intent);
            }
        });
    }
}
