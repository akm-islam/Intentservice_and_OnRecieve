package com.example.mamunjahir.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by DELL on 05-04-2015.
 */

//local service -> startservice -> onstartcommand
    // remote service -> bindservice -> localbinder -> aidl
public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "service created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service destroyed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // return super.onStartCommand(intent, flags, startId);

        Toast.makeText(this, "on start command called " + startId, Toast.LENGTH_LONG).show();
        int count = intent.getIntExtra("counter",0);
        new counter().execute(count);
        return START_REDELIVER_INTENT;

    }


    class counter extends AsyncTask<Integer, String, String> {

        @Override
        protected String doInBackground(Integer... params) {
      int start=params[0];
            while(start<10)
            {
                publishProgress("counter now is "+start);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start++;
            }
            return "Done with this";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Toast.makeText(MyService.this,values[0],Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MyService.this,s,Toast.LENGTH_SHORT).show();
            stopSelf();

        }
    }
}