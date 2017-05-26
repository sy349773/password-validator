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
     * Checks the number of rules the password has passed
     * @param str
     * @return return the int with the number of rules the password has passed.
     */
    public int numberOfRulesPassed(String str){

        int num=0;

        if (NotPassword(str)){
            num++;
        }
        if (passwordLength(str)){
            num++;
        }
        if(containNumber(str)){
            num++;
        }
        if(containSpecialChar(str)){
            num++;
        }
        if(containUpperAndLower(str)){
            num++;
        }
        return num;
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

    /**
     * containSpecialChar checks if a string contains any of the following char:  !"#$%'()*+
     * @param str String
     * @return true if special character found false if not found
     */
    public boolean containSpecialChar(String str) {

        int count=0;

        while(count<str.length()){

            // we use ANSI numbers to check for special chars. 33 = ! and 43 = +, rest of chars are in middle.
            if(str.charAt(count)>=33&&str.charAt(count)<=43){
                return true;
            }

            count++;

        }

        return false;

    }


    /**
     *  checks if a string is composed of Upper and Lower case letters and return true if so
     * @param str String
     * @return
     */
    public boolean containUpperAndLower(String str) {

        int count=0;
        boolean containsUpper = false;
        boolean containsLower = false;
        boolean containsBoth = false;

        while(count<str.length()&&!containsBoth){

            // we use ANSI numbers to check for special chars.
            // checks for upper case

            if(str.charAt(count)>='A'&&str.charAt(count)<='Z'){
                containsUpper = true;
            }

            //Checks for lowerCase
            if(str.charAt(count)>='a'&&str.charAt(count)<='z'){
                containsLower = true;
            }

            containsBoth = (containsUpper&&containsLower);

            count++;

        }

        return containsBoth;

    }

    /**
     * Checks if the String contains numbers. Returns true if so
     * @param str
     * @return
     */
    public boolean containNumber(String str) {

        int count=0;

        while(count<str.length()){

            // we use ANSI numbers to check for special chars.
            if(str.charAt(count)>='0'&&str.charAt(count)<='9'){
                return true;
            }

            count++;

        }

        return false;

    }



}
