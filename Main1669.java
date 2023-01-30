/**
 * @Author: siyiyimiaozhong
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main1669.java
 * @CreateTime: 2023-01-30  09:07
 * @Version: 1.0
 */
public class Main1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tmpA = list1, tmpB = list1;
        for (int i = 1; i < a; i++) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        int x = b - a + 1;
        for (int i = 0; i < x; i++) {
            tmpB = tmpB.next;
        }
        tmpA.next = list2;
        do {
            tmpA = tmpA.next;
        } while (null != tmpA.next);
        tmpA.next = tmpB.next;
        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = newListNode(0, 1, 2, 3, 4, 5);
        ListNode list2 = newListNode(1000000, 1000001, 1000002);
        int a = 3, b = 4;

        Main1669 main1669 = new Main1669();
        ListNode listNode = main1669.mergeInBetween(list1, a, b, list2);
        print(listNode);
    }

    private static ListNode newListNode(int... arr) {
        ListNode root = null, tmp = null;
        for (int x : arr) {
            if (null == root) {
                root = new ListNode(x);
                tmp = root;
                continue;
            }
            tmp.next = new ListNode(x);
            tmp = tmp.next;
        }
        return root;
    }

    private static void print(ListNode listNode) {
        do {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        } while (null != listNode);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

