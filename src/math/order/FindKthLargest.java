package math.order;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/">215. 数组中的第K个最大元素</a>
 */
public class FindKthLargest {



    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k];
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int p = partition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int i = l, j = l;
        while (j < r) {
            if (nums[j] < nums[r])
                swap(nums, i++, j);
            j++;
        }
        swap(nums, i, r);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
