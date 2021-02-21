package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class toKilometerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_kilometer);

        Button backBtnKM = findViewById(R.id.backBtnKM);
        Button convertBtn = findViewById(R.id.convertBtn);

        EditText milesInput = findViewById(R.id.milesInput);
        TextView kmText = findViewById(R.id.kmText);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (milesInput.getText().length() == 0)
                    return;
                double km = Converter.toKM(Float.parseFloat(milesInput.getText().toString()));
                kmText.setText(String.format("%.2f km", km));

            }
        });

        backBtnKM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(toKilometerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    }