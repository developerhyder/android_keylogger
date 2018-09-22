package com.example.root.hmm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    Button start;
    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.texxt);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methodfun();
            }
        });
        start = (Button)findViewById(R.id.button2);
        stop = (Button)findViewById(R.id.button3);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startit();

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopit();
            }
        });

    }

    private void methodfun() {
        Intent intent = new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivityForResult(intent, 0);
    }


    public void startit(){
        Intent i = new Intent(MainActivity.this,TestService.class);
        MainActivity.this.startService(i);

    }
    public void stopit(){
        Intent i = new Intent(MainActivity.this,TestService.class);
        MainActivity.this.stopService(i);
    }
}
