package com.example.android.quizapp;

import android.widget.RadioGroup;

class SingleChoiceQuestion extends Question {
    private int givenAnswer;
    private int correctAnswer;
    String[] possibleAnswers;

    SingleChoiceQuestion(String question, int correctAnswer, String[] answers) {
        setQuestionContent(question);
        possibleAnswers = answers;
        givenAnswer = -1;
        this.correctAnswer = correctAnswer;
    }

    void checkAnswer() {
        this.isChecked();
        setAnswerIsCorrect(correctAnswer == givenAnswer);
    }

    void getAnswers(RadioGroup answersRadioGroup) {
        givenAnswer = answersRadioGroup.indexOfChild(
                answersRadioGroup.findViewById(answersRadioGroup.getCheckedRadioButtonId())
        );
    }

    void uncheckAnswer() {
        givenAnswer = -1;
    }

    private void isChecked() {
        setAnswered(givenAnswer != -1);
    }

}
