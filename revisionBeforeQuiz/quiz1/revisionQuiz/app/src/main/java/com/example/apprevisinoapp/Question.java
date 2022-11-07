package com.example.apprevisinoapp;

import java.util.ArrayList;

public class Question {
    private int content;
    private int idImage;
    private ArrayList<Integer> answers = new ArrayList<>();
    private int correctAnswer;
    private int tipForAnswer;

    public static ArrayList<Question> questions = new ArrayList<Question>();

    public Question(int content, int idImage, int a, int b, int c, int d, int correctAnswer, int tipForAnswer) {
        this.content = content;
        this.idImage = idImage;
        this.answers.add(a);
        this.answers.add(b);
        this.answers.add(c);
        this.answers.add(d);
        this.correctAnswer = correctAnswer;
        this.tipForAnswer = tipForAnswer;
    }

    public static void createQuestion() {
        questions.add(new Question(R.string.question1, R.drawable.pingwiny_z_madagaskaru, R.string.question1_answerA, R.string.question1_answerB,
                R.string.question1_answerC, R.string.question1_answerD, 0, R.string.question1_tip));
        questions.add(new Question(R.string.question2, R.drawable.kung_fu_panda, R.string.question2_answerA, R.string.question2_answerB,
                R.string.question2_answerC, R.string.question2_answerD, 3, R.string.question1_tip));
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public ArrayList<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Integer> answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getTipForAnswer() {
        return tipForAnswer;
    }

    public void setTipForAnswer(int tipForAnswer) {
        this.tipForAnswer = tipForAnswer;
    }
}
