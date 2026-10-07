/*• Попугай. Имеет текст и умеет петь этот текст. При инициализации обязательно
необходимо указать текст, который будет исполняться. При пении текст выводится не
весь, а первые Nсимволов (не менее одного и не более всех символов текста), где N
определяется случайно.*/
package ru.Mylnikova.animals;

import java.util.Random;

public class Parrot extends Bird {
    private final String text;

    public Parrot(String name, String text) {
        super(name);
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст попугая не может быть пустым");
        }
        this.text = text;
    }

    @Override
    public void sing() {
        int n = new Random().nextInt(text.length()) + 1;
        System.out.println(text.substring(0, n));
    }
}
