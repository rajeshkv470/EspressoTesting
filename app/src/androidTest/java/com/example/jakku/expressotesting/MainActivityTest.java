package com.example.jakku.expressotesting;

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by jakku on 4/16/2018.
 */
public class MainActivityTest {
    // Here we need to launch MainActivity as like below one because you need to test it MainActivity
    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<MainActivity>(MainActivity.class);
    // this is string we are testing. I mean when you entered this after click on button
    // that will display in textview. This process will done automatically.
    // private we need taken other wise we will get error.
    private String name = "Jakkula Rajesh";

    //preloading thing you need to write
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUserInputScenario(){
        //input for edittext
        Espresso.onView(withId(R.id.et_view)).perform(typeText(name));
        // close soft keyboard
        Espresso.closeSoftKeyboard();
        //button click
        Espresso.onView(withId(R.id.button)).perform(click());
        //checking text view with text of edit text you entered
        Espresso.onView(withId(R.id.text_view)).check(matches(withText(name)));
    }
    //onces the text is execute clear the text
    @After
    public void tearDown() throws Exception {
    }

}