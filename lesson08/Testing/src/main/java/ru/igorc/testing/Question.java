package ru.igorc.testing;

import java.util.List;

public class Question {
    final private String text;
    final private List<? extends Answer> answers;

    public Question(String text, List<? extends Answer> answers) {
        this.text = text;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public List<? extends Answer> getAnswers() {
        return answers;
    }
}
