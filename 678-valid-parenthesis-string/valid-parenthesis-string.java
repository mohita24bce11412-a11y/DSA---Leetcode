class Solution {
    public boolean checkValidString(String s) {
        int countmin = 0;
        int countmax = 0;

        for(char c: s.toCharArray()){
            if(c== '('){
                countmin++;
                countmax++;
            }else if(c == ')'){
                countmin--;
                countmax--;
            }else{
                countmin--;
                countmax++;
            }

            if(countmax < 0){
                return false;
            }

            countmin = Math.max(countmin, 0);

        }
        return countmin == 0;

        
    }
}