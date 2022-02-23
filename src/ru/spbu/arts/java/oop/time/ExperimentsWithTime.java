package ru.spbu.arts.java.oop.time;

public class ExperimentsWithTime {
    public static void main(String[] args) {
        Time t = new Time(14, 5);
        Time t2 = new Time(23, 21);

        System.out.println(t.show());

        System.out.println(t.isDay());
        System.out.println(t.isMorning());
        System.out.println(t.isNight());
        System.out.println(t.isEvening());

        System.out.println(t.sayHello());
        System.out.println(t2.sayHello());

        t.add(20);
        t2.add(60);
        System.out.println(t.show());
        System.out.println(t2.show());
    }
}
