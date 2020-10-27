package example;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

public class CountPrimes {
    public static int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++) {
            if(isPrim[i]) {
                for (int j = i * i; j < n; j++) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrim[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }
}
