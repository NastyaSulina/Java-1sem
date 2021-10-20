import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args){
        System.out.println(Arrays.toString(sieveOfEratosthenes(30)));

        System.out.println(Arrays.toString(primes(30)));
    }
    private static boolean[] sieveOfEratosthenes(int n){
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false; prime[1] = false;
        for (int i = 2; i < n + 1; i++)
            if (prime[i])
                for (int j = i * i; j < n + 1; j += i)
                    prime[j] = false;
        return prime;
    }
    private static int[] primes(int n){
        boolean[] prime = sieveOfEratosthenes(n);
        int count = 0;
        for (boolean x : prime)
            if (x) count++;
        int[] result = new int[count];
        int j = 0;
        for (int i = 0; i < n + 1; i++)
            if (prime[i]) {
                result[j] = i;
                j++;
            }
        return result;
    }
}