class Solution {
    public int totalNumbers(int[] digits) {
       
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        for (int num = 100; num <= 998; num += 2) {
            int hundred = num / 100;
            int ten = (num / 10) % 10;
            int unit = num % 10;

            int[] currentFreq = new int[10];
            currentFreq[hundred]++;
            currentFreq[ten]++;
            currentFreq[unit]++;

            if (freq[hundred] >= currentFreq[hundred] &&
                freq[ten] >= currentFreq[ten] &&
                freq[unit] >= currentFreq[unit]) {
                count++;
            }
        }

        return count;
    }
}