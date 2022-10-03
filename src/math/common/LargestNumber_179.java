package math.common;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/largest-number/">179. 最大数</a>
 */
public class LargestNumber_179 {

    @Test
    public void test() {
        int[] nums = {10, 2};
        String s = new LargestNumber_179().largestNumber(nums);
        System.out.println(s);
    }

    public String largestNumber(int[] nums) {
        String[] numArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            numArr[i] = String.valueOf(nums[i]);

        Arrays.sort(numArr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String integer : numArr)
            sb.append(integer);
        String res = sb.toString();
        return res.startsWith("0") ? "0" : res;
    }
}
