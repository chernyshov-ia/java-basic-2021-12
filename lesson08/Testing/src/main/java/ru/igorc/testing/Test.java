package ru.igorc.testing;

import java.util.List;

public class Test {
    final private List<? extends Question> questions;
    final private String memo;

    public Test(String memo, List<? extends Question> questions) {
        this.questions = questions;
        this.memo = memo;
    }

    public List<? extends Question> getQuestions() {
        return questions;
    }

    public String getMemo() {
        return memo;
    }
}
