package lc.lcQuestion;

import lc.basicDataStructure.ListNode;

/**
 * Description:
 * date: 2022/3/30 16:13
 *
 * @author huajie.zuo
 */
public class Q203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode r=new ListNode(0,head);
        ListNode pre=r;
        while (head != null) {
            while (head!=null && head.val==val){
                head=head.next;
            }
            pre.next=head;
            pre=head;
            if(head!=null){
                head=head.next;
            }
        }
        return r.next;
    }
}
