package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class toCelciusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_celcius);

        Button fbtn = findViewById(R.id.convert_btn);
        Button backBtn = findViewById(R.id.backBtn);


        EditText finput = findViewById(R.id.fahrenheit_input);
        TextView ctxt = findViewById(R.id.celcius_text);


        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celcius));
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(toCelciusActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}