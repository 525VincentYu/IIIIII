package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class neworder2Activity extends neworderActivity {

    Button furniture,drygoods,food,builing,truck,van,re,mini;
    EditText other1,other2,weight,width,length,height;
    Button create;

    Database2 DB;
    Database3 DB1;

    ArrayList<Db2ModelClass> fullorder;


    public int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String reciever = extras.getString("key");
            String pick = extras.getString("key1");

        DB = new Database2(this);
        DB1 = new Database3(this);
        setContentView(R.layout.activity_neworder2);
        furniture = findViewById(R.id.furniture);
        drygoods = findViewById(R.id.dry);
        food = findViewById(R.id.food);
        builing = findViewById(R.id.bulding);
        truck = findViewById(R.id.trunk);
        van = findViewById(R.id.van);
        re = findViewById(R.id.fre);
        mini = findViewById(R.id.mini);
        other1 = findViewById(R.id.other1);
        other2 = findViewById(R.id.other2);
        weight = findViewById(R.id.weight);
        width = findViewById(R.id.width);
        length = findViewById(R.id.length);
        height = findViewById(R.id.height);
        create = findViewById(R.id.create);

        furniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                furniture.setBackground(getResources().getDrawable(R.drawable.button_border));
                neworder.setGoodtype("furniture");
            }
        });
        drygoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drygoods.setBackground(getResources().getDrawable(R.drawable.button_border));
                neworder.setGoodtype("drygoods");


            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food.setBackground(getResources().getDrawable(R.drawable.button_border));
                neworder.setGoodtype("food");


            }
        });
        builing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builing.setBackground(getResources().getDrawable(R.drawable.button_border));
                neworder.setGoodtype("bulding material");

            }
        });
        truck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                truck.setBackground(getResources().getDrawable(R.drawable.button_border));
                //fullorder =DB.getAlldata1();
                neworder.setVehicle(R.drawable.a);
                flag =1;


                }




        });
        van.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                van.setBackground(getResources().getDrawable(R.drawable.button_border));
                neworder.setVehicle(R.drawable.b);
                order.add(fullorder.get(2));

                flag =2;

            }
        });
        re.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                re.setBackground(getResources().getDrawable(R.drawable.button_border));
                neworder.setVehicle(R.drawable.c);
                order.add(fullorder.get(3));
                flag =3;

            }
        });
        mini.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mini.setBackground(getResources().getDrawable(R.drawable.button_border));
                neworder.setVehicle(R.drawable.d);
                order.add(fullorder.get(4));
                flag =4;

            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                neworder.setWeight(weight.getText().toString());
                neworder.setWidth(width.getText().toString());
                neworder.setLength(length.getText().toString());
                neworder.setHeight(height.getText().toString());
                neworders.add(neworder);
                boolean insert1 = DB1.insertData(flag,"Ning",pick,reciever,weight.getText().toString(),neworder.getGoodtype(),width.getText().toString(),height.getText().toString(),length.getText().toString());
                if(insert1){
                    Toast.makeText(neworder2Activity.this, "DDDDDDDData saved", Toast.LENGTH_SHORT).show();}
                else {
                    Toast.makeText(neworder2Activity.this, "DDDDAta not saved", Toast.LENGTH_SHORT).show();
                }



                if(flag==1){

                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.a);
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG ,10,byteArray);
                    byte[]img = byteArray.toByteArray();
                    boolean insert = DB.insertData(img,"2011 Kenworth T359 Cab Chassis","01/2011 Kenworth T359 Rigid Truck; 8x4; ODO Showing: 533,432kms; Engine: ISL 355 Cummins; ");
                    if(insert == true){
                        Toast.makeText(neworder2Activity.this, "data saved", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(neworder2Activity.this, "Data notsaved", Toast.LENGTH_SHORT).show();
                    }

                }

                if(flag==2){

                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.b);
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG ,10,byteArray);
                    byte[]img = byteArray.toByteArray();
                    boolean insert = DB.insertData(img,"2000 Hino FG Table / Tray Top","05/2000 Hino Tray Body Truck FG1J; 4x2; Colour: White; ODO Showing: 894,119 kms; GVM: 15,000 kgs; ");
                    if(insert == true){
                        Toast.makeText(neworder2Activity.this, "data saved", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(neworder2Activity.this, "Data notsaved", Toast.LENGTH_SHORT).show();
                    }

                }
                if(flag==3){

                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.b);
                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG ,10,byteArray);
                    byte[]img = byteArray.toByteArray();
                    boolean insert = DB.insertData(img,"2005 Hino 300 Series 916 Tipper","2005 Hino Dutro Tip Truck; 4x2; Approx Bin Length: 3.6m; Approx Bin Height: 44cm; Manual Transmission;  ");
                    if(insert == true){
                        Toast.makeText(neworder2Activity.this, "data saved", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(neworder2Activity.this, "Data notsaved", Toast.LENGTH_SHORT).show();
                    }

                }
                Intent intent = new Intent(getApplicationContext(),MyorderActivity.class);
                //intent.putExtra("key",flag);
                Intent intent1 = new Intent(getApplicationContext(),HomeActivity.class);

                startActivity(intent1);
                //startActivity(intent);

            }
        });




    }
}}