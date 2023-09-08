package lesson17.rob;

/**
 * @author chopper
 * @version 1.0
 * @description: TODO
 * @date 2023/9/7 15:11
 */
public class T198 {
    public static void main(String[] args) {

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

    public int rob(int[] nums) {

        int n = nums.length;
        int[] f = new int[n+2];//定义记忆数组
        for(int i = 0; i < n; i++){
            f[i + 2] = Math.max(f[i + 1],f[i] + nums[i]);
        }
        return f[n + 1];
    }
}
