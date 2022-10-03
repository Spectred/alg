package backtrack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/">39. 组合总和</a>
 */
public class CombinationSum_39 {

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        var lists = combinationSum(candidates, 7);
        lists.forEach(System.out::println);
    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return res;

        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] nums, int start, int target) {
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        if (trackSum > target) return;

        for (int i = start; i < nums.length; i++) {
            trackSum += nums[i];
            track.addLast(nums[i]);
            backtrack(nums, i, target);
            track.removeLast();
            trackSum -= nums[i];
        }
    }
}
