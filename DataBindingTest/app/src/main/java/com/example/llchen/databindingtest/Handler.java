package com.example.llchen.databindingtest;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by chen on 18-4-26.
 */

public class Handler {
    public void onHandling(User user) {
        Log.d(MainActivity.TAG, "onHandling");
        user.setFirstName("Hello");
        user.setLastName("World");
    }
}
