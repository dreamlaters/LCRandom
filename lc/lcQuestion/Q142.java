package lc.lcQuestion;

import lc.baseDataStructure.ListNode;

/**
 * Description:
 * date: 2022/3/21 16:42
 *
 * @author huajie.zuo
 */
public class Q142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
