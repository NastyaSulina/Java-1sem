class IntroTaskCat {
    public static void main(String[] args) {
        int cats = 1;
        String s = "котов";
        if (cats % 10 == 1 && cats % 100 != 11) {
            s = "кот";
        }
        else if (2 <= cats % 10 && cats % 10 <= 4 && cats % 100 / 10 != 1) {
            s = "кота";
        }
        System.out.println(cats + " " + s);
    }
}
