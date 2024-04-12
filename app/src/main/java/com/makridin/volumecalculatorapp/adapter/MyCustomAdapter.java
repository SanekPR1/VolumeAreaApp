package com.makridin.volumecalculatorapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.makridin.volumecalculatorapp.R;
import com.makridin.volumecalculatorapp.model.Shape;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<Shape> {
    private List<Shape> shapes;
    private Context context;

    public MyCustomAdapter(@NonNull Context context, List<Shape> shapes) {
        super(context, R.layout.grid_item_layout, shapes);
        this.shapes = shapes;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1 - Get Shape object for the current position
        Shape shape = getItem(position);

        //2 - Inflating layout
        MyViewHolder holder;
        if(convertView == null) {
            //no view went off screen -> create a new view
            holder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false);
            //Finding the views
            holder.shapeName = convertView.findViewById(R.id.textView);
            holder.image = convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);

        } else {
            // a view went off screen -> re-use it
            holder = (MyViewHolder) convertView.getTag();
        }

        //getting data from model class
        holder.shapeName.setText(shape.getShapeName());
        holder.image.setImageResource(shape.getShapeImage());
        return convertView;
    }

    private static class MyViewHolder {
        TextView shapeName;
        ImageView image;
    }
}
