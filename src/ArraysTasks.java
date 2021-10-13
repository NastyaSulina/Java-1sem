import java.util.Arrays;

public class ArraysTasks {
    public static void main(String[] args) {
        int[] b = even(10);
        System.out.println(Arrays.toString(b));
        
        int[] c = {10, 10, 10, 10, 20};
        System.out.println(allSimilar(c));

        int[] d = {10, 20, 30, 40, 10};
        System.out.println(hasSimilar(d));
    }
    private static int[] even(int n) {
        int[] a = new int[n];
        for (int i = 1; i < n + 1; i++)
            a[i-1] = 2 * i;
        return a;
    }
    private static boolean allSimilar(int[] a) {
        int l = a.length;
        for (int i = 0; i < l; i++)
            for (int j = i + 1; j < l; j++)
                if (a[i] != a[j])
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
}
