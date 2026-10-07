package ru.Mylnikova.animals;

public class Dog implements Meowable {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void meow() {
        System.out.println(name + " (собака): мяу-гав!");
    }

    @Override
    public String toString() {
        return "собака: " + name;
    }
}