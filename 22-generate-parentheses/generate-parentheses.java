class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    public void generate(List<String> result, String s,
                         int open, int close, int n) {

        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }

        int choice = 0;

        while( choice < 2){

            if (choice == 0 && open < n) {
                generate(result, s + "(", open + 1, close, n);
            }

            if (choice == 1 && close < open) {
                generate(result, s + ")", open, close + 1, n);
            }
            choice++;
           
        }
    }
}