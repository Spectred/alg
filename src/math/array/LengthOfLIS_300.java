package math.array;

import org.junit.Test;

import java.util.Arrays;

public class LengthOfLIS_300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        int res = new LengthOfLIS_300().lengthOfLIS(nums);
        System.out.println(res);
    }
}