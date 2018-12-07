package com.example.administrator.myapplication4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.jump);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent jump = new Intent(MainActivity.this,jumptotargetActivity.class);

                Bundle data =new Bundle();

                ArrayList<String> k = new ArrayList<String>();

                k.add("a");
                k.add("b");

                data.putString("dataString","kof");
                data.putStringArrayList("dataListArray",k);

                jump.putExtras(data);


                startActivityForResult(jump,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {

            case 1:

                String a = data.getStringExtra("wori");
                System.out.println(a);
                    return;

            default:
                break;
        }
    }
}
