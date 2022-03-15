package com.example.androidtuan05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Listview_adapter adapter;
    private ListView listView;
    private Button btnD,btnPD,btnF;
    private List<Cake> list;
    private List<Cake> cakeList;
    private List<Cake> cakeBtn;
    private EditText txtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        btnD = findViewById(R.id.button1);
        btnPD = findViewById(R.id.button2);
        btnF = findViewById(R.id.button3);
        txtSearch  = findViewById(R.id.editTextSearch);

        list = new ArrayList<>();
        cakeList = new ArrayList<>();
        cakeBtn = new ArrayList<>();
        list.add(new Cake(R.drawable.donut_yellow,"Tasty Donut Yellow","$10.00","Dount"));
        list.add(new Cake(R.drawable.tasty_donut,"Pink Donut","$20.00","Pink Donut"));
        list.add(new Cake(R.drawable.green_donut,"Floating Tasty Donut","$30.00","Floating"));
        list.add(new Cake(R.drawable.green_donut,"Floating Donut","$30.00","Dount"));
        list.add(new Cake(R.drawable.donut_red,"Tasty Donut","$40.00","Dount"));

        adapter = new Listview_adapter(this, R.layout.listview_item,cakeList);

        listView.setAdapter(adapter);

        processOnclick(btnD,btnPD,btnF);

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOnclick(btnD,btnPD,btnF);
            }
        });

        btnPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOnclick(btnPD,btnD,btnF);
            }
        });
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOnclick(btnF,btnD,btnPD);
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Cake cake = list.get(position);
//                Toast.makeText(getApplicationContext(), "lll;llllllll", Toast.LENGTH_LONG).show();
//                startActivity(new Intent(MainActivity.this,Item_Listview_Detail.class).putExtra("cake",cake));
//            }
//        });

      txtSearch.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
              cakeList.clear();

              String regex ="^("+s.toString().toUpperCase()+").*";
                for (Cake cake: cakeBtn){
                    if (cake.getName().toUpperCase().matches(regex)){
                       cakeList.add(cake);
                    }
                }

                adapter.notifyDataSetChanged();
          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      });



    }

    private void processOnclick(Button btn1, Button btn2, Button btn3){
        btn1.setBackgroundColor(Color.parseColor("#FF9800"));
        btn2.setBackgroundColor(Color.parseColor("#DDD4D4"));
        btn3.setBackgroundColor(Color.parseColor("#DDD4D4"));

        cakeList.clear();
        cakeBtn.clear();

        String category = "Dount";
        if (btn1 == btnPD){
            category = "Pink Donut";
        }
        if (btn1 == btnF){
            category = "Floating";
        }
        for(Cake item:list){
            if (item.getCategory().trim().equalsIgnoreCase(category.trim())){
                cakeList.add(item);
                cakeBtn.add(item);
            }
        }

        adapter.notifyDataSetChanged();
    }

}