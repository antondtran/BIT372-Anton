package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class toMeterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_meter);

        Button convertBtnFt = findViewById(R.id.convertBtnFt);
        EditText feetInput = findViewById(R.id.feetInput);
        TextView meterText = findViewById(R.id.meterText);
        Button backBtnMeter = findViewById(R.id.backBtnMeter);

        convertBtnFt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (feetInput.getText().length() == 0)
                    return;
                double meter = Converter.toMeter(Float.parseFloat(feetInput.getText().toString()));
                meterText.setText(String.format("%.2f meter", meter));

            }
        });

        backBtnMeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(toMeterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}