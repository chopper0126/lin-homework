package AR.JD.JD8_26;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] timeV = new int[n];
        int[] scoreV = new int[n];
        int[] timeC = new int[n];
        int[] scoreC= new int[n];
        int[][] temp = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < n; i++) {
                if (j == 0) timeV[i] = temp[i][j];
                if (j == 1) scoreV[i] = temp[i][j];
                if (j == 2) timeC[i] = temp[i][j];
                if (j == 3) scoreC[i] = temp[i][j];
            }
        }
        int max = maxS(n,t,timeV,scoreV,timeC,scoreC);
        System.out.println(max);




    }
    public static int maxS(int n,int t,int[] timeV,int[] scoreV,int[] timeC,int[] scoreC){
        int[][] dp = new int[n][t+1];
        for (int i = 1; i <= n ; i++) {
            int timev = timeV[i - 1];
            int scorev = scoreV[i - 1];
            int timec = timeC[i - 1];
            int scorec = scoreC[i - 1];
            for (int j = 0; j <= t ; j++) {
                if (j < timev){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j]  = Math.max(dp[i-1][j-timev] + scorev ,dp[i-1][j-timec] + scorec );
                }
            }
        }
        return dp[n][t];
    }
}
