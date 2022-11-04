package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button randButon;
    Button correctAnswer;
    Button wrongAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randButon = findViewById(R.id.button10);
        TextView text = findViewById(R.id.random);

        correctAnswer = findViewById(R.id.button12);
        wrongAnswer = findViewById(R.id.button13);

        randButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer randNumber = (int)(Math.random()*100+1);
                text.setText(Integer.toString(randNumber));
                Toast.makeText(MainActivity.this, "Rand click",
                        Toast.LENGTH_SHORT).show();
            }
        });


        correctAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Correct answer!", Toast.LENGTH_SHORT).show();
                findViewById(R.id.button13).setVisibility(View.INVISIBLE);
            }
        });

        wrongAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Correct answer is visible!", Toast.LENGTH_SHORT).show();
                findViewById(R.id.button13).setVisibility(View.INVISIBLE);
            }
        });

    }

    public void lowerText(View view) {
        TextView text = findViewById(R.id.size);
        text.setTextSize(13);
    }

    public void greaterText(View view) {
        TextView text = findViewById(R.id.size);
        text.setTextSize(17);
    }

    public void changeTheBackground(View view) {
        Drawable color = view.getBackground();
        findViewById(R.id.bg).setBackground(color);
//        findViewById(R.id.linear1).setVisibility(View.INVISIBLE);
//        findViewById(R.id.linear2).setVisibility(View.INVISIBLE);
//        findViewById(R.id.linear3).setVisibility(View.INVISIBLE);
//        findViewById(R.id.size).setVisibility(View.INVISIBLE);
    }

//    Button greater;

//    public void GreaterSize(View view) {
//        greater = findViewById(R.id.button1);
//        greater.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "GREATER",
//                        Toast.LENGTH_SHORT).show();
//                text.setTextSize(20);
//            }
//        });
//    }

}