package com.example.dialogbox;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);//为Activity设置layout布局
        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) this.findViewById(R.id.button_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main1Activity.this);
                builder .setTitle("温馨提示")
                        .setMessage("点击登录按钮进行登陆")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Main1Activity.this, "用户已阅", Toast.LENGTH_SHORT).show();
                    }

                });
                builder.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Main1Activity.this);
                LayoutInflater inflater = getLayoutInflater();//找 res/layout 下的 xml 布局文件，并且实例化
                final View v = inflater.inflate(R.layout.activity_main2, null,false);
                //(想要添加的布局，要添加到哪个布局上，（true/false)是否直接添加到第二个参数布局上
                builder.setTitle("Login")
                        .setView(v)
                        .setPositiveButton("提交", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {


                                EditText et1 = (EditText) v.findViewById(R.id.edit_text1);
                                EditText et2 = (EditText) v.findViewById(R.id.edit_text2);

                                if ((et1.getText().toString()).equals("abc") && (et2.getText().toString()).equals("123"))
                                    Toast.makeText(Main1Activity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(Main1Activity.this, "用户名或密码错误，请重试", Toast.LENGTH_SHORT).show();

                            }

                        });
                builder.show();
            }
        });
    }
}
