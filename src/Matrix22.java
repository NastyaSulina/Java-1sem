import java.util.Arrays;

public class Matrix22 {

    private final int a; // final предложила IDEA
    private final int b;
    private final int c;
    private final int d;



    public Matrix22(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Matrix22(int[][] array) {
        this.a = array[0][0];
        this.b = array[0][1];
        this.c = array[1][0];
        this.d = array[1][1];
    }

    public int Trace() {
        return a + d;
    }

    public int Discriminant() {
        return a * d - b * c;
    }

    public int[][] getArray() {
        return new int[][]{{a, b}, {c, d}};
    }

    public String toString() {
        return "[[" + a + ", " + b + "], [" + c + ", " + d + "]]";
    }

    public void print() {
        System.out.println(a + "  " + b + "\n" + c + "  " + d);
    }

    public Matrix22 add(Matrix22 addedMatrix) {
        return new Matrix22(this.a + addedMatrix.a, this.b + addedMatrix.b, this.c + addedMatrix.c, this.d + addedMatrix.d);
    }

    public Matrix22 mul(Matrix22 secondMatrix) {
        int newA = this.a * secondMatrix.a + this.b * secondMatrix.c;
        int newB = this.a * secondMatrix.b + this.b * secondMatrix.d;
        int newC = this.c * secondMatrix.a + this.d * secondMatrix.c;
        int newD = this.c * secondMatrix.b + this.d * secondMatrix.d;
        return new Matrix22(newA, newB, newC, newD);
    }

    public Matrix22 pow(int n) {
        Matrix22 result = this;
        for (int i = 1; i < n; i++)
            result = result.mul(this);
        return result;
    }

    public static void main(String[] args) {
        Matrix22 m1 = new Matrix22(2, 3, 5, 6);
        Matrix22 m2 = new Matrix22(new int[][]{{6, 7}, {8, 9}});

        System.out.println(m1.Discriminant());
        System.out.println(m1.Trace());
        System.out.println(Arrays.deepToString(m2.getArray()));
        System.out.println(m2);
        m2.print();
        System.out.println(m1.add(m2));
        System.out.println(m1.mul(m2));
        System.out.println(m1.pow(5));
    }
}
