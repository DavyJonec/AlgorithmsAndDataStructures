package ru.geekbrains.Homework2.ArraysAndSorting;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Laptops {
    private static final int COUNT = 10000;

    public static void main(String[] args) {
        List<Characteristic> characteristics = generationLaptops();

        long timeStart = System.currentTimeMillis();

        SortNoteBooksSelection.sortLight(characteristics);
     //   characteristics = SortNoteBooksSelection.sort(characteristics);

        long timeEnd = System.currentTimeMillis();

        infoLaptops(characteristics);

        System.out.printf("Затрачено времени: %dms", timeEnd-timeStart);
    }

    private static void infoLaptops(List<Characteristic> list) {
        for (Characteristic c : list) {
            System.out.printf("Ноутбук, цена: %s, память: %s, производитель: %s\n", c.getPrice(), c.getMemory(), c.getManufacturer());

        }
    }

    private static ArrayList<Characteristic> generationLaptops() {
        ArrayList<Characteristic> arrayList = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            arrayList.add(createLaptops());
        }
        return arrayList;
    }

    private static Characteristic createLaptops() {
        Random random = new Random();
        int price = Characteristic.price();
        int memory = Characteristic.memory();
        int manufacturerCount = Characteristic.Manufacturer.values().length;
        Characteristic.Manufacturer manufacturer = Characteristic.Manufacturer.values()[random.nextInt(manufacturerCount)];
        return new Characteristic(price, memory, manufacturer);
    }


}
