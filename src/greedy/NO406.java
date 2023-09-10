package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NO406 {
    public int[][] reconstructQueue(int[][] people) {
        //kong
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        //排序；升高降序，个数k降序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return b[0] - a[0];
                }
            }
        });
        //
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);//按照下标加入队列
        }
        return queue.toArray(new int[queue.size()][]);//转成Array
    }
}
