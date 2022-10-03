package backtrack;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets-ii/">90. 子集II</a>
 */
public class SubsetsWithDup_90 {

    @Test
    public void test() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        lists.forEach(System.out::println);
    }


    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }


}
