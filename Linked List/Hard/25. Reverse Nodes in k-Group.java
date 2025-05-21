
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode next = null;
        ListNode prev = null;
        while(temp != null){
            ListNode kthnode = find(temp,k);
            if(kthnode == null){
                if(prev != null){
                    prev.next = temp;
                }
                break;
            }
            next = kthnode.next;
            kthnode.next = null;
            ListNode newHead = reverse(temp);
            if(temp == head){
                head = newHead;
            }else{
                prev.next = newHead;
            }

            prev = temp;
            temp = next;
        }

        return head;
    }

    public ListNode find(ListNode temp, int k){
        while(--k > 0){
            if(temp == null){
                return null;
            }
            temp = temp.next;
        }

        return temp;
    }

    public ListNode reverse(ListNode temp){
        ListNode prev = null;
        ListNode curr = temp;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
        
    }
}
