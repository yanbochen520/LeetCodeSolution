/**
 * @Author: ybchen
 * @Date: 2020/11/12 16:59
 */
public class Code24SwapPairs {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      }

    /**
     *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     *
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1]
     * 输出：[1]
     *  
     *
     * 提示：
     *
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = head.next;
        ListNode third = head.next.next;
        cur.next = third;
        next.next = cur;
        ListNode node = swapPairs(third);
        cur.next = node;
        return next;
    }


    public ListNode swapPairsVer1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //add a dummy node can avoid the corner case of preNode
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode second;
        ListNode third;
        ListNode connectNode = dummy;
        while (cur != null && cur.next != null) {
            second = cur.next;
            third = second.next;
            cur.next = third;
            second.next = cur;
            //this step is important which reconnect the two reversed LinkedList
            connectNode.next = second;
            connectNode = cur;
            cur = third;
        }
        return dummy.next;

    }










}
