package lesson17.rob;

/**
 * @author chopper
 * @version 1.0
 * @description: 213. 打家劫舍 II
 * @date 2023/9/7 15:28
 */
public class T213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0] + rob1(nums,2,n-1) ,  rob1(nums, 1, n));
    }
    /*
    1.1:1 翻译成迭代  -- 递推（自底向上） -- 空间优化
    2.  dfs -- f数组
        递归-- 循环
        递归边界-- 数组初始值
    分析：
    O（n）
    O（1）
    */
    public static int rob1(int[] nums, int start, int end) {

        int n = nums.length;
        int[] f = new int[n+2];//定义记忆数组
        for(int i = start; i < end; i++){
            f[i + 2] = Math.max(f[i + 1],f[i] + nums[i]);
        }
        return f[end + 1];
    }
}
