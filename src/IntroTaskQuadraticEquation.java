class IntroTaskQuadraticEquation {
    public static void main(String[] args) {
        double a = 4, b = -7, c = 0;
        double D, FirstResult, SecondResult;
        if (a != 0) {
            D = b * b - 4 * a * c;
            if (D > 0) {
                FirstResult = (-b - Math.sqrt(D)) / (2 * a);
                SecondResult = (-b + Math.sqrt(D)) / (2 * a);
                System.out.println("два решения x1 = " + String.format("%.2f",Math.min(FirstResult, SecondResult)) +
                        " x2 = " + String.format("%.2f", Math.max(FirstResult,SecondResult)));
            } else if (D == 0) {
                FirstResult = -b / (2 * a);
                System.out.println("одно решение x = " + String.format("%.2f",FirstResult));
            } else
                System.out.println("решений нет");
        } else if (b != 0) {
            FirstResult = -c / b;
            System.out.println("одно решение x = " + String.format("%.2f",FirstResult));
        } else if (c != 0) {
                System.out.println("решений нет");
        } else
            System.out.println("бесконечно много решений");
    }
}
