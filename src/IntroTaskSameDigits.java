class IntroTaskSameDigits {
    public static void main(String[] args) {
        int x = 4255;
        if (x % 10 == (x / 10) % 10) {
            System.out.println("Верно");
        } else {
            System.out.println("Неверно");
        }
    }
}
