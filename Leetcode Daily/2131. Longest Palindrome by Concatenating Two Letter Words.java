

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (map.getOrDefault(reverse, 0) > 0) {
                ans += 4;
                map.put(reverse, map.get(reverse) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                ans += 2;
                break;
            }
        }

        return ans;
    }
}
