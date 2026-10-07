/*Сравнение точек.
Измените сущность Точка из задачи 1.4.1. Переопределите метод сравнения объектов по
состоянию таким образом, чтобы две точки считались одинаковыми тогда, когда они
расположены в одинаковых координатах.*/
package ru.Mylnikova.geometry;

public class Point implements Cloneable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public Point clone() {
        return new Point(x, y);
    }
}
