class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(nums, 0);
        return ans;
    }

    public void helper(int[] nums, int index) {

        if (index == nums.length) {
            List<Integer> current = new ArrayList<>();

            for (int x : nums) {
                current.add(x);
            }

            ans.add(current);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            // Swap
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            // Recursion
            helper(nums, index + 1);

            // Backtrack
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}