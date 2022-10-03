package backtrack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations/">77. 组合</a>
 */
public class Combine_77 {

    @Test
    public void test() {
        List<List<Integer>> combine = combine(4, 2);
        combine.forEach(System.out::println);
    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(i + 1, n, k);
            track.removeLast();
        }
    }

}
