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

}