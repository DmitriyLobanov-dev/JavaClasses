package Homework14.Task2;

import java.util.Objects;

public class DepartureTime implements Comparable<DepartureTime>{

    private int hours;
    private int minutes;

    public DepartureTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartureTime that = (DepartureTime) o;
        return hours == that.hours &&
                minutes == that.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }

    @Override
    public String toString() {
        return "DepartureTime{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }

    @Override
    public int compareTo(DepartureTime o) {
        if (this.getHours() == o.getHours()) {
            return this.getMinutes() - o.getMinutes();
        } else {
            return this.getHours() - o.getHours();
        }
    }
}
