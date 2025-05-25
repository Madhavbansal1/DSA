class Solution {
    public String resultingString(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty()) {
                int diff = Math.abs(c - st.peek());
                if (diff == 1 || diff == 25) {
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();

    }
}
