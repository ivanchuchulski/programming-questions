import java.util.HashSet;
import java.util.Set;

//  * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> distinct = getDistinctNodes(head);

        ListNode prev = head, curr = head.next;
                
        while (curr != null) {
            if (!distinct.contains(curr.val)) {
                ListNode it = curr.next;
                    
                while(it != null && it.val == curr.val) {
                    it = it.next;
                }
                
                if (prev == head) {
                    prev = it;
                    curr = curr.next;
                    head = prev;
                    continue;
                }

                prev.next = curr.next;
                curr = curr.next;
                continue;
            }

            prev = curr;
            curr = curr.next;
        }


        return head;
    }

    private Set<Integer> getDistinctNodes(ListNode head) {
        Set<Integer> distinct = new HashSet<>();
        ListNode it = head;

        while (it != null) {
            if (distinct.contains(it.val)) {
                distinct.remove(it.val);
            } else {
                distinct.add(it.val);
            }
            it = it.next;
        }

        return distinct;
    }
}