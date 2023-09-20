package AR.MT9_16;


import java.util.*;

public class T3V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), H = sc.nextInt(), A = sc.nextInt();

        int[] healths = new int[n];
        int[] attacks = new int[n];
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            healths[i] = sc.nextInt();
            indices[i] = i;
        }

        for (int i = 0; i < n; i++) {
            attacks[i] = sc.nextInt();
        }
        System.out.println(1);
        Arrays.sort(indices, (i, j) -> Integer.compare(Math.max(healths[j], attacks[j]), Math.max(healths[i], attacks[i])));

        int count = 0;
        for (int i : indices) {
            if (healths[i] < H && attacks[i] < A) {
                count++;
                H = healths[i];
                A = attacks[i];
            }
        }

        System.out.println(count);
    }
}
