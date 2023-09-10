package greedy;

import java.util.Arrays;

// 贪心算法测试类
public class greedyDemo {
    public static void main(String[] args) {
         //455.分发饼干
        NO455 no455 = new NO455();
        int res = no455.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        System.out.println(res);

        //.435.不重复区间个数
        NO435 no435 = new NO435();
        int res2 = no435.eraseOverlapIntervals(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        System.out.println(res2);

        //.452.452. 用最少数量的箭引爆气球
        NO452 no452 = new NO452();
        int res3 = no452.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});
        System.out.println(res3);

        //.452.452. 用最少数量的箭引爆气球
        NO406 no406 = new NO406();
        int[][] res4 = no406.reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0},{6,1}, {5,2}});

        System.out.println(Arrays.deepToString(res4));//使用Arrays.deepToString(array)方法打印。

    }
}
