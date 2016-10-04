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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper accountsDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText loginEmail = (EditText) findViewById(R.id.emailAdress_text);
        final EditText loginPassword = (EditText) findViewById(R.id.password_text);
        final Button button = (Button) findViewById(R.id.loginBtn);
        final TextView showBtn = (TextView) findViewById(R.id.showBtn);
        final TextView register = (TextView) findViewById(R.id.registerBtn);
        accountsDb = new DatabaseHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginE = loginEmail.getText().toString().trim();
                String loginPass = loginPassword.getText().toString().trim();

                String verifyUser = accountsDb.getSingleEntryUname(loginE);
                String verifyEmail = accountsDb.getSingleEntryEmail(loginE);

                //If user entered his/her email address.
                if(validate(loginE)){
                    if (loginPass.equals(verifyEmail)) {
                        Intent myIntent = new Intent(MainActivity.this, blank.class);
                        startActivity(myIntent);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this,"Invalid Username/Email and Password", Toast.LENGTH_LONG).show();
                        loginEmail.requestFocus();
                    }
                }
                //If user entered his/her username.
                else if(loginPass.equals(verifyUser)) {
                    Intent myIntent = new Intent(MainActivity.this, blank.class);
                    startActivity(myIntent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this,"Invalid Username/Email and Password", Toast.LENGTH_LONG).show();
                    loginEmail.requestFocus();
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
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"Input Validation Success", Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(v.getContext(), Register.class);
                startActivityForResult(myIntent, 0);
                onPause();
            }
        });
    }

        private boolean validate(String email){

            String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(email);

            return matcher.matches();
        }
}

