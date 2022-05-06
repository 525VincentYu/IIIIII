package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyorderActivity extends neworder2Activity implements PopupMenu.OnMenuItemClickListener {

    RecyclerView recyclerView;
    ImageButton addOrder,menu;
    Database2 DB;
    ArrayList<Db2ModelClass> db2ModelClassesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        DB =new Database2(this);
        fullorder=DB.getAlldata1();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("key");
            if(value ==1 ){
                order.add(fullorder.get(1));
            }
            //The key argument here must match that used in the other activity
        }








        recyclerView = findViewById(R.id.re);
        addOrder = findViewById(R.id.addOrderbtn1);
        menu = findViewById(R.id.menubtn1);


        //order.add(fullorder.get(1));
        MyAdapter2 myAdapter = new MyAdapter2(this,fullorder);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),neworderActivity.class);
                startActivity(intent);


            }
        });


    }










    public void showPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
        addOrder.setVisibility(View.INVISIBLE);
        //addOrder.setClickable(false);
        menu.setVisibility(View.INVISIBLE);




        // menu.setClickable(false);


    }


    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item1:

                addOrder.setVisibility(View.VISIBLE);
                menu.setVisibility(View.VISIBLE);
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);

                return true;
            case R.id.item2:

                return true;

            case R.id.item3:




                return true;

            default:
                return false;

        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}