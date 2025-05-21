// using a another data structure 
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode temp  = head;
        while(temp != null){
            s.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while(!s.isEmpty()){
            if(s.pop() != temp.val){
                return false;
            }
            temp = temp.next;
        }

        return true;
    }
}

// O(1) space complexity

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode findmiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    } 
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
       
        ListNode mid = findmiddle(head);

      

        ListNode prev = null;
        ListNode curr = mid;
        while(curr != null){
            ListNode next= curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode right = prev;
        ListNode left = head;

        while(right != null){
            if(right.val != left.val){
                return false;
            }
            right = right.next;
            left = left.next;
        }

        return true;
        

    }
}
