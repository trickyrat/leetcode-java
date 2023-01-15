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
    ListNode dummy1 = (ListNode)obj;
    ListNode dummy2 = this;
    while (dummy1 != null && dummy2 != null && dummy1.val == dummy2.val) {
      dummy1 = dummy1.next;
      dummy2 = dummy2.next;
    }
    return dummy1 == null && dummy2 == null;
  }

  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder();
    ListNode dummy = this;
    while (dummy != null) {
      ret.append(dummy.val);
      if (dummy.next != null) {
        ret.append("->");
      }
      dummy = dummy.next;
    }
    return ret.toString();
  }
}
