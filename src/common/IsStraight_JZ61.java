package common;

import org.junit.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/">剑指 Offer 61. 扑克牌中的顺子</a>
 */
public class IsStraight_JZ61 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(isStraight(nums));
    }

    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);

        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) joker++;
            else if (nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[joker] < 5;
    }
}
