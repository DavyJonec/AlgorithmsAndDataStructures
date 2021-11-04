package ru.geekbrains.Homework8.HashTable;


import java.util.LinkedList;

public class HashTableImpl<K, V> implements HashTable<K, V> {


    static class Item<K, V> implements Entry<K, V> {


        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }

    }

    private final LinkedList<Item<K, V>>[] data;
    private final Item<K, V> emptyEntry;
    private int size;

    public HashTableImpl(int initialCapacity) {
        this.data = new LinkedList[initialCapacity];

        for (int i = 0; i < initialCapacity; i++) {
            data[i] = new LinkedList<>();
        }
        emptyEntry = new Item<>(null, null);
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        for (int i = 0; i < data[index].size(); i++) {
            if (isKeysEquals(data[index].get(i), key)) {
                data[index].get(i).setValue(value);
                return true;
            }
        }

        data[index].add(new Item<>(key, value));
        size++;
        return true;
    }


    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyEntry) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }


    private int hashFunc(K key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        for (int i = 0; i < data[index].size(); i++) {
            if (isKeysEquals(data[index].get(i), key)) {
                return data[index].get(i).getValue();
            }
        }

        return null;
    }

    private int indexOf(K key) {
        int index = hashFunc(key);

        for (int i = 0; i < data[index].size(); i++) {
            if (isKeysEquals(data[index].get(i), key)) {
                return index;
            }
        }
            return -1;
    }


    @Override
    public V remove(K key) {
        int index = indexOf(key);

        if (index == -1) {
            return null;
        }
        Item<K, V> temp = emptyEntry;

        for (int i = 0; i < data[index].size(); i++) {
            if(isKeysEquals(data[index].get(i),key)) {
                temp = data[index].get(i);
                data[index].remove(i);
                size--;
            }
        }

        return temp.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("--------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("--------------------------");
    }
}
