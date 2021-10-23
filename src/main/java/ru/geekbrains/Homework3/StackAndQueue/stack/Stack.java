package ru.geekbrains.Homework3.StackAndQueue.stack;

public interface Stack<E> {

    void push(E value);

    E pop();

    E peek(); //top()

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();

}