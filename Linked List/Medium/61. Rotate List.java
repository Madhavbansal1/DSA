class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null){
            return head;
        }
        ListNode temp = head;
        int l = 1;
        while(temp.next != null){
            temp = temp.next;
            l++;
        }
        temp.next = head;
        int k1 = l-(k%l);
        
        while(k1>0){
            temp = temp.next;
            k1--;
        }
        ListNode ans = temp.next;
        temp.next = null;

        return ans;

    }
}
