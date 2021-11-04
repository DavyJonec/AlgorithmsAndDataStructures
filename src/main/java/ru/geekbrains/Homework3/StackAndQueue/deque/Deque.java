package ru.geekbrains.Homework3.StackAndQueue.deque;

import ru.geekbrains.Homework3.StackAndQueue.queue.Queue;

public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();
}