package ru.spbu.arts.java.lastsemester;

class IntroTaskLeap {
    public static void main(String[] args) {
        int year = 2100;
        boolean b = year % 400 == 0;
        if (year % 100 != 0 && year % 4 == 0) {
            b = true;
        }
        if (b) {
            System.out.println(year + " " + "- это високосный год");
        } else {
            System.out.println(year + " " + "- это не високосный год");
        }
    }
}
