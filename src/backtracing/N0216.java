package backtracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N0216 {
    List<List<Integer>> result = new ArrayList<>();//存放结果
    LinkedList<Integer> path = new LinkedList<>();//存放路径，既子集

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracing(n, k, 1, 0);
        return result;
    }

    /*
     *时间复杂度：O（）
     *空间复杂度：O（）
     *@author chopper
     *@date 2022/10/13 11:04
     * @param n:和为n
     * @param k: k个数
     * @param startIndex: 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）
     * @param sum: 记录某个子集中的和
     *return void
     */
    private void backTracing(int n, int k, int startIndex, int sum) {
        //剪枝
        if (sum > n) {
            return;
        }
        //终止条件--当长度和k相同且sum=n，添加到结果中，并return
        if (path.size() == k) {
            if (sum == n) result.add(new ArrayList<>(path));
            return;
        }
        //剪枝
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backTracing(n, k, i + 1, sum);
            path.removeLast();//回溯
            sum -= i;
        }
    }

}
