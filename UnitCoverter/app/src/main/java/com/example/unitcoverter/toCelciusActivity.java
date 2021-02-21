package com.example.unitcoverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.unitcoverter.databinding.ActivityToCelciusBinding;


public class toCelciusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_celcius);


        User user = new User("Fahrenheit to Celcius");

        ActivityToCelciusBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_to_celcius);
        binding.setLifecycleOwner(this);
        binding.setUser(user);





        Button fbtn = findViewById(R.id.convert_btn);
        Button backBtnCelcius = findViewById(R.id.backBtnCelcius);


        EditText finput = findViewById(R.id.fahrenheit_input);
        TextView ctxt = findViewById(R.id.celcius_text);


        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celcius));
        });

        backBtnCelcius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(toCelciusActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}