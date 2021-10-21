package ru.geekbrains.Homework4.LinkedLists.deque;

import ru.geekbrains.Homework4.LinkedLists.queue.Queue;

public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();
}