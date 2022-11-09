package com.example.formlittleproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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

    ImageView hintForAnswer, logoImage;
    Button nextQuestion;
    TextView questionContent, numberOfQuestion;
//    RadioGroup radioGroup;
    RadioButton radioA, radioB, radioC, radioD;

    ArrayList<Question> questions = new ArrayList<Question>();
    int totalScore = 0;
    int currentQuestion = 0;
    int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary)));

        hintForAnswer = findViewById(R.id.lamp_logo);
        nextQuestion = findViewById(R.id.nextQuestion);
        numberOfQuestion = findViewById(R.id.numberOfQuestion);
        questionContent = findViewById(R.id.contentOfQuestion);
        logoImage = findViewById(R.id.imageLogo);
        radioA = findViewById(R.id.answerA);
        radioB = findViewById(R.id.answerB);
        radioC = findViewById(R.id.answerC);
        radioD = findViewById(R.id.answerD);

        Question.createQuestion();
        questions = Question.questions;
        fillViewWithQuestion(currentQuestion);

        nextQuestion.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(checkTheCorrectAnswer(questions.get(currentQuestion).getCorrectAnswer())) {
                            currentQuestion++;
                            totalScore+=2;
                            numberOfQuestion.setText("Pytanie " + ++num);
                            if(currentQuestion == questions.size()) {
                                Toast.makeText(MainActivity.this, "Zdobyto " + totalScore, Toast.LENGTH_SHORT).show();
                                currentQuestion--;
                                toScore();
                            }
//                            Toast.makeText(MainActivity.this, totalScore, Toast.LENGTH_SHORT).show();
                            fillViewWithQuestion(currentQuestion);
                        }
                        else {
                            currentQuestion++;
                            numberOfQuestion.setText("Pytanie " + ++num);
                            if(currentQuestion == questions.size()) {
                                Toast.makeText(MainActivity.this, "Zdobyto " + totalScore, Toast.LENGTH_SHORT).show();
                                currentQuestion--;
                                toScore();
                            }
//                            Toast.makeText(MainActivity.this, totalScore, Toast.LENGTH_SHORT).show();
                            fillViewWithQuestion(currentQuestion);
                        }
                     }
                }
        );

        hintForAnswer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, HintActivity.class);
                        intent.putExtra("index", currentQuestion);
                        totalScore--;
                        int requestCode = 0;
                        startActivityForResult(intent, requestCode);
                    }
                }
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK ){
            totalScore--;
        }
    }

    private boolean checkTheCorrectAnswer(int answerNumber) {
        RadioButton[] radioButtons = new RadioButton[]{radioA, radioB, radioC, radioD};
        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].isChecked()) {
                if (i == answerNumber) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    private void toScore() {
        Intent toScoreIntent = new Intent(MainActivity.this, ResultActivity.class);
        toScoreIntent.putExtra("score", Integer.toString(num));
        startActivity(toScoreIntent);
    }

    private void setCheckedRadioButton() {
        radioA.setChecked(false);
        radioB.setChecked(false);
        radioC.setChecked(false);
        radioD.setChecked(false);
    }

    // i => currentIndex
    void fillViewWithQuestion(int i) {
        Question currentQuestion = questions.get(i);
        questionContent.setText(currentQuestion.getContent());
        logoImage.setImageResource(currentQuestion.getIdPhoto());
        radioA.setText(currentQuestion.getAnswerForQuestion().get(0));
        radioB.setText(currentQuestion.getAnswerForQuestion().get(1));
        radioC.setText(currentQuestion.getAnswerForQuestion().get(2));
        radioD.setText(currentQuestion.getAnswerForQuestion().get(3));
        setCheckedRadioButton();
    }
}