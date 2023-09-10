package AR.MT;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        if (sum %2 == 0){
            int target = sum/2;
            int[] dp = new int[target+1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = target; j >=a[i] ; j--) {
                    dp[j] = dp[j] | dp[j - a[i]];
                }
            }
            for (int i = target; i >=0; i--) {
                if(dp[i] == 1){
                    System.out.println(sum - 2*i);
                }
            }
        }

//        long min = Integer.MAX_VALUE;
//        for (int i = 1; i < n; i++) {
//            if (a[i] <= a[i-1]){
//                min = Math.min(min,sum - 2*a[i]);
//            }
//
//        }
//
//        long ans = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(-1);
    }
}
