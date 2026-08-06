class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int maxProduct = Integer.MIN_VALUE;
        int n = nums.length;
        
        //swap min and max if num is negative
        for(int i = 0; i < n; i++){

            if(prefix == 0){
            prefix = 1;
            }

             if(suffix == 0){
            suffix = 1;
            }

            prefix *= nums[i];
            suffix *= nums[n - 1 - i ];


            //update max and mn
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
           

            

        }
        return maxProduct;
        
    }
}