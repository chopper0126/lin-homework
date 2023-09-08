package qiuzhao.kuaishou;

/**
 * @author chopper
 * @version 1.0
 * @description: 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 * @date 2023/9/8 15:06
 */
public class D_9_8 {
    public static void main(String[] args) {

        System.out.println(numOfSubarrays(new int[]{2,2,2,2,5,5,5,8},3,4) );
    }
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int left = 0,r = 0;
        int n = arr.length;
        int sum = 0;
        while (r < k){
            sum += arr[r];
            r++;
        }
        while (r <= n) {
            if (r - left  == k ) {
                if (((float) sum / k - threshold) >= 0) {
                    ans++;
                }
                sum -= arr[left];
                left++;
                if (r == n) break;
                sum += arr[r];
                r++;
            }
        }
        return ans;
    }
}
