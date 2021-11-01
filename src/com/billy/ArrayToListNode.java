package com.billy;

public class ArrayToListNode {
    public ListNode arrayToListNode (int[] input) {
        ListNode start = new ListNode(0);
        ListNode pre = start;
        for (int i : input) {
            ListNode listNode = new ListNode(i);
            pre.next = listNode;
            pre = listNode;
        }
        return start.next;
    }
}
