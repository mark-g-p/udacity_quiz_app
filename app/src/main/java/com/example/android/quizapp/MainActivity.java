package com.example.android.quizapp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    SingleChoiceQuestion question1;
    SingleChoiceQuestion question2;
    MultipleChoiceQuestion question3;
    OpenQuestion question4;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // question 1

        question1 = new SingleChoiceQuestion(
                getString(R.string.question_1_content),
                1,
                getResources().getStringArray(R.array.question_1_answers));

        binding.question1Content.setText(question1.getQuestionContent());
        for (int i = 0; i < binding.question1Answers.getChildCount(); i++) {
            RadioButton button = (RadioButton) binding.question1Answers.getChildAt(i);
            button.setText(question1.possibleAnswers[i]);
        }
        //question 2

        question2 = new SingleChoiceQuestion(
                getString(R.string.question_2_content),
                2,
                getResources().getStringArray(R.array.question_2_answers));

        binding.question2Content.setText(question2.getQuestionContent());
        for (int i = 0; i < binding.question2Answers.getChildCount(); i++) {
            RadioButton button = (RadioButton) binding.question2Answers.getChildAt(i);
            button.setText(question2.possibleAnswers[i]);
        }

        //question 3

        question3 = new MultipleChoiceQuestion(
                getString(R.string.question_3_content),
                new ArrayList<>(Arrays.asList(true, true, true, false)),
                getResources().getStringArray(R.array.question_3_answers));

        binding.question3Content.setText(question3.getQuestionContent());
        for (int i = 0; i < binding.question3Answers.getChildCount(); i++) {
            CheckBox button = (CheckBox) binding.question3Answers.getChildAt(i);
            button.setText(question3.possibleAnswers[i]);
        }
        //question 4

        question4 = new OpenQuestion(getString(R.string.question_4_content),
                getString(R.string.question_4_answer));

        binding.question4Content.setText(R.string.question_4_content);

        // focus on first question
        binding.question1.requestFocus();

    }

    public void submitAnswers(View view) {

        question1.getAnswers(binding.question1Answers);
        question2.getAnswers(binding.question2Answers);
        question3.getAnswers(binding.question3Answers);
        question4.getAnswer(binding.question4Answer);
        question1.checkAnswer();
        question2.checkAnswer();
        question3.checkAnswer();
        question4.checkAnswer();


        if (question1.isAnswered() &&
                question2.isAnswered() &&
                question3.isAnswered() &&
                question4.isAnswered()) {
            // check which answers are correct.
            ArrayList<Boolean> answers = new ArrayList<>();
            answers.add(question1.isAnswerIsCorrect());
            answers.add(question2.isAnswerIsCorrect());
            answers.add(question3.isAnswerIsCorrect());
            answers.add(question4.isAnswerIsCorrect());

            // calculate score
            int score = 0;
            for (Boolean d : answers)
                score += d ? 1 : 0;
            // print toast with quiz score
            Context context = getApplicationContext();

            Toast toast = Toast.makeText(context,
                    getString(R.string.congratulations_toast, score, answers.size()),
                    Toast.LENGTH_LONG);
            TextView v = toast.getView().findViewById(android.R.id.message);
            if (v != null) v.setGravity(Gravity.CENTER);
            toast.show();
        } else {
            Context context = getApplicationContext();

            Toast toast = Toast.makeText(context, R.string.all_questions, Toast.LENGTH_SHORT);
            TextView v = toast.getView().findViewById(android.R.id.message);
            if (v != null) v.setGravity(Gravity.CENTER);
            toast.show();
        }
    }

    public void resetScore(View view) {
        question1.uncheckAnswer();
        question2.uncheckAnswer();
        question3.uncheckAllAnswers();
        question4.clearAnswer();

    }

}

