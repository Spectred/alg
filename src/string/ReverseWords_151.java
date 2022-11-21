package string;

import org.junit.jupiter.api.Test;

public class ReverseWords_151 {

    @Test
    public void test() {
        String s = "a good   example";
        String res = new ReverseWords_151().reverseWords(s);
        System.out.println(res);
    }

    public String reverseWords(String s) {
        String str = s.trim();
        String[] arr = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if ("".equals(arr[i])) continue;
            res.append(arr[i]).append(" ");
        }
        return res.toString();
    }
}
