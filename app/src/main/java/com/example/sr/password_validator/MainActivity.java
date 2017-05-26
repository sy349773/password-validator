package com.example.sr.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * NotPassword : checks whether a string is = "password:
     * parameters: String str
     * returns true if string is not "password"
     */
    public boolean NotPassword(String str){
        return !str.equals("password");
    }

    /**
     * passwordLength : checks whether a string is longer or equal to 8 characters
     * parameters: String str
     * returns true if string is longer or equal to 8 characters.
     */

    protected boolean passwordLength(String str){  int lenght = 8; return str.length()>=lenght; }

}
