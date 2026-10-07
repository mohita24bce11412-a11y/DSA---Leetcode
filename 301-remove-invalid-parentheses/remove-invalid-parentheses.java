import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            // If a valid string was found at this level, 
            // do not generate deeper levels (ensures minimum removals).
            if (found) continue;

            // Generate next state by removing one parenthesis at a time
            for (int i = 0; i < current.length(); i++) {
                char c = current.charAt(i);

                // Skip non-parenthesis characters
                if (c != '(' && c != ')') continue;

                String nextState = current.substring(0, i) + current.substring(i + 1);

                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.add(nextState);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}