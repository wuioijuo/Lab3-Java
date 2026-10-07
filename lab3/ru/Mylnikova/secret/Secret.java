package ru.Mylnikova.secret;

import java.util.Random;

public class Secret {
    private final String text;
    private final String keeperName;
    private final Secret previous;
    private Secret next;

    public Secret(String keeperName, String text) {
        this.keeperName = keeperName;
        this.text = text;
        this.previous = null;
        System.out.println("Создан секрет: " + keeperName + " знает: " + text);
    }

    public Secret(Secret other, String keeperName) {
        if (other == null) {
            throw new IllegalArgumentException("Секрет не может быть null");
        }
        if (other.next != null) {
            throw new IllegalStateException("Секрет уже рассказан другому человеку");
        }

        this.keeperName = keeperName;
        this.previous = other;

        System.out.println(other.keeperName + " сказал что " + other.text);

        String newText = other.text;
        int max = other.text.length() / 10;
        int count = new Random().nextInt(max + 1);
        String alphabet = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int position = random.nextInt(newText.length() + 1);
            char symbol = alphabet.charAt(random.nextInt(alphabet.length()));
            newText = newText.substring(0, position) + symbol + newText.substring(position);
        }

        this.text = newText;
        other.next = this;
    }

    public int order() {
        int order = 1;
        Secret current = this;
        while (current.previous != null) {
            current = current.previous;
            order++;
        }
        return order;
    }

    public int afterCount() {
        int count = 0;
        Secret current = this;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public String nameOf(int n) {
        return relative(n).keeperName;
    }

    public int diffWith(int n) {
        return Math.abs(text.length() - relative(n).text.length());
    }

    private Secret relative(int n) {
        Secret current = this;

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                if (current.next == null) {
                    throw new IllegalArgumentException("Нет такого хранителя");
                }
                current = current.next;
            }
        }

        if (n < 0) {
            for (int i = 0; i < -n; i++) {
                if (current.previous == null) {
                    throw new IllegalArgumentException("Нет такого хранителя");
                }
                current = current.previous;
            }
        }

        return current;
    }

    @Override
    public String toString() {
        return keeperName + ": это секрет!";
    }
}
