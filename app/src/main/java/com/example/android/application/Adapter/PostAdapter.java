package com.example.android.application.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.application.Objects.Post;
import com.example.android.application.R;

import java.util.List;

/**
 * Created by nabila on 01/10/2018.
 */

public class PostAdapter extends ArrayAdapter<Post> {
    Activity context;
    List<Post> Posts;
    //    String[] y;
//    String[] z;
    private LayoutInflater mInflater;

    public PostAdapter(Activity context, List<Post> Posts) {
        super(context, R.layout.customlayout, Posts);
        this.context = context;
        this.Posts = Posts;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mInflater = context.getLayoutInflater();
        convertView= mInflater.inflate(R.layout.customlayout, null, true);
        ImageView imageview = (ImageView) convertView.findViewById(R.id.imageView2);

        TextView textview = (TextView) convertView.findViewById(R.id.textView3);
        ImageButton imageButton = (ImageButton) convertView.findViewById(R.id.imageButton);
        Post post = Posts.get(position);
        textview.setText(post.getPost_Content());
        Log.d(post.getPost_Content()+"______", "getView: ");
        return convertView;
    }
}
