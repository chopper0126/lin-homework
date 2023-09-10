package backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//47.全排列||
public class NO47 {
    List<List<Integer>> res = new ArrayList<>();//存放最后结果，二维数组
    LinkedList<Integer> path = new LinkedList<>();//存放其中一条路径，子集
    boolean used[];//定义判断是否重复使用数组

    public List<List<Integer>> permuteUnique(int[] nums) {
        //空
        if (nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        //先对nums排序
        Arrays.sort(nums);

        backTrack(nums, used);
        return res;
    }

    //回溯函数
    //三部曲：返回值和参数
    //终止条件，单层逻辑
    //返回值和参数--void，nums
    private void backTrack(int[] nums, boolean[] used) {
        //终止条件--当path长度和num长度相同时
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        //单层逻辑--- 每层都是从0开始搜索而不是startIndex
        //- 需要used数组记录path里都放了哪些元素了
        for (int i = 0; i < nums.length; i++) {
            //重复使用
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) continue;
            //如果同一树枝没有使用过开始处理
            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
