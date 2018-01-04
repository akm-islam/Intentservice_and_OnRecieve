package com.example.mamunjahir.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService2 extends Service {
    public MyService2() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"I am created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int count=intent.getIntExtra("counter",0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"I am "+count,Toast.LENGTH_SHORT).show();
        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
      return null;
    }
}
