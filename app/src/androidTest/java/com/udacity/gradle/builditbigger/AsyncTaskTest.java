package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void AsyncTaskCheck() throws InterruptedException, ExecutionException {
        EndpointsAsyncTask endPointsAsyncTask = new EndpointsAsyncTask(new EndpointsAsyncTask.Listener() {
            @Override
            public void onJokeRetrieved(String joke) { }
        });
        endPointsAsyncTask.execute();
        String retrievedJoke = endPointsAsyncTask.get();
        assertNotNull(retrievedJoke);
    }
}