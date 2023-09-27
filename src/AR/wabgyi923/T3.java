package AR.wabgyi923;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class T3 {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(enumerateSubsequences(arr));
    }

    public static int enumerateSubsequences(int[] arr) {
         double ans = 0;
        int n = arr.length;
        int totalSubsequences = 1 << n;  // 2^n

        for (int i = 0; i < totalSubsequences; i++) {
            List<Integer> subseq = new ArrayList<>();
            double tempSum = 0.0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // 判断第j位是否为1
                    subseq.add(arr[j]);
                    tempSum +=arr[j];
                }
            }
            if (!subseq.isEmpty()){
                ans +=  ( tempSum/(double)(subseq.size()) )% MOD;
            }
        }
        return (int) ans;
    }
}
