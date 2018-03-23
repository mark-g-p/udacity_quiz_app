package com.example.android.quizapp;

class Question {


    private boolean answerIsCorrect = false;
    private String questionContent = "This is question placeholder";
    private boolean isAnswered = false;

    //      setters
    void setAnswerIsCorrect(boolean answerIsCorrect) {
        this.answerIsCorrect = answerIsCorrect;
    }

    void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    //    getters
    String getQuestionContent() {
        return questionContent;
    }


    boolean isAnswerIsCorrect() {
        return answerIsCorrect;
    }

    boolean isAnswered() {
        return isAnswered;
    }
}

