package AR.MT9_2;

import java.util.Arrays;
import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        sc.close();

        long result = removeElements(a, k);
        System.out.println(result % 1000000007);
    }

    public static long removeElements(long[] a, int k) {
        // Sort the array
        Arrays.sort(a);

        // Initialize the result
        long result = 0;

        // Iterate through the array
        for (int i = 0; i < a.length - k; i++) {
            // Calculate the current pair count
            long count = 0;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] % a[i] == 0) {
                    count++;
                }
            }

            // Calculate the number of ways to remove the current pair count
            long ways = 1;
            for (int j = 0; j < count; j++) {
                ways = ways * 2 % 1000000007;
            }

            // Update the result
            result = (result + ways) % 1000000007;
        }

        return result;
    }
}
