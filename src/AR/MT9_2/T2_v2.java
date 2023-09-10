package AR.MT9_2;

import java.util.Scanner;
public class T2_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        String target = "meituan";
        int[][] dp = new int[n + 1][target.length() + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            String line = scanner.nextLine();
            for (int j = 1; j <= target.length(); j++) {
                for (int k = 0; k < m; k++) {
                    if (line.charAt(k) == target.charAt(j - 1)) {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                }
                dp[i][j] += dp[i - 1][j];
            }
        }
        if (dp[n][target.length()] > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}