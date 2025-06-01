import java.util.*;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];

        // First, push all elements except the last one
        for (int i = n - 2; i >= 0; i--) {
            s.push(nums[i]);
        }

        // Traverse from the end
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                result[i] = s.peek();
            } else {
                result[i] = -1;
            }
            s.push(nums[i]);
        }

        return result;
    }
}
