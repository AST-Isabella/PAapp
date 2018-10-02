package com.example.isabella.paapp;

import android.support.v7.app.AppCompatActivity;

public class SettingsScreen extends AppCompatActivity {

//The following code is supposed to create a button which turns bluetooth on/off:
}
   /* BluetoothAdapter mBluetoothAdapter;
    // Create a BroadcastReceiver for ACTION_FOUND.
    private final BroadcastReceiver mBroadcastReceiver1 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(mBluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, mBluetoothAdapter.ERROR);
                switch (state) {
                    case BluetoothAdapter.STATE_OFF:
                        //Log.d(TAG, "onReceive: STATE OFF");
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                       // Log.d(TAG, "onReceive: STATE Turning Off");
                        break;
                    case BluetoothAdapter.STATE_ON:
                       // Log.d(TAG, "onReceive: State ON");
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                       // Log.d(TAG, "mBroadcastReceiver1: State Turning ON");
                        break;

                }
            }
        }
    };

    @Override
    protected void onDestroy() {
       // Log.d(TAG, "onDestroy: called.");
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

        Button onOffBtn = findViewById(R.id.onOffBtn);
        onOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            final public void onClick(View v) {
               // Log.d(TAG, "onClick: enabling/disabling BT");
                enableDisableBT();
            }
        });
    }

    public void enableDisableBT() {
        if (mBluetoothAdapter == null) {
           // Log.d(TAG, "enableDisableBT: Does not have BT capabilities");
        }
        if (!mBluetoothAdapter.isEnabled()) {
           // Log.d(TAG, "enableDisableBT: enabling bluetooth");
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBTIntent);
            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReceiver1, BTIntent);
        }
        if (mBluetoothAdapter.isEnabled()) {
           // Log.d(TAG, "enableDisableBT: disabling bluetooth");
            mBluetoothAdapter.disable();
            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReceiver1, BTIntent);
        }
    }
}*/