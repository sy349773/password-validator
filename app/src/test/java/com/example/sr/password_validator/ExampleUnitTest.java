package com.example.sr.password_validator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private MainActivity main = new MainActivity();

    @Test
    public void numberOfRulesPassed(){
        String str = "aAA#1ASDAS"; // 5 rules passed
        String str2 = "aAA1ASDAS"; // 4 rules passed
        String str3 = "aAAASDAS"; // 3 rules passed
        String str4 = "aAA#"; // 3 rules passed
        String str5 = "aAAA";// 2 rule passed
        String str6 = "a"; //1 rules passed

        assertTrue(main.numberOfRulesPassed(str)==5&&main.numberOfRulesPassed(str2)==4&&main.numberOfRulesPassed(str3)==3&&
                main.numberOfRulesPassed(str4)==3&&main.numberOfRulesPassed(str5)==2&&main.numberOfRulesPassed(str6)==1);
    }

    /**
     * Test to check whether a string is "password". Two different strings were provided
     */

    @Test
    public void isNotPassword() throws Exception {

        String str = "password"; // should return false
        String str2 = "Password"; // should return true
        assertTrue(!main.NotPassword(str)&&main.NotPassword(str2));

    }
    /**
     * Test to check whether a string is long enough. 3 different strings were provided
     */
    @Test
    public void passwordLength() throws Exception {

        String str = "12345678"; // returns true
        String str2 = "123456789"; // returns true
        String str3 = "123456"; // returns false

        assertTrue(main.passwordLength(str)&&main.passwordLength(str2)&&!main.passwordLength(str3));

    }

    /**
     * Test to check containsSpecialChar
     * @throws Exception
     */
    @Test
    public void containSpecialChar() throws Exception {
        String str = "asdfghjkl"; // false
        String str2 ="asdfghj!"; // true
        String str3 ="#"; // true
        assertTrue(!main.containSpecialChar(str)&&main.containSpecialChar(str2)&&main.containSpecialChar(str3));
    }

    /**
     * Checks if containUpperAndLower method works
     * @throws Exception
     */
    @Test
    public void containUpperAndLower() throws Exception {
        String str= "aqwer"; // false
        String str2="ABCD"; // false
        String str3="asvBCD"; // true

        assertTrue(!main.containUpperAndLower(str)&&!main.containUpperAndLower(str2)&&main.containUpperAndLower(str3));
    }

    /**
     * checks if containsNumber method works
     * @throws Exception
     */
    @Test
    public void containsNumber() throws Exception{
        String str = "asds#AA$%"; // false
        String str2 ="aasa0asa"; // true
        String str3 ="3"; // true
        assertTrue(!main.containNumber(str)&&main.containNumber(str3));
    }

}