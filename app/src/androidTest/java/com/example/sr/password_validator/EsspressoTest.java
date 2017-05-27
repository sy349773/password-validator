package com.example.sr.password_validator;
import android.graphics.drawable.Drawable;
import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by sr on 2017-05-26.
 */

@RunWith(AndroidJUnit4.class)

@LargeTest
public class EsspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<MainActivity>(MainActivity.class);

    /**
     * checks button
     */
    @Test
    public void testButton(){

        onView(withId(R.id.buttonValidate)).perform(click());

    }

    /**
     * test input entry
     */
    @Test
    public void inputEntry(){
        String str ="password";
        onView(withId(R.id.enterPassword)).perform(clearText(), typeText(str));
    }

    /**
     * Automated test for data entry and password validation. Decomment the other output/input
     * and comment the previous output/input to see the other outcome
     */
    @Test
    public void passwordValidation(){
        String output = "Strong Password!";
        //String output = "Not Strong...";
        String input ="passworD1!";
        //String input ="password";
        onView(withId(R.id.enterPassword)).perform(clearText(), typeText(input));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.buttonValidate)).perform(click());
        onView(withId(R.id.validate_msg)).check(matches(withText(output)));


    }


}
