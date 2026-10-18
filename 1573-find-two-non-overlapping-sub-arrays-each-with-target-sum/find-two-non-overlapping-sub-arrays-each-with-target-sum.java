import java.util.Arrays;

public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int left = 0;
        int currentSum = 0;
        int result = Integer.MAX_VALUE;
        int currentMinLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            
            while (currentSum > target) {
                currentSum -= arr[left];
                left++;
            }
            
            if (currentSum == target) {
                int length = right - left + 1;

                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, length + minLen[left - 1]);
                }
                
                currentMinLen = Math.min(currentMinLen, length);
            }
            
            minLen[right] = currentMinLen;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}