package com.example.file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText etFileName,etWriteText;
    TextView tvRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWriteText=(EditText) findViewById(R.id.etFileText);
        etFileName=(EditText) findViewById(R.id.etFileName);
        tvRead=(TextView) findViewById(R.id.textRead);

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myfilename=etFileName.getText().toString()+".txt";
                try{
                    FileOutputStream fileOutputStream=openFileOutput(myfilename,
                            Context.MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriter=new OutputStreamWriter
                            (fileOutputStream,"UTF-8");
                    outputStreamWriter.write(etWriteText.getText().toString());
                    outputStreamWriter.flush();
                    fileOutputStream.flush();
                    outputStreamWriter.close();
                    fileOutputStream.close();
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),"写入完成",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnRead).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myfilename=etFileName.getText().toString()+".txt";
                try{
                    FileInputStream fileInputStream=openFileInput(myfilename);
                    InputStreamReader inputStreamReader=new InputStreamReader
                            (fileInputStream,"UTF-8");
                    char mycontent[]=new char[fileInputStream.available()];
                    inputStreamReader.read(mycontent);
                    inputStreamReader.close();
                    fileInputStream.close();
                    String listResult=new String(mycontent);
                    tvRead.setText("从内部文件"+myfilename+"读到的数据:\n\n"+listResult);

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
