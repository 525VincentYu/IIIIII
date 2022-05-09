package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    Context context;
    ArrayList<Db2ModelClass>db2ModelClassesArrayList = new ArrayList<Db2ModelClass>();

    public MyAdapter2(Context context,ArrayList<Db2ModelClass> db2ModelClassesArrayList) {
        this.context = context;
        this.db2ModelClassesArrayList = db2ModelClassesArrayList;

    }


    @NonNull
    @Override
    public MyAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.itemtruck, null);
        MyAdapter2.MyViewHolder myViewHoder = new MyAdapter2.MyViewHolder(view);
        return myViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
       Db2ModelClass db2ModelClass = db2ModelClassesArrayList.get(position);
       holder.imageButton.setImageBitmap(db2ModelClass.getImage());
       holder.name.setText(db2ModelClass.getName());
       holder.discription.setText(db2ModelClass.getDiscription());
       holder.imageButton2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String title1 = db2ModelClass.getName();
               String context1 = db2ModelClass.getDiscription();

               Intent share1 = new Intent(Intent.ACTION_SEND);

               String extraText="This car type is"+title1+", besides its Model is"+context1;

               share1.putExtra(Intent.EXTRA_TEXT, extraText);
               share1.setType("text/plain");
               context.startActivity(Intent.createChooser(share1,"SHARE"));


           }
       });


        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Intent intent = new Intent(context.getApplicationContext(),OrderdetailsActivity.class);

                    context.startActivity(intent);


                }
                if (position == 1) {
                    Intent intent = new Intent(context.getApplicationContext(),OrderdetailsActivity.class);

                    context.startActivity(intent);

                                   }
                if (position == 2) {
                    Intent intent = new Intent(context.getApplicationContext(),OrderdetailsActivity.class);

                    context.startActivity(intent);

                                    }

            }
        });

    }

    @Override
    public int getItemCount() {
        if(db2ModelClassesArrayList!=null){
        return db2ModelClassesArrayList.size();}
        else {
            Toast.makeText(context, "nullllll", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageButton imageButton,imageButton2;
        TextView name;
        TextView discription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.image);
            imageButton2 = itemView.findViewById(R.id.share);
            name = itemView.findViewById(R.id.trukname);
            discription = itemView.findViewById(R.id.discription);

        }
    }
}
