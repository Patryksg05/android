package com.example.formlittleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HintActivity extends AppCompatActivity {

    Button hintButton, backButton, rejectHint;
    TextView hint, questionNumber;

    int totalQuestion = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        int currentQuestion = getIntent().getIntExtra("index", 0);
        Toast.makeText(this, Integer.toString(currentQuestion), Toast.LENGTH_SHORT).show();

        ArrayList<Question> questions = Question.questions;

        hintButton = findViewById(R.id.forSure);
        hint = findViewById(R.id.hintForQuestion);
        backButton = findViewById(R.id.backButton);
        rejectHint = findViewById(R.id.rejectHint);
        questionNumber = findViewById(R.id.questionNumber);

        hint.setText(questions.get(currentQuestion).getHint());
        questionNumber.setText(Integer.toString(++currentQuestion));

        hintButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        hint.setVisibility(View.VISIBLE);
                        hintButton.setVisibility(View.INVISIBLE);
                        rejectHint.setVisibility(View.INVISIBLE);
                        backButton.setVisibility(View.VISIBLE);
                    }
                }
        );

        rejectHint.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
        );

        backButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rejectHint.setVisibility(View.VISIBLE);
                        Intent intent = new Intent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
        );

    }
}