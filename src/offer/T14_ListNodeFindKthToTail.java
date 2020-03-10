package offer;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/10 22:36
 * @Version 1.0
 */
public ListNode T14_ListNodeFindKthToTail(ListNode head, int k) {
    if (head == null) return null;
    ListNode node1 = head;
    ListNode node2 = head;

    while (node1 != null && k > 0 ) {
        node1 = node1.next;
        k--;
        }
    if (k > 0) return null;
    while (node1 != null) {
        node1 = node1.next;
        node2 = node2.next;
        }
    return node2;
}
