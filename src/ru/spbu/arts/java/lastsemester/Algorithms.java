package ru.spbu.arts.java.lastsemester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms {
    public static void main(String[] args){
        System.out.println(Arrays.toString(sieveOfEratosthenes(30)));

        System.out.println(Arrays.toString(primes(30)));

        System.out.println(Decomposition(56));
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
    private static List<List<Integer>> Decomposition(int number){
        int[] primesList = primes(number);
        List<List<Integer>> result = new ArrayList<>();
        for (int d : primesList) {
            if (d*d > number ) {
                if (number != 1) {
                    List<Integer> pair = List.of(number, 1);
                    result.add(pair);
                }
                break;
            }
            int count = 0;
            while (number % d == 0) {
                number = number / d;
                count++;
            }
            if (count != 0) {
                List<Integer> pair = List.of(d, count);
                result.add(pair);
            }
        }
        return result;
    }
}