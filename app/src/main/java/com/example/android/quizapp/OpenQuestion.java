package com.example.android.quizapp;

import android.widget.EditText;

class OpenQuestion extends Question {

    private String correctAnswer;
    private String givenAnswer = "";

    OpenQuestion(String question, String correctAnswer) {
        setQuestionContent(question);
        this.correctAnswer = correctAnswer;
    }

    void checkAnswer() {
        this.isChecked();
        setAnswerIsCorrect(correctAnswer.equals(givenAnswer));
    }

    void clearAnswer() {
        givenAnswer = "";
    }

    void getAnswer(EditText answer) {
        givenAnswer = answer.getText().toString();
    }

    private void isChecked() {
        setAnswered(!givenAnswer.isEmpty());
    }

}
