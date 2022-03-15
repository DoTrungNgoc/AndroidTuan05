package com.example.androidtuan05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Item_Listview_Detail extends AppCompatActivity {
    private ImageView image;
    private TextView textViewName;
    private TextView textViewPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_listview_detail);

        Intent intent = getIntent();
        Cake cake = (Cake) intent.getSerializableExtra("cake");


        image = findViewById(R.id.image_Detail);
        textViewName = findViewById(R.id.textViewName_Detail);
        textViewPrice = findViewById(R.id.textViewPrice_Detail);

        image.setImageResource(cake.getImage());
        textViewName.setText(cake.getName());
        textViewPrice.setText(cake.getPricel());

    }
}