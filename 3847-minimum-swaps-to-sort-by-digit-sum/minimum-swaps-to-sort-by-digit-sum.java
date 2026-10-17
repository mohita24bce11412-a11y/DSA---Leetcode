import java.util.Arrays;

public class Solution {
    
    // Helper method to compute the sum of digits of a number
    private static int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int minSwaps(int[] nums) {
        int n = nums.length;

        // Custom class to hold the digit sum, original value, and initial index
        class Element implements Comparable<Element> {
            int val;
            int digitSum;
            int originalIndex;

            Element(int val, int originalIndex) {
                this.val = val;
                this.digitSum = getDigitSum(val);
                this.originalIndex = originalIndex;
            }

            @Override
            public int compareTo(Element other) {
                // Primary sorting key: digit sum
                if (this.digitSum != other.digitSum) {
                    return Integer.compare(this.digitSum, other.digitSum);
                }
                // Secondary sorting key: original value
                return Integer.compare(this.val, other.val);
            }
        }

        Element[] elements = new Element[n];
        for (int i = 0; i < n; i++) {
            elements[i] = new Element(nums[i], i);
        }

        // Sort elements based on digit sum, then value
        Arrays.sort(elements);

        // Track visited indices to detect permutation cycles
        boolean[] visited = new boolean[n];
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
            // Skip if the element is already visited or in its correct sorted position
            if (visited[i] || elements[i].originalIndex == i) {
                continue;
            }

            // Find the size of the cycle
            int cycleSize = 0;
            int curr = i;

            while (!visited[curr]) {
                visited[curr] = true;
                curr = elements[curr].originalIndex;
                cycleSize++;
            }

            // A cycle of size k requires (k - 1) swaps
            if (cycleSize > 1) {
                totalSwaps += (cycleSize - 1);
            }
        }

        return totalSwaps;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{37, 100}));         // Output: 1
        System.out.println(minSwaps(new int[]{22, 14, 33, 7}));  // Output: 0
        System.out.println(minSwaps(new int[]{18, 43, 34, 16})); // Output: 2
    }
}