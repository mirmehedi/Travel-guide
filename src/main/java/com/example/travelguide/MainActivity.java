package com.example.travelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    int[] flags = {R.drawable.hotel, R.drawable.restaurant, R.drawable.sea, R.drawable.info};
    private GridView gridView;
    String[] categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categories = getResources().getStringArray(R.array.categories);
        gridView = findViewById(R.id.grid_container);
        GridAdaptar adapter = new GridAdaptar(this,flags,categories);
        gridView.setAdapter(adapter);
    }
}