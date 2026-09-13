class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        int row1 = 0;
        int column1 = 1;

        int row2 = 2;
        int column2 = 3;

        

        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();

        for(int i = 0; i < img1.length; i++){
            for(int j = 0; j < img1.length; j++){

                if(img1[i][j] == 1){
                    ones1.add(new int[]{i, j});
                }
                if(img2[i][j] == 1){
                    ones2.add(new int[]{i, j});
                }
            }
        }

        for(int[] picture1 : ones1){
            for(int[] picture2 : ones2){
                int rowShift = picture2[0] - picture1[0];
                int columnShift = picture2[1] - picture1[1];
                
                String key = rowShift + "," + columnShift;

                
                map.put(key, map.getOrDefault(key, 0) + 1); 
                max = Math.max(max, map.get(key));
            }

        }
        return max;

    }
}