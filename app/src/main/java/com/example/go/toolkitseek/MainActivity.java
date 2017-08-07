package com.example.go.toolkitseek;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private SeekBar seekbar, g, b;
    private TextView text, status;

    int red = 0;
    int green = 0;
     int blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     seekbar = (SeekBar) findViewById(R.id.seekBar);
        text = (TextView) findViewById(R.id.text);
        status = (TextView) findViewById(R.id.status);
        g = (SeekBar) findViewById(R.id.g);
        b = (SeekBar) findViewById(R.id.b);


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            status.setText("You want it red" + seekBar.getProgress() + "%!" + seekBar.getMax());

                red = seekBar.getProgress();

                status.setTextColor(Color.rgb((int) (seekBar.getProgress()*2.55),green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("TAG","touched");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                red = seekBar.getProgress();

                status.setTextColor(Color.rgb((int) (seekBar.getProgress()*2.55),green,blue));
            }
        });


        g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                status.setText("You want it green " + seekBar.getProgress() + "%!" + seekBar.getMax());

                green = seekBar.getProgress();

                status.setTextColor(Color.rgb(red,(int) (seekBar.getProgress()*2.55),blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("TAG","touched");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                status.setTextColor(Color.rgb(red,(int) (seekBar.getProgress()*2.55),blue));
                green = seekBar.getProgress();
                
            }
        });


        b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                status.setText("You want it blue " + seekBar.getProgress() + "%! / " + seekBar.getMax());

                blue = seekBar.getProgress();

                status.setTextColor(Color.rgb(red,green ,(int) (seekBar.getProgress()*2.55)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("TAG","touched");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("TAG","stop");
                blue = seekBar.getProgress();

                status.setTextColor(Color.rgb(red,green ,(int) (seekBar.getProgress()*2.55)));
            }
        });

    }
}
