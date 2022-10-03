import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        String str = "jdbc:postgresql://pgm-2zefg365218mep8uho.pg.rds.aliyuncs.com:1921/ycw_dw?currentSchema=yftestapinv&TimeZone=Asia/Shanghai&stringtype=unspecified";
        String substring = str.substring(str.indexOf("=") + 1, str.indexOf("&"));
        System.out.println(substring);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSum(nums, 3, 0, 0);
    }

    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;

        if (n < 2 || n > size) return res;

        if (n == 2) {
            int lo = start, hi = size - 1;
            while (lo < hi) {
                int left = nums[lo], right = nums[hi],
                        sum = left + right;
                if (sum < target)
                    while (lo < hi && nums[lo] == left)
                        lo++;
                else if (sum > target)
                    while (lo < hi && nums[hi] == right)
                        hi--;
                else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left)
                        lo++;
                    while (lo < hi && nums[hi] == right)
                        hi--;
                }
            }
        } else {
            for (int i = start; i < size; i++) {
                List<List<Integer>> sub =
                        nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < size - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }

        return res;
    }
}