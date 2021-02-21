package com.example.unitcoverter;

import android.content.Context;

import androidx.test.espresso.core.internal.deps.guava.base.Strings;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.unitcoverter", appContext.getPackageName());
    }

    @Test
    public void can_enter_fahrenheit() {
        onView(withId(R.id.spinner)).perform(click());
        onView(withText("Celcius")).perform(click());
        onView(withId(R.id.fahrenheit_input)).perform(clearText());
        onView(withId(R.id.fahrenheit_input)).perform(typeText("45"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.celcius_text)).check(matches(withText("7.22 ºC")));

    }

    @Test
    public void can_enter_pounds() {
        onView(withId(R.id.spinner)).perform(click());
        onView(withText("Kilogram")).perform(click());
        onView(withId(R.id.poundsInput)).perform(typeText("50"), closeSoftKeyboard());
        onView(withId(R.id.convertBtnKG)).perform(click());
        onView(withId(R.id.kgText)).check(matches(withText("22.68 kg")));

    }

    @Test
    public void can_enter_miles() {
        onView(withId(R.id.spinner)).perform(click());
        onView(withText("Kilometer")).perform(click());
        onView(withId(R.id.milesInput)).perform(typeText("50"), closeSoftKeyboard());
        onView(withId(R.id.convertBtnKM)).perform(click());
        onView(withId(R.id.kmText)).check(matches(withText("80.47 km")));


    }

    @Test
    public void can_enter_feet() {
        onView(withId(R.id.spinner)).perform(click());
        onView(withText("Meter")).perform(click());
        onView(withId(R.id.feetInput)).perform(typeText("50"), closeSoftKeyboard());
        onView(withId(R.id.convertBtnFt)).perform(click());
        onView(withId(R.id.meterText)).check(matches(withText("15.24 meter")));

    }
}