package com.example.apprevisinoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ipsec.ike.TunnelModeChildSessionParams;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView contentOfQuestion;
    ImageView mainImage;
    Button answer, tip;
    RadioGroup radioGroupElement;
    RadioButton answerA, answerB, answerC, answerD;

    ArrayList<Question> questionsMain = new ArrayList<Question>();
    int totalScore = 0, currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentOfQuestion = findViewById(R.id.contentQuestion);
        mainImage = findViewById(R.id.mainImage);
        answer = findViewById(R.id.answer);
        tip = findViewById(R.id.tip);
        radioGroupElement = findViewById(R.id.radioGroup);
        answerA = findViewById(R.id.radioButton);
        answerB = findViewById(R.id.radioButton2);
        answerC = findViewById(R.id.radioButton3);
        answerD = findViewById(R.id.radioButton4);

        Question.createQuestion();
        questionsMain = Question.questions; // because questions in the another file is the static function as like the array
        // so we use the static to this varaiable are visible for another file :DD
        fillViewWithQuestions(currentIndex);

        answer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentIndex++;

                        if(checkTheCorrectAnswer()) {
                            Toast.makeText(MainActivity.this, "Prawidlowa odpowiedz!", Toast.LENGTH_SHORT).show();
                        }

                        if(currentIndex == questionsMain.size()) {
                            currentIndex = 0;
                        }
                        fillViewWithQuestions(currentIndex);
                    }
                }
        );
    }

    public boolean checkTheCorrectAnswer() {
        radioGroupElement = findViewById(R.id.radioGroup);
        int radioId = radioGroupElement.getCheckedRadioButtonId();

        if(radioId == R.id.radioButton) {
            return true;
        }
        else
            return false;
    }

    public void fillViewWithQuestions(int index) {
        Question currentQuestion = questionsMain.get(index);
        contentOfQuestion.setText(currentQuestion.getContent());
        mainImage.setImageResource(currentQuestion.getIdImage());
        answerA.setText(currentQuestion.getAnswers().get(0));
        answerB.setText(currentQuestion.getAnswers().get(1));
        answerC.setText(currentQuestion.getAnswers().get(2));
        answerD.setText(currentQuestion.getAnswers().get(3));
        setUnchecked();
    }

    private void setUnchecked() {
        answerA.setChecked(false);
        answerB.setChecked(false);
        answerC.setChecked(false);
        answerD.setChecked(false);
    }
}