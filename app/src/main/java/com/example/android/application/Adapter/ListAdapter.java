package com.example.android.application.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.application.R;

/**
 * Created by nabila on 30/09/2018.
 */

public class ListAdapter extends BaseAdapter {

    int[] x;
    Context context;
    String[] y;
    String[] z;
    private LayoutInflater mInflater;

    public ListAdapter(int[] x, Context context, String[] y, String[] z) {
        this.x = x;
        this.context = context;
        this.y = y;
        this.z = z;
    }

//    public ListAdapter(Context context,x,allElementDetails) {
//        allElementDetails = results;
//        mInflater = LayoutInflater.from(context);
//    }

    public int getCount() {
        return x.length;
    }

    public Object getItem(int position) {
        return x[position];
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        mInflater = LayoutInflater.from(context);


        convertView = mInflater.inflate(R.layout.customlayout, null);
        ImageView imageview = (ImageView) convertView.findViewById(R.id.imageView2);

        TextView textview = (TextView) convertView.findViewById(R.id.textView3);
        ImageButton imageButton = (ImageButton) convertView.findViewById(R.id.imageButton);


        textview.setText(y[position]);
        imageview.setImageResource(x[position]);
        return convertView;
    }
}
