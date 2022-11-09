package com.example.apprevisinoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

                        if(isAnswerCorrect(questionsMain.get(currentIndex).getCorrectAnswer())){
                            totalScore++;
                            currentIndex++;

                            if(currentIndex == questionsMain.size()) {
//                                currentIndex = 0;
//                                Toast.makeText(MainActivity.this, "Liczba puntkow: " + Integer.valueOf(totalScore), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                                intent.putExtra("score", totalScore);
                                intent.putExtra("totalQuestions", questionsMain.size());
                                startActivity(intent);
                            }
                            fillViewWithQuestions(currentIndex);
                        }
//                        else {
//                            Toast.makeText(MainActivity.this, "zla odpowiedz", Toast.LENGTH_SHORT).show();
//                            currentIndex++;
//                            if(currentIndex == questionsMain.size()) {
//                                currentIndex = 0;
//                                Toast.makeText(MainActivity.this, "Liczba puntkow: " + Integer.valueOf(totalScore), Toast.LENGTH_SHORT).show();
//                                toResultActivity();
//                                Toast.makeText(MainActivity.this, "koniec", Toast.LENGTH_SHORT).show();

//                            }
                        }
                }
        );

        tip.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, TipActivity.class);
                        intent.putExtra("index", currentIndex);
                        int requestCode = 0;
                        startActivityForResult(intent, requestCode);
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0) {
            totalScore--;
        }
    }

    /**
     * RESETOWANIE APLIKACJI:
     * - finish()
     * - startActivity(getIntent())
     */

    private boolean isAnswerCorrect(int answerNumber) {
        RadioButton[] radioButtons = new RadioButton[]{answerA, answerB, answerC, answerD};
        for(int i=0; i<radioButtons.length; i++) {
            if(radioButtons[i].isChecked()) {
                if(i == answerNumber) {
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
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

    private void fillViewWithQuestions(int currentIndex) {
        Question currentQuestion = questionsMain.get(currentIndex);
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