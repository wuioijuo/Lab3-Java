package ru.Mylnikova.animals;

public abstract class Bird {
    private final String name;

    public Bird(String name) {
        this.name = name;
    }
    public String getName() { return name; }

    public abstract void sing();

    @Override
    public String toString() {
        return name;
    }
}