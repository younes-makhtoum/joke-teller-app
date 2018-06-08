package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void AsyncTaskCheck() {
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.Listener() {
            @Override
            public void onJokeRetrieved(String joke) {
            }
        });
        try {
            asyncTask.execute();
            String retrievedJoke = asyncTask.get();
            assertNotNull(retrievedJoke);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jokeDisplayCheck() {
        onView(withId(R.id.button_show_joke)).perform(click());
        onView(withId(R.id.joke_content_display)).check(matches(isDisplayed()));
    }
}