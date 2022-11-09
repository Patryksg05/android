package com.example.lastprojectbeforequiz;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button next, prev;
    ImageView imageView;
    TextView colorChange;

    private ArrayList<Integer> images = new ArrayList<Integer>();
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String color = intent.getStringExtra("Color");
        colorChange = findViewById(R.id.colorChange);
        colorChange.setText(color);

        fillArrayWithPhoto();

        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        imageView = findViewById(R.id.imageView);

        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentIndex++;
                        if(currentIndex == images.size()) {
                            currentIndex = 0;
                        }
                        displayCurrentPhoto(currentIndex);
                    }
                }
        );

        prev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentIndex--;
                        if(currentIndex<0) {
                            currentIndex = images.size()-1;
                        }
                        displayCurrentPhoto(currentIndex);
                    }
                }
        );

    }

    private void displayCurrentPhoto(int index) {
        imageView.setImageResource(images.get(index));
    }

    private void fillArrayWithPhoto() {
        images.add(R.drawable.cat1);
        images.add(R.drawable.cat2);
        images.add(R.drawable.cat3);
    }
}