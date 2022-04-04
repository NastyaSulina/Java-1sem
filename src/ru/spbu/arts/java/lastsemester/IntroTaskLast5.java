package ru.spbu.arts.java.lastsemester;

class IntroTaskLast5 {
    public static void main(String[] args) {
        int x = -425;
        if (Math.abs(x) % 10 == 5) {
            System.out.println("Оканчивается на 5");
        } else {
            System.out.println("Не оканчивается на 5");
        }
    }
}
