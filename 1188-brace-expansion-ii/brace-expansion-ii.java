import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression, 0, expression.length()).set;
        
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    static class Result {
        Set<String> set;
        int index;

        Result(Set<String> set, int index) {
            this.set = set;
            this.index = index;
        }
    }

    private Result parse(String s, int i, int n) {

        Set<String> result = new HashSet<>();
        boolean firstPart = true;

        while (i < n && s.charAt(i) != '}') {

            Set<String> current;

            if (Character.isLetter(s.charAt(i))) {
                current = new HashSet<>();
                current.add(String.valueOf(s.charAt(i)));
                i++;
            }

            else if (s.charAt(i) == '{') {
                Result inside = parse(s, i + 1, n);
                current = inside.set;
                i = inside.index + 1; // skip '}'
            }

            else {
                i++;
                continue;
            }

            if (firstPart) {
                result.addAll(current);
                firstPart = false;
            } else {
                Set<String> combined = new HashSet<>();

                for (String a : result) {
                    for (String b : current) {
                        combined.add(a + b);
                    }
                }

                result = combined;
            }

            if (i < n && s.charAt(i) == ',') {
                i++;

                Result next = parse(s, i, n);

                result.addAll(next.set);
                i = next.index;
            }
        }

        return new Result(result, i);
    }
}