import java.util.Arrays;

public class ArraysTasks {
    public static void main(String[] args) {
        int[] b = even(10);
        System.out.println(Arrays.toString(b));
        int[] c = {10, 10, 10, 10, 20};
        System.out.println(allSimilar(c));
        int[] d = {10, 20, 30, 40, 10};
        System.out.println(hasSimilar(d));

        int[] e = {10, 10, 10, 10, 20};
        System.out.println("среднее значение = " + String.format("%.1f", mean(e)));
        int[] f = {10, 20, 30, 40, 50};
        shift(f);
        System.out.println(Arrays.toString(f));
        System.out.println(Arrays.toString(copyShift(f)));
    }
    private static int[] even(int n) {
        int[] a = new int[n];
        for (int i = 1; i <= n; i++)
            a[i-1] = 2 * i;
        return a;
    }
    private static boolean allSimilar(int[] a) {
        int l = a.length;
        for (int i = 0; i < l-1; i++) // спасибо, поправила!
            if (a[i] != a[i+1])
                return false;
        return true;
    }
    private static boolean hasSimilar(int[] a) {
        int l = a.length;
        for (int i = 0; i < l; i++)
            for (int j = i + 1; j < l; j++)
                if (a[i] == a[j])
                    return true;
        return false;
    }
    private static double mean(int[] a) {
        double sum = 0;
        for (int x : a)
            sum += x;
        return sum / a.length;
    }
    private static void shift(int[] a) {
        int l = a.length;
        int last = a[l - 1];
        for (int i = l - 1; i > 0; i--) // IDEA предлагает System.arraycopy(a, 0, a, 1, l - 1);
            a[i] = a[i - 1];
        a[0] = last;
    }
    private static int[] copyShift(int[] a) {
        int l = a.length;
        int[] arraycopy = new int[l];
        for (int i = 1; i < l; i++)
            arraycopy[i] = a[i - 1];
        arraycopy[0] = a[l - 1];
        return arraycopy;
    }
}
