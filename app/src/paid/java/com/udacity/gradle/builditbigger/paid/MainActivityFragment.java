package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.androidjokes.MainLibraryActivity;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    // Tag for log messages
    public static final String LOG_TAG = MainActivityFragment.class.getName();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        Button showJoke = root.findViewById(R.id.button_show_joke);

        showJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask(new EndpointsAsyncTask.Listener() {
                    @Override
                    public void onJokeRetrieved(String joke) {
                        Intent intent = new Intent(getContext(), MainLibraryActivity.class);
                        intent.putExtra(MainLibraryActivity.DISPLAY_JOKE, joke);
                        startActivity(intent);
                    }
                }).execute();
            }
        });

        return root;
    }
}
