package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class neworderActivity extends LoginActivity {

    TextView newordername,pickuotime,pickuplocation;
    CalendarView calendarView;
    Button button;
    public Neworder neworder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neworder);
        neworder = new Neworder();

        newordername = findViewById(R.id.newodername);
        pickuotime = findViewById(R.id.pickuptime);
        pickuplocation = findViewById(R.id.pickuplocation);
        button = findViewById(R.id.next);
        calendarView = findViewById(R.id.calendarView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                neworder.setReciver(newordername.getText().toString());
                neworder.setPickuptime(pickuotime.getText().toString());
                neworder.setPickuolocation(pickuplocation.getText().toString());
                neworder.setCalendarView(calendarView);
                Intent intent = new Intent(getApplicationContext(),neworder2Activity.class);
                intent.putExtra("key",newordername.getText().toString());
                intent.putExtra("key1",pickuotime.getText().toString());

                startActivity(intent);



            }
        });

    }
}