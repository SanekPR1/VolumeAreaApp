package com.makridin.volumecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.makridin.volumecalculatorapp.Utility.Utility;

public class Cube extends AppCompatActivity {
    private EditText edge;
    private TextView resultVolume;
    private Button btn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        btn = findViewById(R.id.cube_button);
        edge = findViewById(R.id.editText_cube);
        resultVolume = findViewById(R.id.result_cube);
        backBtn = findViewById(R.id.cube_back_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = Math.pow(Integer.valueOf(edge.getText().toString()), 3);
                resultVolume.setText("Volume of Cube is: " + Utility.df.format(result) + " M^3");
            }
        });

        backBtn.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        });
    }
}