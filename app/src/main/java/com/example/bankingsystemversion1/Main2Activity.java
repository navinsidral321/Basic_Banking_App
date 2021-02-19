package com.example.bankingsystemversion1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String n;
    Database database;
    String a[]={"abab","aabb","abcde","acac","abba","bbcc","pqrs","bbbb","abcd","aaaa"};
    Button button;

    public int[] function(){
        int a[]=new int [10];
        for(int i=0;i<10;i++){
            try {
                a[i]=database.getbalance(i+1);
            }
            catch (Exception e){
                a[i]=Objects.requireNonNull(database).getbalance(1);
            }
        }
        return a;
    }
    public int[] function1(){
        int a[]=new int [10];
        for(int i=0;i<10;i++){
            try {
                a[i]=database.phoneNumber(i+1);
            }
            catch (Exception e){
                a[i]=Objects.requireNonNull(database).getbalance(1);
            }
        }
        return a;

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       listView =(ListView) findViewById(R.id.listview1);
        database=new Database(this);
        button=findViewById(R.id.button8);
        int[] b1=function();
        int[] b2=function1();
        hii hi=new hii(this,a,b1,b2);
        listView.setAdapter(hi);

        //listview

        //ON CLICK

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> p, View view, int position, long id) {
               Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
                intent.putExtra("value",position+1);
                startActivity(intent);


            }
        });
        listView.setAdapter(hi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main5Activity.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("Black")));
        getSupportActionBar().setTitle("Banking System");

    }
    class hii extends ArrayAdapter<String>{
        Context context;
        String[] s;
        int n[];
        int n1[];
        hii(Context c,String title[],int title1[],int title2[]){
            super(c,R.layout.row,R.id.textView2,title);
            this.context=c;
            this.s=title;
            this.n=title1;
            this.n1=title2;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup p) {
            LayoutInflater layoutInflater= (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row=layoutInflater.inflate(R.layout.row,p,false);
            TextView textView=row.findViewById(R.id.textView2);
            TextView textView1=row.findViewById(R.id.textView5);
            ImageView imageview=row.findViewById(R.id.imageView2);
            TextView textView2=row.findViewById(R.id.textView6);
            textView.setText(s[position]);
            textView1.setText("Rs. "+n[position]);
            imageview.setImageResource(R.drawable.image3);
            textView2.setText(": "+n1[position]);
            return row;
        }
    }

}
