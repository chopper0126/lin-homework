package lesson17;

/**
 * @author chopper
 * @version 1.0
 * @description: 统计构造好字符串的方案数
 * @date 2023/9/7 14:22
 */
public class T2466 {
    public static void main(String[] args) {
        System.out.println(countGoodStrings(2,3,1,2));
    }
    /*
    *
     * @description: //定义f[i] 表示 长度为i的字符串的方案数量
                    //状态转移： f[i] = f[i-one] + f[i-zero]
     * @param: null
     * @return:
     * @author chopper
     * @date: 2023/9/7 14:55
     */
    public static int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = (int) 1e9 + 7;
        //定义f[i] 表示 长度为i的字符串的方案数量
        //状态转移： f[i] = f[i-one] + f[i-zero]
        int[] f = new int[high + 1];
        //定义空字符串的构造方案数量
        f[0] = 1;
        //定义答案
        int ans = 0;
        for (int i = 1; i <= high ; i++) {
            if (i >= zero) f[i] = (f[i] + f[i - zero]) % MOD;
            if (i >= one) f[i] = (f[i] + f[i - one]) % MOD;
            if (i >= low) ans = (ans + f[i]) % MOD;
        }
        return ans;
    }
}
