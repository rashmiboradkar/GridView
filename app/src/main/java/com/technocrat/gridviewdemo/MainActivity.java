package com.technocrat.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView grid;
    private TextView tv;
    private ImageView iv;

    int images[] ={R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5,};
    String name[] = {"Shrikant", "Mahima", "Rashmi", "Sneha", "Sonali"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();
    }

    private void initialise() {
        grid = findViewById(R.id.grid);
        // to create self  adapter
        grid.setAdapter(new MyGridAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Selected item is"+name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyGridAdapter extends BaseAdapter {    // inner class
        public MyGridAdapter(Context c) {
        }

        @Override
        public int getCount() {
            return name.length;  // count length name, images i.e...name 5 , images 5
        }

        @Override
        public Object getItem(int position) {
            return position; // which position i click
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           /* LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.custom, parent, false);*/

            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom,parent,false);

            iv = v.findViewById(R.id.iv);
            iv.setBackgroundResource(images[position]);

            tv = v.findViewById(R.id.text);
            tv.setText(name[position]);
            return v;
        }
    }
}