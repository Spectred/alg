package math.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/merge-intervals/">56. 合并区间</a>
 */
public class Merge_56 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {15, 18},{8, 10}};
        int[][] merge = new Merge_56().merge(intervals);
        System.out.println(merge);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = res.getLast();
            if (curr[0] <= last[1]) {
                last[1] = Math.max(curr[1], last[1]);
            } else {
                res.add(curr);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
