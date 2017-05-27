package com.example.sr.password_validator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variables from the ui

    TextView rule1;
    TextView rule2;
    TextView rule3;
    TextView rule4;
    TextView rule5;
    TextView validateMsg;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextViews

        rule1 = (TextView) findViewById(R.id.rule_1);
        rule2 = (TextView) findViewById(R.id.rule_2);
        rule3 = (TextView) findViewById(R.id.rule_3);
        rule4 = (TextView) findViewById(R.id.rule_4);
        rule5 = (TextView) findViewById(R.id.rule_5);
        validateMsg = (TextView) findViewById(R.id.validate_msg);

        //EditText

        password = (EditText) findViewById(R.id.enterPassword);

        //Updates UI as user enters data

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                      // NO NEED FOR THIS
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                       // NO NEED FOR THIS
            }

            @Override
            public void afterTextChanged(Editable s) {
                whileEnteringPassword();
            }
        });


    }

    /**
     * Method onClick for the botton from the user interface. Updates TextView if password is Strong
     * RED if not strong, Green otherwise.
     * @param v
     */
    public void onClick(View v){

        //uses the numberOfRulesPassed to verify the password stregth.
        int numRules=5;
        String str = password.getText().toString();

        if (numberOfRulesPassed(str)==numRules){

            validateMsg.setTextColor(Color.GREEN);
            validateMsg.setText("Strong Password!");

        }

        else {

            validateMsg.setTextColor(Color.RED);
            validateMsg.setText("Not Strong...");

        }

    }

    /**
     * method to change the TextView that show the requirements for the password.
     * if a rule is passed it changes the color of the textview to green, otherwise it remains red
     */
    public void whileEnteringPassword(){

        String str = password.getText().toString();

        if(NotPassword(str)){
            rule1.setTextColor(Color.GREEN);
        }
        else{
           rule1.setTextColor(Color.RED);
        }
        if(passwordLength(str)){
            rule2.setTextColor(Color.GREEN);
        }
        else{
            rule2.setTextColor(Color.RED);
        }
        if(containNumber(str)){
            rule3.setTextColor(Color.GREEN);
        }
        else{
            rule3.setTextColor(Color.RED);
        }
        if(containSpecialChar(str)){
           rule4.setTextColor(Color.GREEN);
        }
        else{
            rule4.setTextColor(Color.RED);
        }
        if(containUpperAndLower(str)){
           rule5.setTextColor(Color.GREEN);
        }
        else{
            rule5.setTextColor(Color.RED);
        }

    }

    //BELOW IS THE INTERNAL CODE FOR PASSWORD VALIDATION

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
