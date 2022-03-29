package lc.lcQuestion;

import lc.basicDataStructure.ListNode;

import java.util.Random;

/**
 * Description:
 * date: 2022/3/29 17:06
 *
 * @author huajie.zuo
 */
public class Q382 {
    class Solution {
        Random random;
        ListNode head;
        public Solution(ListNode head) {
            random=new Random();
            this.head=head;
        }

        public int getRandom() {
            int i=1;
            int r=0;
            ListNode headC=head;
            while (headC != null) {
                if(random.nextInt(i++)==0){
                    r=headC.val;
                }
                headC=headC.next;
            }
            return r;
        }
    }
}
