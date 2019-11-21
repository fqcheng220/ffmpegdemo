package com.fqcheng220.ffmpegdemo;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
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
                stream(Environment.getExternalStorageDirectory().getPath()+"/test.mp4","rtmp://www.velab.com.cn/live/test");
            }
        });
        verifyStoragePermissions(this);
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
        //System.loadLibrary("swscale");
        //System.loadLibrary("postproc");
        //System.loadLibrary("avdevice");
        //System.loadLibrary("avcodec");
        //System.loadLibrary("avformat");
        //System.loadLibrary("avfilter");
        System.loadLibrary("ffstreamer");
    }


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
        "android.permission.READ_EXTERNAL_STORAGE",
        "android.permission.WRITE_EXTERNAL_STORAGE" };


    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
