package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbtn = findViewById(R.id.convert_btn);
        Button enterBtn = findViewById(R.id.enterBtn);

        EditText poundsInput = findViewById(R.id.poundsInput);
        TextView kgText = findViewById(R.id.kgText);

        EditText finput = findViewById(R.id.fahrenheit_input);
        TextView ctxt = findViewById(R.id.celcius_text);


        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celcius));
        });

        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (poundsInput.getText().length() == 0)
                    return;
                double kg = Converter.toKG(Float.parseFloat(poundsInput.getText().toString()));
                kgText.setText(String.format("%.2f kg", kg));

            }
        });


    }
}