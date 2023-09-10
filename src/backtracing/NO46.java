package backtracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//46.全排列
public class NO46 {
    List<List<Integer>> res = new ArrayList<>();//存放最后结果，二维数组
    LinkedList<Integer> path = new LinkedList<>();//存放其中一条路径，子集
    boolean used[];//定义判断是否重复使用数组

    public List<List<Integer>> permute(int[] nums) {
        //空
        if (nums.length == 0) {
            return res;
        }
        //
        used = new boolean[nums.length];
        permuteHelper(nums);
        return res;
    }

    //回溯函数
    //三部曲：返回值和参数
    //终止条件，单层逻辑
    //返回值和参数--void，nums
    private void permuteHelper(int[] nums) {
        //终止条件--当path长度和num长度相同时
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        //单层逻辑--- 每层都是从0开始搜索而不是startIndex
        //- 需要used数组记录path里都放了哪些元素了
        for (int i = 0; i < nums.length; i++) {
            //重复使用
            if (used[i] == true) continue;
            //
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
