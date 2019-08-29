package com.oppo.testtelephony;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneStateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.d("testtelephony", "PhoneStateReceiver.onReceive");
        if (intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
            String extraState = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            int state = TelephonyManager.CALL_STATE_IDLE;
            if (extraState.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                state = TelephonyManager.CALL_STATE_IDLE;
            } else if (extraState.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                state = TelephonyManager.CALL_STATE_OFFHOOK;
            } else if (extraState.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                state = TelephonyManager.CALL_STATE_RINGING;
            }
            Log.d("testtelephony", "receive broadcast phone state = " + extraState);
        }
    }
}
