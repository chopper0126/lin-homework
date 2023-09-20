package AR.zhongxing.D919;


import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strA = scanner.nextLine().split(",");
        String[] strB = scanner.nextLine().split(",");
        int[] A = new int[strA.length];
        int[] B = new int[strB.length];
        for (int i = 0; i < strA.length; i++) {
            A[i] = Integer.parseInt(strA[i]);
        }
        for (int i = 0; i < strB.length; i++) {
            B[i] = Integer.parseInt(strB[i]);
        }
        System.out.println(findMedianSortedArrays(A, B));
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
