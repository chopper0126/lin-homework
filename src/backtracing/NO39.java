package backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*      给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
        candidates 中的数字可以无限制重复被选取。
        说明：
        所有数字（包括 target）都是正整数。
        解集不能包含重复的组合。
        示例 1： 输入：candidates = [2,3,6,7], target = 7, 所求解集为： [ [7], [2,2,3] ]
        示例 2： 输入：candidates = [2,3,5], target = 8, 所求解集为： [   [2,2,2,2],   [2,3,3],   [3,5] ]
        #思路
        题目中的无限制重复被选取，吓得我赶紧想想 出现0 可咋办，然后看到下面提示：1 <= candidates[i] <= 200，我就放心了。
        本题和77.组合 ，216.组合总和III 和区别是：本题没有数量要求，
        可以无限重复，但是有总和的限制，所以间接的也是有个数的限制。*/
public class NO39 {
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);//先排序
        backracking(res,new ArrayList<>(),candidates,target,0,0);
        return res;
    }

    private void backracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        //找到了数字何为target的组合
        if (sum == target){
            res.add((new ArrayList<>(path)));
            return;
        }

        //回溯模板
        for (int i = idx;i<candidates.length;i++){
            //剪纸——如果sum+candidates【i】 > target,则break
            if (sum+candidates[i]>target)break;
            //
            path.add(candidates[i]);
            backracking(res,path,candidates,target,sum+candidates[i],i);
            path.remove(path.size()-1);
        }
    }

}
