package com.makridin.volumecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.makridin.volumecalculatorapp.adapter.MyCustomAdapter;
import com.makridin.volumecalculatorapp.model.Shape;
import com.makridin.volumecalculatorapp.model.ShapeName;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //1 - AdapterView: GridView
    private GridView gridView;

    //2 - Data Source: ArrayList<Shape>
    private List<Shape> shapes;

    //3 - Adapter: MyCustomAdapter
    private MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        shapes = List.of(
                new Shape(R.drawable.sphere, ShapeName.SPHERE.getName()),
                new Shape(R.drawable.cylinder, ShapeName.CYLINDER.getName()),
                new Shape(R.drawable.cube, ShapeName.CUBE.getName()),
                new Shape(R.drawable.prism, ShapeName.PRISM.getName()));

        adapter = new MyCustomAdapter(getApplicationContext(), shapes);

        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Shape current = adapter.getItem(position);
                Intent intent = getIntent(current.getShapeName());
                startActivity(intent);
            }
        });
    }

    private Intent getIntent(String shapeName) {
        if(ShapeName.SPHERE.getName().equals(shapeName)) {
            return new Intent(getApplicationContext(), Sphere.class);
        } else if(ShapeName.CYLINDER.getName().equals(shapeName)) {
            return new Intent(getApplicationContext(), Cylinder.class);
        } else if(ShapeName.CUBE.getName().equals(shapeName)) {
            return new Intent(getApplicationContext(), Cube.class);
        } else {
            return new Intent(getApplicationContext(), Prism.class);
        }
    }
}