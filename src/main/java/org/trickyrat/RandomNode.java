package org.trickyrat;

import java.util.Random;

public class RandomNode {
  ListNode _head;
  Random _random;

  public RandomNode(ListNode head) {
    _head = head;
    _random = new Random();
  }

  public int getRandom() {
    int i = 1, ans = 0;
    for (ListNode curr = _head; curr != null; curr = curr.next) {
      if (_random.nextInt(i) == 0) {
        ans = curr.val;
      }
      ++i;
    }
    return ans;
  }
}