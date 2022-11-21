package string;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseParentheses_1190 {

    @Test
    public void test() {
        String s = new ReverseParentheses_1190().reverseParentheses("(ed(et(oc))el)");
        Assert.assertEquals("leetcode", s);
    }

    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
