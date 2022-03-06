package com.example.travelguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdaptar extends BaseAdapter {
    Context context;
    int[] flags;
    String[] categories;
    private LayoutInflater inflater;
    GridAdaptar( Context contex,int[] flags,String[] categories) {
        this.context = contex;
        this.flags = flags;
        this.categories = categories;
    }

        @Override
    public int getCount() {
        return categories.length;
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
        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item,parent,false);

        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        TextView textView = (TextView) convertView.findViewById(R.id.title);
        imageView.setImageResource(flags[position]);
        textView.setText(categories[position]);

        return convertView;
    }
}
