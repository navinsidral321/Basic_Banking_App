package com.example.bankingsystemversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Database database;
    ImageView imageView;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    button1 =findViewById(R.id.button6);

        Intent in =getIntent();
        //database=this.openOrCreateDatabase("users",MODE_PRIVATE,null);
        database =new Database(this);
        //database.onCreate();
        //database.insertdata();
        //imageView=findViewById(R.id.imageView5);
        //Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
      //  imageView.startAnimation(animation);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);

            }
        });
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("Black")));
        getSupportActionBar().setTitle("Banking System");

    }
}
