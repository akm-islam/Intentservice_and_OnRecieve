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
        b.putString("result2","I am result2");
        rr.send(ServiceDemo.RESULT_CODE,b);
    }
}
