class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;
        int[] bitCounts = new int[31];

        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if (((num >> bit) & 1) == 1) {
                    bitCounts[bit]++;
                }
            }
        }

        long totalSumOfSquares = 0;

        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit < 31; bit++) {
                if (bitCounts[bit] > i) {
                    currentNum |= (1L << bit);
                }
            }
 
            totalSumOfSquares = (totalSumOfSquares + (currentNum % MOD) * (currentNum % MOD)) % MOD;
        }

        return (int) totalSumOfSquares;
    }
}