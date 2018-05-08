package com.example.llchen.messengertest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MessengerActivity extends AppCompatActivity {
    private Messenger mMessengerWithService;
    private boolean mIsBound;

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            mMessengerWithService = new Messenger(service);
            mIsBound = true;
        }

        public void onServiceDisconnected(ComponentName className) {
            mMessengerWithService = null;
            mIsBound = false;
        }
    };

    private void sayHello(View view) {
        if (!mIsBound) return;
        Message msg = Message.obtain(null, MessengerService.MSG_ID_HELLO, 0, 0);

        try {
            mMessengerWithService.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        Button button = (Button) findViewById(R.id.button_1);
        button.setOnClickListener((View view)->{
            sayHello(view);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, MessengerService.class), mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mIsBound) {
            unbindService(mConnection);
            mIsBound = false;
        }
    }

}
