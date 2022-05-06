package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.util.ArrayList;

public class Database3 extends SQLiteOpenHelper {
    Context context;
    public Database3(Context context) {
        super(context, "order.db", null, 1);
        this.context =context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists orders (imageid number, sender text, pickupime text, reciever text,  weight text, " +
                "type text, width text, height text, length text );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists orders");

    }

    public Boolean insertData(  int imageid, String sender, String pickupime, String reciever, String weight, String type, String width, String height, String length )
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("imageid",imageid);
        contentValues.put("sender",sender);
        contentValues.put("pickupime",pickupime);
        contentValues.put("reciever",reciever);
        contentValues.put("weight",weight);
        contentValues.put("type",type);
        contentValues.put("width",width);
        contentValues.put("height",height);
        contentValues.put("length",length);
        long result = DB.insert("orders",null,contentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }



    }



    public String getsender(String sender){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from orders where sender = ?",new String[]{sender});
        cursor.moveToFirst();
        return cursor.getString(1);
    }

    public String getimageid(String sender){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from orders where sender = ?",new String[]{sender});
        cursor.moveToFirst();
        return cursor.getString(0);
    }
    public String getpicktime(String sender){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from orders where sender = ?",new String[]{sender});
        cursor.moveToFirst();
        return cursor.getString(2);
    }
    public String getreciver(String sender){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from orders where sender = ?",new String[]{sender});
        cursor.moveToFirst();
        return cursor.getString(3);
    }
    public String getweight(String sender){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from orders where sender = ?",new String[]{sender});
        cursor.moveToFirst();
        return cursor.getString(4);
    }
    public String gettype(String sender){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from orders where sender = ?",new String[]{sender});
        cursor.moveToFirst();
        return cursor.getString(5);
    }
    public String getwidth(String sender){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from orders where sender = ?",new String[]{sender});
        cursor.moveToFirst();
        return cursor.getString(6);
    }
    public String getheight(String sender){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from orders where sender = ?",new String[]{sender});
        cursor.moveToFirst();
        return cursor.getString(7);
    }
    public String getlength(String sender){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from orders where sender = ?",new String[]{sender});
        cursor.moveToFirst();
        return cursor.getString(8);
    }





    public ArrayList<Db2ModelClass> getAlldata()
    {
        try {
            ArrayList<Db2ModelClass>db2ModelClassArrayList = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            if(sqLiteDatabase!=null){
            Cursor cursor = sqLiteDatabase.rawQuery("select * from truck",null);
            if(cursor.getCount()!=0){
                while(cursor.moveToNext()){
                    String name = cursor.getString(1);
                    String discription = cursor.getString(2);
                    byte[] image = cursor.getBlob(0);
                    Bitmap imag = BitmapFactory.decodeByteArray(image, 0,image.length);
                    db2ModelClassArrayList.add(
                            new Db2ModelClass(
                                    imag,name,discription
                            )
                    );

                }
                return db2ModelClassArrayList;

            }
            else {
                Toast.makeText(context, "No data is ", Toast.LENGTH_SHORT).show();
                return null;
            }
            }
            else {
                Toast.makeText(context, "Data is null", Toast.LENGTH_SHORT).show();
                return null;
            }

        }
        catch (Exception e){
            Toast.makeText(context, "getAllData:-"+e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
