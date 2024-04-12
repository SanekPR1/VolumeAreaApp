package com.makridin.volumecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.makridin.volumecalculatorapp.Utility.Utility;

public class Cylinder extends AppCompatActivity {
    private EditText height, radius;
    private TextView resultVolume;
    private Button btn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        btn = findViewById(R.id.cylinder_button);
        height = findViewById(R.id.editText_cylinder_height);
        radius = findViewById(R.id.editText_cylinder_radius);
        resultVolume = findViewById(R.id.result_cylinder);
        backBtn = findViewById(R.id.cylinder_back_button);

        btn.setOnClickListener(v -> {
            int r = Integer.valueOf(radius.getText().toString());
            int h = Integer.valueOf(height.getText().toString());

            double result = Math.PI * Math.pow(r, 2) * h;
            resultVolume.setText("Volume of Cylinder is: " + Utility.df.format(result) + " M^3");
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}