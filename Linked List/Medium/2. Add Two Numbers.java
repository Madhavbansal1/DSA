class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ar = new ListNode(0);
        ListNode ar1 = ar;
        int carry = 0;
        while(l1 != null && l2 != null){
           int value = l1.val+l2.val+carry;
           ar.next = new ListNode(value%10);
           carry = value/10;
           l1 = l1.next;
           l2 = l2.next;
           ar = ar.next;
        }
        while( l2 != null){
           int value = l2.val+carry;
           ar.next = new ListNode(value%10);
           carry = value/10;
           
           l2 = l2.next;
           ar = ar.next;
        }
        while(l1 != null ){
           int value = l1.val+carry;
           ar.next = new ListNode(value%10);
           carry = value/10;
           l1 = l1.next;
           
           ar = ar.next;
        }
        if(carry>0){
            ar.next = new ListNode(carry);
        }
        return ar1.next;
        
    }
}
