package com.example.handler2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                textView.setText(msg.what+"");
            }
        };
        final Runnable DJS = new Runnable() {
            @Override
            public void run() {
                int progress = 10;
                while(progress <= 10&&progress>=0){
                    Message msg = new Message();
                    msg.what= progress;
                    handler.sendMessage(msg);
                    progress -= 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Thread CUTDOWN = new Thread(null, DJS, "CUTDOWN");
                CUTDOWN.start();
            }
        });
    }
}
