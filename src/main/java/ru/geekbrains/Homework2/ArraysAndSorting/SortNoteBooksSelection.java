package ru.geekbrains.Homework2.ArraysAndSorting;


import java.util.Comparator;
import java.util.List;

public class SortNoteBooksSelection extends SelectionSort {
    public static List<Characteristic> sort(List<Characteristic> characteristics) {
        int min = 0;
        for (int i = 0; i < characteristics.size() - 1; i++) {
            min = i;

            for (int j = i + 1; j < characteristics.size(); j++) {
                if (characteristics.get(j).compareTo(characteristics.get(min)) < 0) {
                    min = j;
                }
            }
            if (i == min) {
                continue;
            }
            Characteristic temp = characteristics.get(i);
            characteristics.set(i, characteristics.get(min));
            characteristics.set(min, temp);
        }

        return characteristics;
    }

    public static void sortLight(List<Characteristic> characteristics) {
        Comparator<Characteristic> c = Comparator.comparing(Characteristic::getPrice)
                .thenComparing(Characteristic::getMemory)
                .thenComparing(Characteristic::getManufacturer);
        characteristics.sort(c);
    }
}

