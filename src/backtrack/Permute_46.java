package backtrack;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/">46. 全排列</a>
 */
public class Permute_46 {


    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Permute_46().permute(nums);
        permute.forEach(System.out::println);
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, nums);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;

            track.add(nums[i]);
            backtrack(track, nums);
            track.removeLast();
        }
    }


}
