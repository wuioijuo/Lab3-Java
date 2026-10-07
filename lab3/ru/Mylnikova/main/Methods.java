package ru.Mylnikova.main;

import ru.Mylnikova.animals.Meowable;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Methods {

    // вызывает мяуканье у всех животных из массива
    public static void meowAll(Meowable[] animals) {
        for (Meowable a : animals) {
            a.meow();
        }
    }

    // возведение X в степень Y из строк
    public static double power(String x, String y) {
        return pow(parseInt(x), parseInt(y));
    }
}