package ru.Mylnikova.main;

import ru.Mylnikova.animals.Bird;
import ru.Mylnikova.animals.Cat;
import ru.Mylnikova.animals.Cuckoo;
import ru.Mylnikova.animals.Dog;
import ru.Mylnikova.animals.Meowable;
import ru.Mylnikova.animals.Parrot;
import ru.Mylnikova.animals.Sparrow;
import ru.Mylnikova.geometry.Point;
import ru.Mylnikova.geometry.Point3D;
import ru.Mylnikova.people.Human46;
import ru.Mylnikova.people.Name45;
import ru.Mylnikova.secret.Secret;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Задача 1.7: Непустые имена ===");
        Name45 name1 = new Name45("Клеопатра");
        Name45 name2 = new Name45("Александр", "Сергеевич", "Пушкин");
        System.out.println(name1);
        System.out.println(name2);

        try {
            new Name45("", null, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Задача 1.8: Человек меняется ===");
        Human46 lev = new Human46("Лев", 170);
        Human46 sergey = new Human46(new Name45("Сергей", "Пушкин"), 168, lev);
        Human46 alexander = new Human46("Александр", 167, sergey);

        System.out.println(lev);
        System.out.println(sergey);
        System.out.println(alexander);

        lev.setHeight(175);
        System.out.println("После изменения роста: " + lev);
        System.out.println("Отец Сергея: " + sergey.getFather());
        System.out.println("Имя Александра: " + alexander.getName());

        try {
            lev.setHeight(600);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Задача 2.2: Секреты ===");
        Secret secret1 = new Secret("Иван", "Меня зовут Иван Петрович");
        Secret secret2 = new Secret(secret1, "Пётр");
        Secret secret3 = new Secret(secret2, "Сергей");

        System.out.println(secret1);
        System.out.println(secret2);
        System.out.println(secret3);
        System.out.println("Иван был хранителем №" + secret1.order());
        System.out.println("Сергей был хранителем №" + secret3.order());
        System.out.println("После Ивана секрет узнали: " + secret1.afterCount());
        System.out.println("Следующий после Ивана: " + secret1.nameOf(1));
        System.out.println("Предыдущий перед Сергеем: " + secret3.nameOf(-1));
        System.out.println("Разница в длине секрета: " + secret3.diffWith(-2));

        try {
            new Secret(secret1, "Николай");
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Задача 3.5: Трёхмерная точка ===");
        Point3D point3D = new Point3D(1, 2, 3);
        System.out.println(point3D);
        point3D.setZ(10);
        System.out.println(point3D);

        System.out.println("\n=== Задача 4.3: Птицы ===");
        Bird[] birds = {
            new Sparrow("Воробей"),
            new Cuckoo("Кукушка"),
            new Parrot("Попугай", "Привет, я говорящий попугай")
        };

        for (Bird bird : birds) {
            System.out.print(bird + ": ");
            bird.sing();
        }

        System.out.println("\n=== Задача 5.4: Мяуканье ===");
        Cat barsik = new Cat("Барсик");
        Cat murka = new Cat("Мурка");
        Cat pufik = new Cat("Пуфик");
        Meowable[] animals = {
            barsik,
            murka,
            pufik,
            new Dog("Шарик")
        };
        Methods.meowAll(animals);

        System.out.println("\n=== Задача 6.2: Сравнение точек ===");
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(3, 4);
        System.out.println(point1.equals(point2));
        System.out.println(point1.equals(point3));

        System.out.println("\n=== Задача 7.3: Возведение в степень ===");
        String x = "2";
        String y = "10";
        System.out.println(x + "^" + y + " = " + Methods.power(x, y));

        System.out.println("\n=== Задача 8.4: Клонирование точки ===");
        Point original = new Point(5, 7);
        Point copy = original.clone();
        System.out.println("Оригинал: " + original);
        System.out.println("Копия: " + copy);
        System.out.println("Равны: " + original.equals(copy));
        System.out.println("Один объект: " + (original == copy));

        copy.setX(100);
        System.out.println("После изменения копии:");
        System.out.println("Оригинал: " + original);
        System.out.println("Копия: " + copy);
    }
}