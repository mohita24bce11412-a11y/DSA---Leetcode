import java.util.Arrays;

public class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int sum = 0;

        // Check each possible divisor k of n
        for (int k = 1; k <= n; k++) {
            if (n % k == 0) {
                if (isSortable(nums, sorted, k)) {
                    sum += k;
                }
            }
        }

        return sum;
    }

    private boolean isSortable(int[] nums, int[] sorted, int k) {
        int n = nums.length;
        
        for (int start = 0; start < n; start += k) {
            int end = start + k;

            // 1. Count the number of drops in the current subarray
            int drops = 0;
            for (int i = start; i < end - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    drops++;
                }
            }

            // A valid cyclic shift can have at most 1 drop.
            if (drops > 1) {
                return false;
            }

            // If there is exactly 1 drop, the last element must be <= first element
            if (drops == 1 && nums[end - 1] > nums[start]) {
                return false;
            }

            // 2. Verify that the subarray matches the sorted segment multiset
            int[] sub = Arrays.copyOfRange(nums, start, end);
            Arrays.sort(sub);
            for (int i = 0; i < k; i++) {
                if (sub[i] != sorted[start + i]) {
                    return false;
                }
            }
        }

        return true;
    }
}