package ru.geekbrains.Homework5.Recursion;

public class Exponentiation {
    public static void main(String[] args) {
        System.out.println(exponentiation(5, 3));
        System.out.println(exponentiation(4, -2));
        System.out.println(exponentiation(1.5, 0));
        System.out.println(exponentiation(1.5, 2));
    }

    private static double exponentiation(double number, int degree) {
        if (number == 0) {
            if (degree > 0) {
                return 0;
            } else {
                throw new IllegalArgumentException("Zero cannot be raised to a power ");
            }
        }
        if (degree < 0) {
            return 1 / (number * exponentiation(number, -degree - 1));
        } else if (degree > 0) {
            return number * exponentiation(number, degree - 1);
        } else {
            return 1;
        }
    }
}

