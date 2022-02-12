package ru.igorc.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class App {
    public final static int SIZE = 30000;

    public static List<Integer> generateList(int size) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(ThreadLocalRandom.current().nextInt(size));
        }
        return list;
    }

    /**
     * Тупая сортировка выбором
     */
    public static void sort_selection(List<Integer> list) {
        if (list.size() < 2) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    public static void sortTest(List<Integer> list, Consumer<List<Integer>> func, String hello) {
        List<Integer> testList = new ArrayList<>(list);
        System.out.println("--------------------------------------------------");
        if (hello != null) {
            System.out.println(hello);
        }
        Date now = new Date();
        func.accept(testList);
        long time = new Date().getTime() - now.getTime();
        System.out.println("Затраченное время на сортировку: " + time + " ms");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list = generateList(SIZE);
        sortTest(list, App::sort_selection, "Сортировка выбором");
        sortTest(list, Collections::sort, "Сортировка Collections.sort");
    }
}
