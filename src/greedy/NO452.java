package greedy;

import java.util.Arrays;
import java.util.Comparator;
/*  题目描述：
        气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。

        也是计算不重叠的区间个数，不过和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间。
*/

public class NO452 {
    public int findMinArrowShots(int[][] points) {
        // kong
        if (points == null) {
            return 0;
        }

        //按区间的结尾进行排序
        // lambda
        //Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        //普通创建
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
                //比较其两个参数的顺序。 返回负整数，零或正整数，因为第一个参数小于，等于或大于第二个参数。
                //先判断o1[1] 是否< o2[1]，是则返回-1，（升序）,否则，返回另一个三元运算符
                //第二个三元运算符，先判断是否相等，相等则返回0，不相等则返回1（降序）
            }
        });

        //每次选择结尾最小，并且和前一个区间不重叠的区间。
        int cnt = 1;//长度至少为1
        int end = points[0][1];//初始化end
        for (int i = 1; i < points.length; i++) {
            //如果intervals下一个元素的第一个元素小于end，则continue
            if (points[i][0] <= end) {//不过和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间。
                continue;
            }
            end = points[i][1];//更新
            cnt++;
        }
        return  cnt;
    }
}
