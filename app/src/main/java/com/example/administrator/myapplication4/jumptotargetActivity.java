package com.example.administrator.myapplication4;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class jumptotargetActivity extends Activity implements View.OnClickListener, ServiceConnection {


    private Button mStartservicebutton;
    private Button mStopservicebutton;
    private Intent serviceIntent;
    private Button mBindservice;
    private Button mUnBindservice;
    private myservice mMyservice;
    private Button mClosebtn;
    private Button mSendbroadcast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.testactivity);

        Bundle data = new Bundle();

        data = getIntent().getExtras();

        String test1 = data.getString("dataString");
        ArrayList<String> test2list = data.getStringArrayList("dataListArray");

        System.out.println(test1);
        System.out.println(test2list.get(0));
        System.out.println(test2list.get(1));


        mClosebtn = findViewById(R.id.close);
        mStopservicebutton = findViewById(R.id.stopservice);
        mStartservicebutton = findViewById(R.id.startservice);
        mBindservice = findViewById(R.id.bindservice);
        mUnBindservice = findViewById(R.id.unbindservice);
        mSendbroadcast = findViewById(R.id.sendBroadcast);


        mStartservicebutton.setOnClickListener(this);
        mStopservicebutton.setOnClickListener(this);
        mBindservice.setOnClickListener(this);
        mUnBindservice.setOnClickListener(this);
        mSendbroadcast.setOnClickListener(this);




        serviceIntent = new Intent(jumptotargetActivity.this, myservice.class);



        mClosebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent fanhui = new Intent();

                fanhui.putExtra("wori","返回了");

                setResult(0000,fanhui);


                finish();
                
            }
        });
    }

    
    

    @Override
    public void onClick(View v) {
        

        switch (v.getId()) {
            case R.id.startservice:

              startService(serviceIntent);
              break;

            case R.id.stopservice:
                stopService(serviceIntent);
                break;

            case R.id.bindservice:

                bindService(serviceIntent,this,Context.BIND_AUTO_CREATE);

                break;

            case R.id.unbindservice:
                unbindService(this);
                break;


            case R.id.sendBroadcast:

                Intent broadcastReceiver =  new Intent();

                sendBroadcast(broadcastReceiver);

                System.out.println("执行了send");

        }
        
    }



    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {


        mMyservice = ((myservice.MyBinder) service).getMyservice();

        System.out.println(mMyservice.gettest());

        System.out.println("OnserviceConnected");

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {


        System.out.println("DisconnectedService");

    }
}
