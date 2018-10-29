package com.example.isabella.paapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CalibrateScreen extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    BluetoothAdapter mBluetoothAdapter;

    // Create a BroadcastReceiver for ACTION_FOUND.
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(mBluetoothAdapter.ACTION_STATE_CHANGED)){
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, mBluetoothAdapter.ERROR);
                switch (state){
                    case BluetoothAdapter.STATE_OFF:
                        Log.d(TAG, "broadcast receiver: state off");
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        Log.d(TAG, "broadcast receiver: state turning off");
                        break;
                    case BluetoothAdapter.STATE_ON:
                        Log.d(TAG, "broadcast receiver: state on");
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        Log.d(TAG, "broadcast receiver: state turning on ");
                        break;
                }
            }
        }
    };

    @Override
    protected void onDestroy(){
        Log.d(TAG, "onDestroy called");
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
    //    Here is the code for the button to turn on or off bluetooth
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calibrate_screen);

//      Here is the button to turn on or off Bluetooth
        Button BTbtn= findViewById(R.id.BTbtn);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        BTbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onclick: enabling/disable bluetooth");
                enableDisableBT();
            }
        });


    }

    public void enableDisableBT(){
        if (mBluetoothAdapter == null) {
            Log.d(TAG, "does not have Bluetooth capabilities");
        }
        if (!mBluetoothAdapter.isEnabled()){
            Log.d(TAG, "enableDisableBT:enabling BT");
            Intent enableBTIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBTIntent);

            IntentFilter BTIntent= new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mReceiver, BTIntent);
        }
        if (mBluetoothAdapter.isEnabled()){
            Log.d(TAG, "enableDisableBT:disabling BT");
            mBluetoothAdapter.disable();
            IntentFilter BTIntent= new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mReceiver, BTIntent);
        }
    }
}
