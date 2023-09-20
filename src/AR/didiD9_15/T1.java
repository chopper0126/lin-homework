package AR.didiD9_15;

import java.util.*;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
        }
        int low = 0;
        int high = 1000000;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceLamps(positions, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
        sc.close();
    }

    private static boolean canPlaceLamps(int[] positions, int k, int d) {
        int lastPlaced = positions[0];
        int count = 1;
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - lastPlaced >= d) {
                count++;
                lastPlaced = positions[i];
            }
        }
        return count >= k;
    }
}

