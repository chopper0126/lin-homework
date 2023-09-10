package greedy;

import java.util.Arrays;
import java.util.Comparator;

/*题目描述：计算让一组区间不重叠所需要移除的区间个数。

        先计算最多能组成的不重叠区间个数--cnt，然后用区间总个数减去不重叠区间的个数--intervals.length-cnt。

        在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。

        按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
*/
public class NO435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // kong
        if (intervals == null) {
            return 0;
        }

        //按区间的结尾进行排序
        // lambda
        //Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        //普通创建
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);//比较其两个参数的顺序。 返回负整数，零或正整数，因为第一个参数小于，等于或大于第二个参数。
            }
        });

        //每次选择结尾最小，并且和前一个区间不重叠的区间。
        int cnt = 1;//长度至少为1
        int end = intervals[0][1];//初始化end
        for (int i = 1; i < intervals.length; i++) {
            //如果intervals下一个元素的第一个元素小于end，则continue
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];//更新
            cnt++;
        }
        return intervals.length - cnt;
    }
}

