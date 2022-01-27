package ru.igorc.questions;

import java.util.Scanner;

public class App {

    public static String[] getQuestions() {
        return new String[]{
                "В файл с каким расширением компилируется java-файл?",
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                "Какой применяется цикл, когда не известно количество итераций?"
        };
    }

    public static String[][][] getAnswers() {
        return new String[][][]{
                {{"css", "N"}, {"java", "N"}, {"class", "Y"}, {"exe", "N"}},
                {{"commit", "N"}, {"push", "N"}, {"clone", "Y"}, {"copy", "N"}},
                {{"while", "Y"}, {"for", "N"}, {"loop", "N"}}
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = getQuestions();
        String[][][] answers = getAnswers();

        int rightAnswers = 0;
        int wrongAnswers = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (int j = 0; j < answers[i].length; j++) {
                System.out.format("  %d. %s\n", j + 1, answers[i][j][0]);
            }
            System.out.println();
            System.out.print("Введите ответ: ");

            boolean received;
            int response;
            do {

                try {
                    response = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    response = 0;
                }

                received = response >= 1 && response <= answers[i].length;
                if (received) {
                    if ("Y".equals(answers[i][response - 1][1])) {
                        System.out.println("Ответ правильный!");
                        rightAnswers++;
                    } else {
                        System.out.println("Ответ неправильный!");
                        wrongAnswers++;
                    }
                    System.out.println();
                } else {
                    System.out.println("Такого варианта ответа нет!");
                    System.out.print("Введите ответ: ");
                }
            } while (!received);
            System.out.println();
        }

        System.out.println("Правильных ответов: " + rightAnswers);
        System.out.println("Неправильных ответов: " + wrongAnswers);
    }

}
