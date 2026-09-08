class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];

        int product = 1;
        for(int i = n-1; i >= 0; i--){
            product = product * nums[i];
            right[i] = product;

        }

        int[] ans = new int[n];
        int left = 1;

        for(int i = 0; i < n-1;i++){
            int val = left * right[i+1];
            ans[i] = val;
            left = left * nums[i];
        }
        ans[n-1] = left;
        
        return ans;
        
    }
}