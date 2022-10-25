package com.fptu.bookaholic.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.fptu.bookaholic.R;

public class TestScreenFilter extends AppCompatActivity {

    private SharedMemory sharedMemory;
    private ToggleButton toggleButton;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_screen_filter);

        SeekBar alpha, red, green, blue;
        alpha = findViewById(R.id.sb_alpha);
        red = findViewById(R.id.sb_red);
        green = findViewById(R.id.sb_green);
        blue = findViewById(R.id.sb_blue);

        sharedMemory = new SharedMemory(this);
        toggleButton = findViewById(R.id.btn_start);

        SeekBar.OnSeekBarChangeListener changeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sharedMemory.SetAlpha(alpha.getProgress());
                sharedMemory.SetRed(red.getProgress());
                sharedMemory.SetGreen(green.getProgress());
                sharedMemory.SetBlue(blue.getProgress());
                if(ScreenFilterService.STATE == ScreenFilterService.STATE_ACTIVE){
                    Intent i = new Intent(TestScreenFilter.this, ScreenFilterService.class);
                    startService(i);
                }

                toggleButton.setChecked(ScreenFilterService.STATE == ScreenFilterService.STATE_INACTIVATE);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        alpha.setOnSeekBarChangeListener(changeListener);
        red.setOnSeekBarChangeListener(changeListener);
        green.setOnSeekBarChangeListener(changeListener);
        blue.setOnSeekBarChangeListener(changeListener);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TestScreenFilter.this, ScreenFilterService.class);
                if(ScreenFilterService.STATE == ScreenFilterService.STATE_INACTIVATE){
                    stopService(i);
                }else{
                    startService(i);
                }
                Refresh();
            }
        });
    }

    private void Refresh() {
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
        countDownTimer = new CountDownTimer(100, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                toggleButton.setChecked(ScreenFilterService.STATE == ScreenFilterService.STATE_INACTIVATE);
            }
        };
        countDownTimer.start();
    }
}