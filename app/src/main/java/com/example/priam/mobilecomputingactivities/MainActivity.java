package com.example.priam.mobilecomputingactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText emailValidate = (EditText) findViewById(R.id.emailAdress_text);
        final EditText passwordFormat = (EditText) findViewById(R.id.password_text);
        final Button button = (Button) findViewById(R.id.loginBtn);
        final TextView showBtn = (TextView) findViewById(R.id.showBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailValidate.getText().toString();
                final String password = passwordFormat.getText().toString();

                if (validate(email) && password.length() >= 8) {
                    Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, blank.class);
                    startActivity(intent);
                }
                if (!validate(email) || password.length() < 8) {
                    if (!validate(email)) {
                        Toast.makeText(getApplicationContext(), "Invalid E-mail Address!", Toast.LENGTH_SHORT).show();
                    }
                    if (password.length() < 8) {
                        Toast.makeText(getApplicationContext(), "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
                if (!validate(email) && password.length() < 8){
                    Toast.makeText(getApplicationContext(), "Invalid E-Mail or Password!", Toast.LENGTH_SHORT).show();
                }
            }

        });
        showBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                                switch ( event.getAction() ) {

                                                case MotionEvent.ACTION_DOWN:
                                                EditText pText=(EditText)findViewById(R.id.password_text);
                                                pText.setInputType(InputType.TYPE_CLASS_TEXT);
                                                break;
                                        case MotionEvent.ACTION_UP:
                                                EditText aText=(EditText)findViewById(R.id.password_text);
                                                aText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                                                break;
                                    }
                                return true;
                            }

                            });
    }

        private boolean validate(String email){

                           return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                                   + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                   + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                                   + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                   + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                                   + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
        }
}

