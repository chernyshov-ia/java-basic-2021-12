package ru.igorc.testing;

import java.util.ArrayList;
import java.util.List;

public class ConcreteTest extends Test {

    private static List<Question> createQuestions() {
        List<Question> questions = new ArrayList<>();
        List<Answer> answers;

        answers = new ArrayList<>();
        answers.add(new Answer("css", false));
        answers.add(new Answer("java", false));
        answers.add(new Answer("class", true));
        answers.add(new Answer("exe", false));
        questions.add( new Question("В файл с каким расширением компилируется java-файл?", answers) );

        answers = new ArrayList<>();
        answers.add(new Answer("commit", false));
        answers.add(new Answer("push", false));
        answers.add(new Answer("clone", true));
        answers.add(new Answer("copy", false));
        questions.add( new Question("С помощью какой команды git можно получить полную копию удаленного репозитория?", answers) );


        answers = new ArrayList<>();
        answers.add(new Answer("while", true));
        answers.add(new Answer("for", false));
        answers.add(new Answer("loop", false));
        questions.add( new Question("Какой применяется цикл, когда не известно количество итераций?", answers) );

        return questions;
    }

    public ConcreteTest() {
        super("Этот тест проверяет пройденный материал!", createQuestions() );
    }
}
