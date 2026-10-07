/*• Кукушка. Умеет петь. При пении на экран выводится текст “ку-ку”, причем текст
выводится случайное количество раз в диапазоне от 1 до 10.*/
package ru.Mylnikova.animals;

import java.util.Random;

public class Cuckoo extends Bird {

    public Cuckoo(String name) {
        super(name);
    }

    @Override
    public void sing() {
        Random rnd = new Random();
        int n = rnd.nextInt(10) + 1;
        for (int i = 0; i < n; i++) {
            System.out.println("ку-ку");
        }
    }
}