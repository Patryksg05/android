package com.example.lastprojectbeforequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button addButton, setBackground, nextPage;
    EditText color;

    private ArrayList<String> colors = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.addToArray);
        setBackground = findViewById(R.id.changeBackground);
        nextPage = findViewById(R.id.nextPage);
        color = findViewById(R.id.color);

        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String col = "#"+String.valueOf(color.getText());
                        if(col.length()<=7 && col.length()>=6) {
                            colors.add(col);
                            Toast.makeText(MainActivity.this, "Dodano: " + col + " kolor", Toast.LENGTH_SHORT).show();
                            color.setText("");
                        }
                        else
                            Toast.makeText(MainActivity.this, "Nie ma takiego koloru!", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        setBackground.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!colors.isEmpty()) {
                            String color = colors.get(new Random().nextInt(colors.size()));
                            findViewById(R.id.background).setBackgroundColor(Color.parseColor(color));
                        }
                        else
                            Toast.makeText(MainActivity.this, "Tablica jest pusta", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        nextPage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String col = color.getText().toString();
                        Intent intent = new Intent(view.getContext(), MainActivity2.class);

                        intent.putExtra("Color", col);
                        startActivity(intent);
                    }
                }
        );
    }

    /**
     * KONWERT ZMIENNYCH:
     * string to int => Integer.valueOf && Integer.parseInt
     * int to string => Integer.toString && String.valueOf
     */
}