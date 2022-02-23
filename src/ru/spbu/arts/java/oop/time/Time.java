package ru.spbu.arts.java.oop.time;

public class Time {

    private int minute;
    private int hour;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public String show() {
        return String.format("%02d:%02d", hour, minute);
    }

    public boolean isNight() {
        return 0 <= hour & hour < 6;
    }

    public boolean isMorning() {
        return 6 <= hour & hour < 12;
    }

    public boolean isDay() {
        return 12 <= hour & hour < 18;
    }

    public boolean isEvening() {
        return 18 <= hour & hour < 24;
    }

    public String sayHello() {
        if (this.isNight())
            return "Доброй ночи";
        else if (this.isMorning())
            return "Доброе утро";
        else if (this.isDay())
            return "Добрый день";
        return "Добрый вечер";
    }

    public void add(int plus) {
        int updatedMin = minute + plus;
        minute = updatedMin % 60;
        hour = (hour + (updatedMin / 60)) % 24;
    }
}
