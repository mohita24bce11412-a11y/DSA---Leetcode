class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        String result = "";

        while(i >= 0 || j >= 0 || carry != 0){
            int sum = carry;

            if( i>= 0){
                sum += a.charAt(i) - '0';
                i--;
            }

            if( j >= 0){
                sum += b.charAt(j) - '0';
                j--;

            }
            
            int digit = (sum %2);
            carry = sum/2;

            result = digit + result;

            
                
        }
   
       return result;

    
    }
}