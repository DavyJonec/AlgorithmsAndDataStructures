package ru.geekbrains.Homework5.Recursion;

import java.util.ArrayList;
import java.util.List;

public class MainBackpack {
    public static void main(String[] args) {

    List<Item> items = new ArrayList<>();
        items.add(new Item("Book",   1, 600)); // +
        items.add(new Item("Knife", 2, 5000)); // +
        items.add(new Item("Bow", 4, 4500));  // -
        items.add(new Item("Supplies", 6, 8000)); // +
        items.add(new Item("Crossbow ", 3, 7500)); // -


    Backpack backpack = new Backpack(8);
        backpack.calcBestSet(items);

        for (Item item : backpack.getBestSet()) {
        System.out.println(item.getName() + " " + item.getPrice());
    }

        System.out.println("Total best price is " + backpack.getBestPrice());
}

}

