package com.example.bankingsystemversion1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    SQLiteDatabase db=this.getReadableDatabase();
    public static final String databasename="users.db";
    public static final String tablename="user";
    public static final String tablename1="transfer";
    public static final String column_1="ID";
    public static final String column_2="name";
    public static final String column_3="balance";
    public static final String column_4="e-mail";
    public static final String column_5="phone_no";

    public Database(@Nullable Context context) {
        super(context,databasename,null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tablename +" (ID INT NOT NULL PRIMARY KEY,Name TEXT,Balance TEXT,E_mail TEXT,Phone_Number TEXT)");
        db.execSQL("create table "+tablename1+"(Id INTEGER PRIMARY KEY AUTOINCREMENT,name1 Text,name2 Text,amount int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+tablename);
        db.execSQL("drop table if exists "+tablename1);
        onCreate(db);
    }
    public void insertdata(){

        db.execSQL("insert into "+tablename+"(ID,Name,Balance,E_mail,Phone_number) values(1,'abab',10000,'abab@emial.com',12345)");
        db.execSQL("insert into "+tablename+"(ID,Name,Balance,E_mail,Phone_number) values(2,'aabb',150000,'aabb@emial.com',00000)");
        db.execSQL("insert into "+tablename+"(ID,Name,Balance,E_mail,Phone_number) values(3,'abcde',100000,'1234@emial.com',123451)");
        db.execSQL("insert into "+tablename+"(ID,Name,Balance,E_mail,Phone_number) values(4,'acac',200000,'0000@emial.com',123452)");
        db.execSQL("insert into "+tablename+"(ID,Name,Balance,E_mail,Phone_number) values(5,'abba',1000,'abba@emial.com',123453)");
        db.execSQL("insert into "+tablename+"(ID,Name,Balance,E_mail,Phone_number) values(6,'bbcc',10000,'bbcc@emial.com',123454)");
        db.execSQL("insert into "+tablename+"(ID,Name,Balance,E_mail,Phone_number) values(7,'pqrs',103000,'aa11@emial.com',123455)");
        db.execSQL("insert into "+tablename+"(ID,Name,Balance,E_mail,Phone_number) values(8,'bbbb',5000,'1010@emial.com',123456)");
        db.execSQL("insert into "+tablename+"(ID,Name,Balance,E_mail,Phone_number) values(9,'abcd',300000,'1111@emial.com',123457)");
        db.execSQL("insert into "+tablename+"(ID,Name,Balance,E_mail,Phone_number) values(10,'aaaa',80000,'aaaa@emial.com',123458)");
    }
   public Cursor getdata(int n){
       Cursor c=db.rawQuery("select * from user where ID="+n+"",null);
       return c;
   }


    public void onCreate() {
    onUpgrade(db,1,2);
    }
    public int update(int n, int m, String n1){
        Cursor c;
        c=db.rawQuery("select Balance from user where ID="+n+"",null);
        Cursor c1=db.rawQuery("select Balance from user where Name='"+n1+"'",null);
        int balance = 0;
        int balance1=0;
        while (c.moveToNext()){
            balance=c.getInt(0);
        }
        while (c1.moveToNext()){
            balance1=c1.getInt(0);
        }

        if(balance<m){
            return 0;
        }
        else {
            db.execSQL("UPDATE user SET Balance=" +(balance-m)+ " where ID="+n+"");
            db.execSQL("UPDATE user SET Balance=" +(m+balance1)+ " where Name='"+n1+"'");
        }
        return 1;
    }
    public String getname(int m){
        Cursor c;
        c=db.rawQuery("Select Name from user where ID="+m+"",null);
        String b="";
        while(c.moveToNext()){
            b=c.getString(0);
        }
        return b;
    }
    public int getbalance(int m){
        Cursor c;
        c=db.rawQuery("Select Balance from user where ID="+m+"",null);
        int balance=0;
        while(c.moveToNext()){
            balance=c.getInt(0);
        }
        return balance;
    }
    public int phoneNumber(int m){
        Cursor c;
        c=db.rawQuery("Select Phone_Number from user where ID="+m+"",null);
        int balance=0;
        while(c.moveToNext()){
            balance=c.getInt(0);
        }
        return balance;
    }
    public void transfertable(int name1,String name2,int amount){
        String name=getname(name1);
        db.execSQL("insert into transfer (name1,name2,amount) values('"+name+"','"+name2+"',"+amount+")");
    }
    public String name1(int m){
        Cursor c;
        c=db.rawQuery("Select name1 from transfer where Id="+m+"",null);
        String balance=" ";
        while(c.moveToNext()){
            balance=c.getString(0);
        }
        return balance;
    }
    public String name2(int m){
        Cursor c;
        c=db.rawQuery("Select name2 from transfer where Id="+m+"",null);
        String balance=" ";
        while(c.moveToNext()){
            balance=c.getString(0);
        }
        return balance;
    }
    public int amountTransfer(int m){
        Cursor c;
        c=db.rawQuery("Select amount from transfer where Id="+m+"",null);
        int balance=0;
        while(c.moveToNext()){
            balance=c.getInt(0);
        }
        return balance;
    }
    public int count(){
        int count=0;
        Cursor c;
        c=db.rawQuery("Select count(Id) from transfer",null);

        while(c.moveToNext()){
            count=c.getInt(0);
        }
        return count;

    }
}
