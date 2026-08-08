class Solution {
    public int maxSum(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i<= r-3; i++){
            for(int j = 0; j<= c-3; j++){
                int sum = mat[i][j]+ mat[i][j+1]+mat[i][j+2]+ mat[i+1][j+1] + mat[i+2][j] +mat[i+2][j+1]+mat[i+2][j+2];

                maxSum = Math.max(maxSum, sum);

            }
        }
        return maxSum;
    }
}