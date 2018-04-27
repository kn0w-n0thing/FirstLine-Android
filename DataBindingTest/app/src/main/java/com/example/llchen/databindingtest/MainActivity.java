package com.example.llchen.databindingtest;

import android.support.v7.app.AppCompatActivity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import com.example.llchen.databindingtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = "DataBindingTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("Test", "User");
        binding.setUser(user);
        Handler handler = new Handler();
        binding.setHandler(handler);
        Log.d(MainActivity.TAG, "onCreate");
    }
}
