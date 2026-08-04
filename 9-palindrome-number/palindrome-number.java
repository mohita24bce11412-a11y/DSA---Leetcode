class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers or numbers ending in 0 (except 0 itself)
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        // Even digits: x == reversedHalf
        // Odd digits : x == reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}