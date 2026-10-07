package ru.Mylnikova.animals;

public class Cat implements Meowable {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public void meow(int n) {
        String result = name + ": ";
        for (int i = 0; i < n; i++) {
            if (i > 0) result = result + "-";
            result = result + "мяу";
        }
        result = result + "!";
        System.out.println(result);
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}