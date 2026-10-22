class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // Find the index of element 0
        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }

        // Check if the array is cyclically increasing starting from zeroIdx
        boolean isIncreasing = true;
        for (int k = 0; k < n - 1; k++) {
            int currentPos = (zeroIdx + k) % n;
            int nextPos = (zeroIdx + k + 1) % n;
            if (nums[currentPos] + 1 != nums[nextPos]) {
                isIncreasing = false;
                break;
            }
        }

        if (isIncreasing) {
            // Option 1: Rotate Left zeroIdx times
            // Option 2: Reverse -> Rotate Left (n - zeroIdx) times -> Reverse
            return Math.min(zeroIdx, n - zeroIdx + 2);
        }

        // Check if the array is cyclically decreasing starting backward from zeroIdx
        boolean isDecreasing = true;
        for (int k = 0; k < n - 1; k++) {
            int currentPos = (zeroIdx - k + n) % n;
            int prevPos = (zeroIdx - k - 1 + n) % n;
            if (nums[currentPos] + 1 != nums[prevPos]) {
                isDecreasing = false;
                break;
            }
        }

        if (isDecreasing) {
            // Option 1: Reverse -> Rotate Left (n - zeroIdx) times
            // Option 2: Rotate Left (zeroIdx + 1) times -> Reverse
            return Math.min(n - zeroIdx, zeroIdx + 2);
        }

        return -1;
    }
}