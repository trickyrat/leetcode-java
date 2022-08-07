package com.trickyrat.leetcode;

public class ListNode {
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

  @Override
  public boolean equals(Object obj) {
    ListNode clone = (ListNode)obj;
    return this.val == clone.val;
  }
}
