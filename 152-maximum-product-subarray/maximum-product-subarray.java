class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        
        //swap min and max if num is negative
        for(int i = 1; i < nums.length; i++){

            if(nums[i] < 0){
            int temp = maxProduct;
            maxProduct = minProduct;
            minProduct = temp;
            }

            //update max and min
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            //update result
            result = Math.max(result, maxProduct);

        }
        return result;
        
    }
}