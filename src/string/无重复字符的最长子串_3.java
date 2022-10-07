package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 */
public class 无重复字符的最长子串_3 {

    @Test
    public void test() {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        Assert.assertEquals(i, 3);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>(16);
        int res = 0, left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right++);
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left++);
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
