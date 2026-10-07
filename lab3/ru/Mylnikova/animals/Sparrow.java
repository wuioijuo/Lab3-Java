/*• Воробей. Умеет петь. При пении на экран выводится строка “чырык” */
package ru.Mylnikova.animals;

public class Sparrow extends Bird {

    public Sparrow(String name) {
        super(name);
    }

    @Override
    public void sing() {
        System.out.println("чырык");
    }
}