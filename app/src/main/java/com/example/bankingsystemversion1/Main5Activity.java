package com.example.bankingsystemversion1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Main5Activity extends AppCompatActivity {
    Database database;
    ListView listView;

    public String[] function(int count){
        String a[]=new String[count];
        int j=0;
        for(int i=count;i>0;i--){
            try {
                a[j]=database.name1(i);
            }
            catch (Exception e){

            }
            j++;
        }
        return a;
    }
    public String[] function1(int count){
        String a[]=new String[count];
        int j=0;
        for(int i=count;i>0;i--){
            try {
                a[j]=database.name2(i);
            }
            catch (Exception e){

            }
            j++;
        }
        return a;
    }
    public int[] function2(int count){
        int a[]=new int [count];
        int j=0;
        for(int i=count;i>0;i--){
            try {
                a[j]=database.amountTransfer(i);
            }
            catch (Exception e){

            }
            j++;
        }
        return a;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        listView =(ListView) findViewById(R.id.listview1);
        database=new Database(this);
        int count=database.count();
        String[] b1=function(count);
        String[] b2=function1(count);
        int[] b3=function2(count);
        Main5Activity.hiii hi=new Main5Activity.hiii(this,b1,b2,b3);
        listView.setAdapter(hi);
        listView.setDivider(null);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("Black")));
        getSupportActionBar().setTitle("Banking System");

    }
    class hiii extends ArrayAdapter<String> {
        Context context;
        String[] s;
        String n[];
        int n1[];
        hiii(Context c,String title[],String tilte1[],int tiltle2[]){
            super(c,R.layout.row1,R.id.textView10,title);
            this.context=c;
            this.s=title;
            this.n=tilte1;
            this.n1=tiltle2;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup p) {
            LayoutInflater layoutInflater= (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row=layoutInflater.inflate(R.layout.row1,p,false);
            TextView textView=row.findViewById(R.id.textView10);
            TextView textView1=row.findViewById(R.id.textView11);
            TextView textView2=row.findViewById(R.id.textView12);
            textView.setText(s[position]);
            textView1.setText(n[position]);
            textView2.setText(""+n1[position]);
            return row;
        }
    }
}
