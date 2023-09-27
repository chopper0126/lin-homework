package AR.wabgyi923;


import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            int[] sortedArr = arr.clone();
            java.util.Arrays.sort(sortedArr);

            if (n % 2 == 1) {
                if (java.util.Arrays.equals(arr, sortedArr)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                boolean flag = true;
                for (int j = 0; j < n; j++) {
                    if (arr[j] != sortedArr[(j + 2) % n]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
