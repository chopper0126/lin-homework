package backtracing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class NO491 {
    //法二：使用map

    //结果集合
    List<List<Integer>> res = new ArrayList<>();
    //路径集合
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        getSubsequences(nums, 0);
        return res;
    }

    private void getSubsequences(int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
            // 注意这里不要加return，要取树上的节点
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            // 使用过了当前数字
            if (map.getOrDefault(nums[i], 0) >= 1) {
                continue;
            }
            //public V getOrDefault(Object key,V defaultValue)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);//返回到指定键所映射的值，或 defaultValue如果此映射包含该键的映射。
            path.add(nums[i]);
            getSubsequences(nums, i + 1);
            path.removeLast();
        }
    }
}

