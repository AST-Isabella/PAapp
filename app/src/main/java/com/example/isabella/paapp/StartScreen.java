package com.example.isabella.paapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

import static com.example.isabella.paapp.BluetoothLeService.EXTRA_DATA;
import static com.example.isabella.paapp.DeviceControlActivity.datalist;

public class StartScreen extends AppCompatActivity {
    Queue<Integer> newdata;
    List<Entry> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        LineChart chart = (LineChart) findViewById(R.id.chart);

        entries = new ArrayList<Entry>();
        newdata = datalist;

        for (int i = 0; i<newdata.size(); i++){
            if (newdata.peek()!=null) {
                entries.add(new Entry(i, newdata.poll()));
            }
        }

        LineDataSet dataSet = new LineDataSet(entries, "EDR");

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

}
