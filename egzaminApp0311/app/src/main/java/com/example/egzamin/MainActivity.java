package com.example.egzamin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.ServiceWorkerClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Switch aSwitch;
//    Drawable bg;
    LinearLayout layout;
    Button next, prev;

    private int index;

    private ArrayList<Integer> images = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addImagesToArray();

        imageView = findViewById(R.id.imageView); // obraz
        aSwitch = findViewById(R.id.switch1);
        layout = findViewById(R.id.linearLayout);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);

        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        index++;
                        if(index == images.size()) {
                            index = 0;
                        }
                        displayImage(index);
                    }
                }
        );

        prev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        index--;
                        if(index < 0) {
                            index = images.size()-1;
                        }
                        displayImage(index);
                    }
                }
        );

        aSwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b == true) {
                            layout.setBackgroundColor(Color.BLUE);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "OFF",
                                    Toast.LENGTH_SHORT).show();
//                            layout.setBackgroundColor(R.color.background_color);
                        }
                    }
                }
        );

    }

    private void displayImage(int i) {
        imageView.setImageResource(images.get(i));
    }

    private void addImagesToArray() {
        images.add(R.drawable.cat1);
        images.add(R.drawable.cat2);
        images.add(R.drawable.cat4);
    }

}