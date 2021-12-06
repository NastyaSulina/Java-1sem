public class Matrix22 {

    private final double a; private final double b;
    private final double c; private final double d;


    public Matrix22(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Matrix22(double[][] array) {
        this.a = array[0][0];
        this.b = array[0][1];
        this.c = array[1][0];
        this.d = array[1][1];
    }

    public double Trace() {
        return a + d;
    }

    public double Discriminant() {
        return a * d - b * c;
    }

    public double[][] getArray() {
        return new double[][]{{a, b}, {c, d}};
    }

    public String toString() {
        return "[[" + a + ", " + b + "], [" + c + ", " + d + "]]";
    }

//    public void print() {
//        System.out.println(a + "  " + b + "\n" + c + "  " + d);
//    }

    // выравнивание по правому краю
    public void print() {
        double[][] arr = getArray();
        for (double[] line : arr) {
            for (int i = 0; i < 2; i++) {
                int d = Math.max(String.valueOf(arr[1][i]).length(), String.valueOf(arr[0][i]).length()) - String.valueOf(line[i]).length();
                if (i != 0)
                    System.out.print("  ");
                for (int j = 0; j < d; j++)
                    System.out.print(" ");
                System.out.print(line[i]);
            }
            System.out.print("\n");
        }
    }

    public Matrix22 add(Matrix22 addedMatrix) {
        return new Matrix22(this.a + addedMatrix.a, this.b + addedMatrix.b, this.c + addedMatrix.c, this.d + addedMatrix.d);
    }

    public Matrix22 mul(Matrix22 secondMatrix) {
        double newA = this.a * secondMatrix.a + this.b * secondMatrix.c;
        double newB = this.a * secondMatrix.b + this.b * secondMatrix.d;
        double newC = this.c * secondMatrix.a + this.d * secondMatrix.c;
        double newD = this.c * secondMatrix.b + this.d * secondMatrix.d;
        return new Matrix22(newA, newB, newC, newD);
    }

    public Matrix22 pow(int n) {
        Matrix22 result = this;
        for (int i = 1; i < n; i++)
            result = result.mul(this);
        return result;
    }
}
