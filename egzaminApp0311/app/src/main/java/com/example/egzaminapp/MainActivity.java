package com.example.egzaminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button next, prev;
    ImageView imageView;

    private ArrayList<Integer> images = new ArrayList<Integer>();
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addImagesToArray();

        next = findViewById(R.id.nextButton);
        prev = findViewById(R.id.prevButton);
        imageView = findViewById(R.id.imageView);

        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i++;
                        if(images.size() == i) {
                            i = 0;
                        }
                        displayImages(i);
                    }
                }
        );

        prev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i--;
                        if(i<0) {
                            i = images.size()-1;
                        }
                        displayImages(i);
                    }
                }
        );
    }

    private void displayImages(int i){
        imageView.setImageResource(images.get(i));
    }

    private void addImagesToArray() {
        images.add(R.drawable.cat1);
        images.add(R.drawable.cat2);
        images.add(R.drawable.cat3);
    }
}