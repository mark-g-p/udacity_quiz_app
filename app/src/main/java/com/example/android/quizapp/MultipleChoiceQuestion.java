package com.example.android.quizapp;


import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Marek on 2018-01-29.
 * Basic MultipleChoiceQuestion
 */

class MultipleChoiceQuestion extends Question {

    private ArrayList<Boolean> givenAnswers;
    private ArrayList<Boolean> correctAnswers;
    String[] possibleAnswers;

    MultipleChoiceQuestion(String question, ArrayList<Boolean> correctAnswersList, String[] answers) {
        setQuestionContent(question);
        possibleAnswers = answers;
        givenAnswers = new ArrayList<>(0);
        for (String ignored : possibleAnswers) {
            givenAnswers.add(false);
        }
        correctAnswers = correctAnswersList;
    }

    //   return false if givenAnswers are different than correctAnswers
    void checkAnswer() {
        this.isChecked();
        setAnswerIsCorrect(givenAnswers.equals(correctAnswers));
    }


    void getAnswers(LinearLayout answersCheckboxes) {
        for (int i = 0; i < answersCheckboxes.getChildCount(); i++) {
            CheckBox checkBox = (CheckBox) answersCheckboxes.getChildAt(i);
            givenAnswers.set(i, checkBox.isChecked());
        }
    }

    private void isChecked() {
        for (int i = 0; i < givenAnswers.size(); i++) {
            if (givenAnswers.get(i)) {
                setAnswered(true);
                return;
            }
        }
        setAnswered(false);
    }

    void uncheckAllAnswers() {
        for (int i = 0; i < givenAnswers.size(); i++) {
            givenAnswers.set(i, false);
        }
    }
}
