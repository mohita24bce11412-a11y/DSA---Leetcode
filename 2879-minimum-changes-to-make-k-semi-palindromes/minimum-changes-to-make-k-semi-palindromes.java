import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1000000;

        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                cost[i][j] = INF;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;

                    for (int r = 0; r < d; r++) {
                        int left = i + r;
                        int right = i + r
                                  + ((len - 1) / d) * d;

                        while (left < right) {
                            if (s.charAt(left) !=
                                s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(
                        cost[i][j], changes
                    );
                }
            }
        }

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            for (int j = 2 * p; j <= n; j++) {

                for (int i = 2 * (p - 1);
                     i <= j - 2; i++) {

                    if (dp[p - 1][i] == INF)
                        continue;

                    dp[p][j] = Math.min(
                        dp[p][j],
                        dp[p - 1][i] + cost[i][j - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
