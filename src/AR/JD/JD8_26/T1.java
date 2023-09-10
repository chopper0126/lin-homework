package AR.JD.JD8_26;

import java.util.Scanner;

public class T1 {
    /*
    5
    3 4 7 8 10
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        int[] p = new int[(int) 1e7];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            for (int j = 1; j < p.length; j += i) {
                if (p[j] != 1 && (a[i] + j) % (i+1) == 0){
                    p[j] = 1;
                    b[i] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(b[i] + " ");
        }

    }
}
