class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;

        long minCost = n1 * c1 + n2 * c2;
        long k1 = Math.min(n1, n2);
        long costOption2 = k1 * cb + (n1 - k1) * c1 + (n2 - k1) * c2;
        minCost = Math.min(minCost, costOption2);

        long k2 = Math.max(n1, n2);
        long costOption3 = k2 * cb;
        minCost = Math.min(minCost, costOption3);

        return minCost;
    }
}