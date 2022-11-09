package com.example.apprevisinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TipActivity extends AppCompatActivity {

    TextView contentOfTip;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        contentOfTip = findViewById(R.id.contentOfTip);
        backButton = findViewById(R.id.backToQuestion);

        int currentIndex = getIntent().getIntExtra("index", 0);
        Toast.makeText(this, String.valueOf(currentIndex), Toast.LENGTH_SHORT).show();

        ArrayList<Question> questionsTip = Question.questions;
        contentOfTip.setText(questionsTip.get(currentIndex).getTipForAnswer());

        backButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
        );
    }
}