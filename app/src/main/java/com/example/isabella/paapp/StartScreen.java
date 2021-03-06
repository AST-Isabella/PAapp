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
    Queue<Integer> gsraverage,respaverage;
    List<Entry> gsrentries, respentries;
    ExponentialMovingAverage gsrworker,respworker;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        LineChart gsrchart = (LineChart) findViewById(R.id.gsrchart);
        LineChart respchart = (LineChart) findViewById(R.id.respchart);

        gsrworker = new ExponentialMovingAverage(.5);
        respworker = new ExponentialMovingAverage(.2);
        gsrentries = new ArrayList<Entry>();
        respentries = new ArrayList<Entry>();
        newdata = datalist;
        gsraverage = new LinkedList<>();
        respaverage = new LinkedList<>();

        for (Integer b : newdata){
            if (b>1100) {
                respaverage.add((int) Math.round(respworker.average((double) b)));
            }
            else
                gsraverage.add((int) Math.round(gsrworker.average((double) b)));
        }

        for (int d : gsraverage){
            i++;
            gsrentries.add(new Entry(i, d));
        }
        i=0;
        for (int d : respaverage){
            i++;
            respentries.add(new Entry(i, d));
        }

        LineDataSet gsrDataSet = new LineDataSet(gsrentries, "EDR");
        LineDataSet respDataSet = new LineDataSet(respentries, "Resp");

        LineData gsrLineData = new LineData(gsrDataSet);
        gsrchart.setData(gsrLineData);
        gsrchart.invalidate();

        LineData respLineData = new LineData(respDataSet);
        respchart.setData(respLineData);
        respchart.invalidate();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    class ExponentialMovingAverage {
        private double alpha;
        private Double oldValue;
        public ExponentialMovingAverage(double alpha){
            this.alpha = alpha;
        }

        public double average (double value) {
            if (oldValue == null){
                oldValue = value;
                return value;
            }
            double newValue = oldValue + alpha*(value-oldValue);
            oldValue = newValue;
            return newValue;
        }
    }

}
