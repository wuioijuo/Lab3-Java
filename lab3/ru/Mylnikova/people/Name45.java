package ru.Mylnikova.people;

public class Name45 {
    private final String firstName;
    private final String patronymic;
    private final String surname;

    public Name45(String firstName) {
        this(firstName, null, null);
    }

    public Name45(String firstName, String surname) {
        this(firstName, null, surname);
    }

    public Name45(String firstName, String patronymic, String surname) {
        if (isBlank(firstName) && isBlank(patronymic) && isBlank(surname)) {
            throw new IllegalArgumentException("Хотя бы один параметр имени должен быть заполнен");
        }
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surname = surname;
    }

    private static boolean isBlank(String value) {
        return value == null || value.isEmpty();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        String result = "";

        if (!isBlank(firstName)) {
            result = firstName;
        }
        if (!isBlank(patronymic)) {
            if (!result.isEmpty()) result += " ";
            result += patronymic;
        }
        if (!isBlank(surname)) {
            if (!result.isEmpty()) result += " ";
            result += surname;
        }

        return result;
    }
}
