package ru.igorc.testing;

import java.util.Scanner;

public class TestRunner {
    private static Scanner scanner = new Scanner(System.in);

    private static int readAnswerFromConsole(int maxAnswerNumber) {
        System.out.print("Введите ответ: ");

        int response;
        boolean received;

        do {
            try {
                response = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                response = 0;
            }
            received = response >= 1 && response <= maxAnswerNumber;

            if (!received) {
                System.out.println("Такого варианта ответа нет!");
                System.out.print("Введите ответ: ");
            }

        } while (!received);

        return response;
    }

    private static boolean askQuestion(Question question) {
        System.out.println(question.getText());

        int response;
        for (int i = 0; i < question.getAnswers().size(); i++) {
            System.out.format("  %d. %s\n", i + 1, question.getAnswers().get(i).getText());
        }

        System.out.println();

        response = readAnswerFromConsole(question.getAnswers().size());

        boolean isRight = response > 0 && response <= question.getAnswers().size() && question.getAnswers().get(response - 1).isRight();

        if (isRight) {
            System.out.println("Ответ правильный!");
        } else {
            System.out.println("Ответ неправильный!");
        }

        System.out.println();

        return isRight;
    }

    public static void Run(Test test) {
        int rightAnswers = 0;
        int wrongAnswers = 0;

        System.out.println(test.getMemo());
        System.out.println();

        for (Question question : test.getQuestions()) {
            if (askQuestion(question)) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
        }

        System.out.println("Правильных ответов: " + rightAnswers);
        System.out.println("Неправильных ответов: " + wrongAnswers);
    }
}
