package string;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, res = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            Integer cv = window.getOrDefault(c, 0);
            window.put(c, cv + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;

                Integer dv = window.get(d);
                window.put(d, dv - 1);
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}
