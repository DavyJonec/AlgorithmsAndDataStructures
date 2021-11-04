package ru.geekbrains.Homework2.ArraysAndSorting;

import lombok.Value;

import java.util.Random;

@Value
public class Characteristic implements Comparable<Characteristic> {
    Integer price;
    int memory;
    Manufacturer manufacturer;

    private static final Random random = new Random();


    public enum Manufacturer {
        LENUVO, ASOS, MACNOTE, ESER, XAMIOU
    }


    public static int price() {
        return (random.nextInt(19) * 50) + 500;
    }

    public static int memory() {
        return (random.nextInt(6) + 1) * 4;
    }



    @Override
    public int compareTo(Characteristic c) {
        int result = price.compareTo(c.getPrice());
        if (result == 0) {
            result = Integer.compare(memory, c.getMemory());
            if (result == 0) {
                return manufacturer.compareTo(c.getManufacturer());
            }
            return result;
        }
        return result;
    }
}
