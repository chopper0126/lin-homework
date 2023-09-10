package AR.Practice.Leetcode;

public class Rob {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }

    /*
    1.1:1 翻译成迭代  -- 递推（自底向上）
    2.  dfs -- f数组
        递归-- 循环
        递归边界-- 数组初始值
    分析：
    O（n）
    O（n）
    */
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n+2];//定义记忆数组
        for(int i = 0; i < n; i++){
            f[i + 2] = Math.max(f[i + 1],f[i] + nums[i]);
        }
        return f[n + 1];
    }


}
