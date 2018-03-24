package com.example.chen.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "ActivityLifeCycleTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button startNormalActivityButton = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivityButton = (Button) findViewById(R.id.start_dialog_activity);

        startNormalActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        startDialogActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    } 

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    } 

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    } 

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    } 

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    } 

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    } 
}
