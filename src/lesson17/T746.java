package lesson17;

/**
 * @author chopper
 * @version 1.0
 * @description:  使用最小花费爬楼梯
 * @date 2023/9/7 14:09
 */
class T746 {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }
    /*
    1.1:1 翻译成迭代  -- 递推（自底向上）
    2.  dfs -- f数组
        递归 -- 循环
        递归边界 -- 数组初始值
    分析：
    O（）
    O（）
    c. 使用最小花费爬楼梯
    */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 0;
        for(int i = 2; i <= n; i++){
            f[i] = Math.min(f[i-1]+cost[i-1] ,f[i-2] + cost[i-2]);
        }
        return f[n];
    }
}
