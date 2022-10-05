package math.common;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones-iii/">1004. 最大连续1的个数 III</a>
 */
public class longestOnes_1004 {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int i = longestOnes(nums, k);
        System.out.println(i);
    }

    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r++] == 0) k--;
            if (k < 0 && nums[l++] == 0) k++;
        }
        return r - l;
    }
}
