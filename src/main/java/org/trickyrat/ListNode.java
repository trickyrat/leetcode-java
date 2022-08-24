package org.trickyrat;

/**
 * Definition for singly-linked list.
 */
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

  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder();
    ListNode dummy = this;
    while (dummy != null) {
      ret.append(dummy.val);
      if (dummy.next == null) {
        ret.append("->");
      }
      dummy = dummy.next;
    }
    return ret.toString();
  }
}
