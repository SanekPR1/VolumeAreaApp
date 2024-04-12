package com.makridin.volumecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.makridin.volumecalculatorapp.Utility.Utility;

import java.text.DecimalFormat;

public class Sphere extends AppCompatActivity {

    private EditText editText;
    private TextView resultVolume;
    private Button btn, backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        btn = findViewById(R.id.sphere_button);
        editText = findViewById(R.id.editText_sphere);
        resultVolume = findViewById(R.id.result_sphere);
        backBtn = findViewById(R.id.sphere_back_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = editText.getText().toString();
                int r = Integer.valueOf(radius);
                double result = (4/3) * Math.PI * Math.pow(r, 3);
                resultVolume.setText("Volume of Sphere is: " + Utility.df.format(result) + " M^3");
            }
        });

        backBtn.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        });
    }
}