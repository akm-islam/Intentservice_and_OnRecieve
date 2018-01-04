package com.example.mamunjahir.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

public class MyIntentService extends IntentService
{
    private static final String TAG ="MyIntentService" ;
    int cstart=0;

    public MyIntentService() {
        super("Service Demo");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ResultReceiver rr=intent.getParcelableExtra("receiver");
        Bundle b=new Bundle();
        b.putString("result","Counter starts");
        rr.send(ServiceDemo.RESULT_CODE,b);

        while(cstart<10)
        {
            Log.v(TAG,"counter now is "+cstart);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b.putString("result","Counter now is "+cstart);
            rr.send(ServiceDemo.RESULT_CODE,b);

            cstart++;
        }

        b.putString("result","Counter is finished ");
        rr.send(ServiceDemo.RESULT_CODE,b);


    }
}
