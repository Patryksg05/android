package com.example.formlittleproject;

import java.util.ArrayList;

public class Question {
    private int content;
    private int idPhoto;
    private ArrayList<Integer> answerForQuestion = new ArrayList<Integer>();
    private int correctAnswer;
    private int hint;

    public static ArrayList<Question> questions = new ArrayList<Question>();

    public Question(int content, int idPhoto, int correctAnswer, int hint, int a, int b, int c, int d) {
        this.content = content;
        this.idPhoto = idPhoto;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
        this.answerForQuestion.add(a);
        this.answerForQuestion.add(b);
        this.answerForQuestion.add(c);
        this.answerForQuestion.add(d);
    }

    public static void createQuestion() {
        questions.add(new Question(R.string.question1, R.drawable.andoird_studio_logo,0,
                R.string.description1, R.string.question1answerA, R.string.question1answerB, R.string.question1answerC, R.string.question1answerD));
        questions.add(new Question(R.string.question2, R.drawable.question_two_image,1,
                R.string.description2, R.string.question2answerB, R.string.question2answerA, R.string.question2answerC, R.string.question2answerD));
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public ArrayList<Integer> getAnswerForQuestion() {
        return answerForQuestion;
    }

    public void setAnswerForQuestion(ArrayList<Integer> answerForQuestion) {
        this.answerForQuestion = answerForQuestion;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getHint() {
        return hint;
    }

    public void setHint(int hint) {
        this.hint = hint;
    }

    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    public static void setQuestions(ArrayList<Question> questions) {
        Question.questions = questions;
    }
}
