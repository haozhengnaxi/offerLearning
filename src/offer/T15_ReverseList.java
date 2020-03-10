package offer;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/10 23:51
 * @Version 1.0
 */
public ListNode T15_ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur.next != null) {
        ListNode nxt = cur.next;
        cur.next = pre;
        pre = cur;
        cur = nxt;
        }
        cur.next = pre;
        return cur;
}
