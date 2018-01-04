package com.example.mamunjahir.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.EditText;

public class ServiceDemo extends Activity
{
    public static final int RESULT_CODE = 11;
    EditText t;
    Handler h=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapservices);
        t= (EditText) findViewById(R.id.editText5);

    }
    public void startMyService(View v)
    {
        Intent ii=new Intent(this,MyIntentService.class);
        ResultReceiver r=new myreceiver(null);
        ii.putExtra("counter",2);
        ii.putExtra("receiver",r);
        startService(ii);
    }



    public class myreceiver extends  ResultReceiver
    {
        public myreceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            
            if(resultCode==RESULT_CODE)
            {
                if(resultData!=null)
                {
                    final String msg=resultData.getString("result");
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                       t.setText(msg);
                        }
                    });
                }
            }
            
        }
    }

    }
