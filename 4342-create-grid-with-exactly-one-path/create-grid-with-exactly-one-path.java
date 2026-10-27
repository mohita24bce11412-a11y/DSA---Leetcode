class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
        
        // Fill the entire grid with obstacles '#'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '#';
            }
        }
        
        // Create the single valid path:
        // 1. Traverse right across the first row
        for (int j = 0; j < n; j++) {
            grid[0][j] = '.';
        }
        
        // 2. Traverse down the last column
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }
        
        // Convert char grid to String array format
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }
        
        return result;
    }
}