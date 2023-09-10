package greedy;

import java.util.Arrays;

public class NO455 {
    int res = 0;

    public int findContentChildren(int[] g, int[] s) {
        // 判断空
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        //if (grid == null || size == null) return 0;

        //排序
        Arrays.sort(g);
        Arrays.sort(s);

        //比较大小，判断 是否满足孩子的需求
        int gindex = 0;
        int sindex = 0;//创建下标
        while (gindex < g.length && sindex < s.length) {
            if (g[gindex] <= s[sindex]) {
                gindex++;
            }
            sindex++;
        }
        res = gindex;

        return res;
    }
}
