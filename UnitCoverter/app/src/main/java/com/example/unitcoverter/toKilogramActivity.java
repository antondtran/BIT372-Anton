package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class toKilogramActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_kilogram);


        Button enterBtn = findViewById(R.id.enterBtn);

        EditText poundsInput = findViewById(R.id.poundsInput);
        TextView kgText = findViewById(R.id.kgText);

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