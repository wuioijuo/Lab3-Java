package ru.Mylnikova.people;

public class Human46 {
    private final Name45 name;
    private int height;
    private final Human46 father;

    public Human46(Name45 name, int height, Human46 father) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть null");
        }
        this.name = completeName(name, father);
        this.height = checkHeight(height);
        this.father = father;
    }

    public Human46(String firstName, int height) {
        this(new Name45(firstName), height, null);
    }

    public Human46(String firstName, int height, Human46 father) {
        this(new Name45(firstName), height, father);
    }

    public Human46(Name45 name, int height) {
        this(name, height, null);
    }

    private static int checkHeight(int height) {
        if (height <= 0 || height > 500) {
            throw new IllegalArgumentException("Рост должен быть от 1 до 500");
        }
        return height;
    }

    private static Name45 completeName(Name45 name, Human46 father) {
        if (father == null) {
            return name;
        }

        String firstName = name.getFirstName();
        String patronymic = name.getPatronymic();
        String surname = name.getSurname();

        if (isBlank(surname)) {
            surname = father.getName().getSurname();
        }

        String fatherName = father.getName().getFirstName();
        if (isBlank(patronymic) && !isBlank(fatherName)) {
            patronymic = makePatronymic(fatherName);
        }

        return new Name45(firstName, patronymic, surname);
    }

    private static boolean isBlank(String value) {
        return value == null || value.isEmpty();
    }

    private static String makePatronymic(String fatherName) {
        if (fatherName.equals("Лев")) return "Львович";
        if (fatherName.equals("Павел")) return "Павлович";
        if (fatherName.equals("Яков")) return "Яковлевич";

        char last = fatherName.charAt(fatherName.length() - 1);
        if (last == 'й' || last == 'ь') {
            return fatherName.substring(0, fatherName.length() - 1) + "евич";
        }
        if (last == 'а' || last == 'я') {
            return fatherName.substring(0, fatherName.length() - 1) + "ич";
        }
        return fatherName + "ович";
    }

    public Name45 getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = checkHeight(height);
    }

    public Human46 getFather() {
        return father;
    }

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}
