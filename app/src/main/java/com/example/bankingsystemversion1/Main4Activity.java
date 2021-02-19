package com.example.bankingsystemversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Main4Activity extends Activity implements AdapterView.OnItemSelectedListener {
    Button button;
    Button button1;
    Spinner spinner;
    EditText editText;
    Database database;
    String a;
    int n1=0;
    int m=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        button = findViewById(R.id.button4);
        button1 = (Button) findViewById(R.id.button5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });
        database = new Database(this);
        Intent intent = getIntent();
        n1=intent.getIntExtra("value",0);
        //spinner
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        close();
        ArrayList<String> list1=new ArrayList<>();
        list1.add(" ");
        list1.add("abab");
        list1.add("aabb");
        list1.add("abcde");
        list1.add("acac");
        list1.add("abba");
        list1.add("bbcc");
        list1.add("pqrs");
        list1.add("bbbb");
        list1.add("abcd");
        list1.add("aaaa");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,list1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);
        //Button for transfer
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText=findViewById(R.id.editText);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                String m1=editText.getText().toString();
                m=Integer.parseInt(m1);
                close();
                if(a==" "){
                    Toast.makeText(getApplicationContext(),"Please Select the user from the Drop down list",Toast.LENGTH_SHORT).show();
                }
                else {
                    function();
                }
            }


        });

    }
    @Override
    public void onItemSelected(AdapterView<?> p, View view, int position, long id) {

        a=p.getItemAtPosition(position).toString();
        close();
        if(a!=" ") {
            Toast.makeText(getApplicationContext(), "Transfer to " + a, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> p) {

    }


    public void close() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void function(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("Are you sure.?");
        builder.setMessage("This Action can't be undone!");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int n;

                    n = database.update(n1,m,a.toString());
                    if (n == 1) {
                        Toast.makeText(getApplicationContext(), "Transfer Done", Toast.LENGTH_SHORT).show();
                        database.transfertable(n1,a.toString(),m);
                        editText.setText(null);

                    } else {
                        Toast.makeText(getApplicationContext(), "Not Enough Balance", Toast.LENGTH_SHORT).show();
                        editText.setText(null);
                    }
                }




        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

}

