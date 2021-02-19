package com.example.bankingsystemversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity  {
        TextView name;
        Button button;
        Button button1;
        Database database;
        Spinner spinner;
        String a;
        int n1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name=(TextView) findViewById(R.id.name1);
        database=new Database(this);
        Intent intent=getIntent();
        //n1=intent.getStringExtra("value");
        n1=intent.getIntExtra("value",0);
        Cursor c=database.getdata(n1);
        StringBuffer stringBuffer=new StringBuffer();
        while (c.moveToNext()){
            stringBuffer.append("ID : "+c.getString(0)+"\n");
            stringBuffer.append("Name : "+c.getString(1)+"\n");
            stringBuffer.append("Balance : "+c.getString(2)+"\n");
            stringBuffer.append("E-Mail : "+c.getString(3)+"\n");
            stringBuffer.append("Phone-Number : "+c.getString(4)+"\n");
        }
        name.setText(stringBuffer);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Main4Activity.class);
                intent.putExtra("value", n1);
                startActivity(intent);
            }


        });

    }


}
