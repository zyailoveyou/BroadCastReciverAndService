package com.example.administrator.myapplication4;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class myservice extends Service {


    public final MyBinder mMyBinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {

        System.out.println("OnbindService");

        return mMyBinder;

    }

      public class MyBinder extends Binder{

        public myservice getMyservice(){

            return myservice.this;

        };

     }



     public String gettest()

     {

         return "Return successfully service data";

     };



    @Override
    public void onCreate() {
        super.onCreate();


        System.out.println("successfully run service");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        System.out.println("successfully destory service");

    }


}
