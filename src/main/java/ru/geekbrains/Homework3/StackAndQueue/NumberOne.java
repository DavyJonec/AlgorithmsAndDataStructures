package ru.geekbrains.Homework3.StackAndQueue;

public class NumberOne {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,11,12,13,14,15};
        MissingNumber(arr);

    }

    public static int search(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            int index = (startIndex + endIndex) / 2;
            if (arr[index] - index == 1) {
                startIndex = index + 1;
            } else {
                endIndex = index - 1;
            }
        }
        return startIndex + 1;
    }

    public static void MissingNumber(int[] arr) {
        System.out.printf("The missing number turned out to be: %d", search(arr));
    }
}