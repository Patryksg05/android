package com.example.firstrevisionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button nextButton, prevButton;
    ImageView imageView;
    EditText numberText;
    Switch aSwitch;
    LinearLayout linearLayout;

    private ArrayList<Integer> images = new ArrayList<Integer>();
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillArrayWithPhoto();

        nextButton = findViewById(R.id.nextButton);
        prevButton = findViewById(R.id.prevButton);
        imageView = findViewById(R.id.imageView);
        numberText = findViewById(R.id.editTextNumber);
        aSwitch = findViewById(R.id.switch1);
        linearLayout = findViewById(R.id.linearLayoutMain);

        nextButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        index++;
                        if (index == images.size()) {
                            index = 0;
                        }
                        displayCurrentPhoto(index);
                    }
                }
        );

        prevButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        index--;
                        if (index < 0) {
                            index = images.size() - 1;
                        }
                        displayCurrentPhoto(index);
                    }
                }
        );

        numberText.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String number = numberText.getText().toString();
                        if (Integer.valueOf(number) >= 0 && Integer.valueOf(number) < 4) {
                            imageView.setImageResource(images.get(Integer.valueOf(number)));
                        } else
                            Toast.makeText(MainActivity.this, "Brak zdjecia", Toast.LENGTH_SHORT).show();
                    }
                }
        );


        aSwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        int bgColor = b ? Color.parseColor("#1565c0"):Color.parseColor("#00796B");
                        linearLayout.setBackgroundColor(bgColor);
                    }
                }
        );
    }

    private void displayCurrentPhoto(int i) {
        imageView.setImageResource(images.get(i));
    }

    private void fillArrayWithPhoto() {
        images.add(R.drawable.penguin1);
        images.add(R.drawable.penguin2);
        images.add(R.drawable.penguin3);
        images.add(R.drawable.penguin4);
    }
}