package AR.MT;

import java.util.Scanner;

public class T5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = 0;

        for (int r = 1; r < n; r++) {
            int l = 0;
            int i = r;
            while (i < n){
                for (int j = 0; j < i; j++) {
                    ans += a[j];
                }
                i++;
                l++;
            }

        }
        System.out.println(ans);



    }
}
