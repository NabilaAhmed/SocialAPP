package com.example.android.application.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.application.Objects.Client;
import com.example.android.application.R;

import java.util.List;

/**
 * Created by nabila on 30/09/2018.
 */

public class ClientAdapter extends ArrayAdapter<Client> {

    //    int[] x;
    Activity context;
    List<Client> clients;
    //    String[] y;
//    String[] z;
    private LayoutInflater mInflater;

    public ClientAdapter(Activity context, List<Client> clients) {
        super(context, R.layout.customlayout, clients);
        this.context = context;
        this.clients = clients;

    }
    //    public ListAdapter(Context context,x,allElementDetails) {
//        allElementDetails = results;
//        mInflater = LayoutInflater.from(context);
//    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mInflater = context.getLayoutInflater();
        convertView= mInflater.inflate(R.layout.customlayout, null, true);
        ImageView imageview = (ImageView) convertView.findViewById(R.id.imageView2);

        TextView textview = (TextView) convertView.findViewById(R.id.textView3);
        ImageButton imageButton = (ImageButton) convertView.findViewById(R.id.imageButton);

        Client client = clients.get(position);
        textview.setText(client.getClientID());

        return convertView;
    }
}
