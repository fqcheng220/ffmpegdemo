package com.fqcheng220.ffmpegdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView textView = findViewById(R.id.test);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stream(""/*"/storage/sdcard0/test.mp4"*/,"");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public native int stream(String inputUrl,String outputUrl);

    static{
//        System.loadLibrary("avcodec");
//        System.loadLibrary("avdevice");
////        System.loadLibrary("avfilter");
////        System.loadLibrary("avformat");
////        System.loadLibrary("avutil");
////        System.loadLibrary("swresample");
////        System.loadLibrary("swscale");
////        System.loadLibrary("postproc");
//
//        System.loadLibrary("ffstreamer");


        //System.loadLibrary("avutil");
        //System.loadLibrary("swresample");
        //System.loadLibrary("avcodec");
        //System.loadLibrary("avformat");
        //System.loadLibrary("swscale");
        //System.loadLibrary("postproc");
        ////System.loadLibrary("avfilter");
        //System.loadLibrary("avdevice");
        System.loadLibrary("ffstreamer");
    }
}
