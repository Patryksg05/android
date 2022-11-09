package com.example.apprevisinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    TextView userPoints, maxPoints, randomButton;
    Button oneMoreTime;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        userPoints = findViewById(R.id.points);
        maxPoints = findViewById(R.id.possiblePoints);
        oneMoreTime = findViewById(R.id.oneMoreTimeButton);
        randomButton = findViewById(R.id.randomButton);
        textView = findViewById(R.id.randomText);

        String score = String.valueOf(getIntent().getIntExtra("score", 0));
        String max = String.valueOf(getIntent().getIntExtra("totalQuestions", 0));
        userPoints.setText(score);
        maxPoints.setText(max);

        oneMoreTime.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

        randomButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer randomNumber = (int)(Math.random()*100+1);
                        textView.setText(Integer.toString(randomNumber));
                    }
                }
        );
    }
}