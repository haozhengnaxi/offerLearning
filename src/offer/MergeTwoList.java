package offer;

/**
 * @Author T.Y.Shang
 * @Date: 2020/3/11 22:46
 * @Version 1.0
 */
public ListNode MergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        //if (list1 == null) ? (if (list2 == null) ? null : list2) : list1;
        ListNode res = null;
        // 先确定链表头
        if (list1.val < list2.val) {
        res = list1;
        list1 = list1.next;
        }
        else {
        res = list2;
        list2 = list2.next;
        }
        ListNode head = res;
        // 递归连接res链表
        while (list1 != null && list2 != null) {
        if (list1.val >= list2.val) {
        res.next = list2;
        list2 = list2.next;
        }
        else {
        res.next = list1;
        list1 = list1.next;
        }
        res = res.next;
        }
        if (list1 == null) res.next = list2;
        else res.next = list1;
        return head;
}
