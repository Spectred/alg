package math.common;

import org.junit.Test;

/**
 * <a href="https://leetcode.cn/problems/count-and-say/">38. 外观数列</a>
 */
public class CountAndSay_38 {

    @Test
    public void test() {
        var s = countAndSay(5);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            var sb = new StringBuilder();
            int start = 0, pos = 0;
            while (pos < res.length()) {
                while (pos < res.length() && res.charAt(pos) == res.charAt(start)) pos++;
                sb.append(pos - start).append(res.charAt(start));
                start = pos;
            }
            res = sb.toString();
        }
        return res;
    }
}
