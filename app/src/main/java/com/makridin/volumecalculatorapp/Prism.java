package com.makridin.volumecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.makridin.volumecalculatorapp.Utility.Utility;

public class Prism extends AppCompatActivity {
    private EditText height, length, width;
    private TextView resultVolume;
    private Button btn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);

        btn = findViewById(R.id.prism_button);
        height = findViewById(R.id.editText_prism_height);
        length = findViewById(R.id.editText_prism_length);
        width = findViewById(R.id.editText_prism_width);
        resultVolume = findViewById(R.id.result_prism);
        backBtn = findViewById(R.id.prism_back_button);

        btn.setOnClickListener(v -> {
            int l = Integer.valueOf(length.getText().toString());
            int h = Integer.valueOf(height.getText().toString());
            int w = Integer.valueOf(width.getText().toString());

            double result = l * w * h;
            resultVolume.setText("Volume of Prism is: " + Utility.df.format(result) + " M^3");
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