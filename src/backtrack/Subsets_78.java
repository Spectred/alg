package backtrack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/">78. 子集</a>
 */
public class Subsets_78 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        subsets.forEach(System.out::println);
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, nums, 0);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(track, nums, i + 1);
            track.removeLast();
        }
    }

}
