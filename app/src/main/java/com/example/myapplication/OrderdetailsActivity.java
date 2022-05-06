package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderdetailsActivity extends MyorderActivity {
    ImageView imageView;
    TextView sender,pick,receiver,drop,weight,width,height,length,quantity,type;
    Database3 DB;
    String username = "Ning";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdetails);
        DB = new Database3(this);



        //neworder = (Neworder) getIntent().getSerializableExtra("KEY1");

        imageView = findViewById(R.id.imageView3);
        sender = findViewById(R.id.sender);
        pick = findViewById(R.id.pickuptime1);
        receiver = findViewById(R.id.receiver1);
        drop = findViewById(R.id.dropofftime);
        weight = findViewById(R.id.weight1);
        width = findViewById(R.id.width1);
        height = findViewById(R.id.height1);
        length = findViewById(R.id.length1);
        quantity = findViewById(R.id.quantity);
        type = findViewById(R.id.type1);
        String cursor0 = DB.getimageid(username);
        String cursor1 = DB.getsender(username);
        String cursor2 = DB.getpicktime(username);
        String cursor3 = DB.getreciver(username);
        String cursor4 = DB.getweight(username);
        String cursor5 = DB.gettype(username);
        String cursor6 = DB.getwidth(username);
        String cursor7 = DB.getheight(username);
        String cursor8 = DB.getlength("Ning");

        imageView.setImageResource(R.drawable.a);



        sender.setText(cursor1);
        pick.setText(cursor2);
        receiver.setText(cursor3);
        drop.setText("9:30PM");
        type.setText("Weight:\n" + cursor5);
        weight.setText("Type:\n" + cursor4);
        width.setText("Width:\n" + cursor6);
        height.setText("Height:\n" + cursor7);
        length.setText("Length:\n"+cursor8);
        quantity.setText("Quantity:\n1");


    }
}