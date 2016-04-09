package com.project.befit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
 
public class TimerActivity extends Activity {
 
    private Button startButton;
    private Button pauseButton;

    TextView timerValue;
    CharSequence timevalue;
    private long startTime = 0L;
    private Handler customHandler = new Handler();
 
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    int mins;
    int secs;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.timer);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        timerValue = (TextView) findViewById(R.id.timerValue);
 
        startButton = (Button) findViewById(R.id.startButton);
 
        startButton.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread, 0);
 
            }
        });
 
        pauseButton = (Button) findViewById(R.id.pauseButton);
 
        pauseButton.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View view) {
 
                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);
 
            }
        });
 
    }
 
    private Runnable updateTimerThread = new Runnable() {
 
        public void run() {
 
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
 
            updatedTime = timeSwapBuff + timeInMilliseconds;
 
             secs = (int) (updatedTime / 1000);
             mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);
        }
 
    };
    
    public void updateTime(View view){
    	Toast.makeText(getBaseContext(), timerValue.getText().toString(), Toast.LENGTH_SHORT).show();
    Intent myIntent = new Intent();
    String intmins =Integer.toString(mins);
    myIntent.setData(Uri.parse(intmins));
    setResult(RESULT_OK,myIntent);
    finish();
    }
}

