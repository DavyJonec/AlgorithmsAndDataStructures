package ru.geekbrains.Homework4.LinkedLists;

public interface TwoSideLinkedList<E>  extends LinkedList<E> {
    void insertLast(E value);
    E getLast();
}
