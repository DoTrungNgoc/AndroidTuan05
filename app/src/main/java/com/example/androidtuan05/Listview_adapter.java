package com.example.androidtuan05;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.util.List;

public class Listview_adapter extends BaseAdapter {

    private Context context;
    private int idLayout;
    private List<Cake> list;

    public Listview_adapter(Context context, int idLayout, List<Cake> list) {
        this.context = context;
        this.idLayout = idLayout;
        this.list = list;
    }



    @Override
    public int getCount() {
        if (list.size() != 0 && !list.isEmpty()) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }
        TextView name = convertView.findViewById(R.id.textViewName);
        TextView price = convertView.findViewById(R.id.textViewPrice);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        final Cake cake = list.get(position);

        if (list != null && !list.isEmpty()){
            name.setText(cake.getName());
            price.setText(cake.getPricel());
            imageView.setImageResource(cake.getImage());
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Item_Listview_Detail.class);
                intent.putExtra("cake",cake);
                context.startActivity(intent);
            }
        });


        return convertView;
    }

}
