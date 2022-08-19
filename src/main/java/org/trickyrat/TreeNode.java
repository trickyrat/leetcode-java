package org.trickyrat;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == null && obj == null) {
      return true;
    } else if (this == null || obj == null) {
      return false;
    }
    Queue<TreeNode> q1 = new LinkedList<>();
    Queue<TreeNode> q2 = new LinkedList<>();
    q1.add(this);
    q2.add((TreeNode) obj);
    while(!q1.isEmpty() && !q2.isEmpty()) {
      TreeNode node1 = q1.remove();
      TreeNode node2 = q2.remove();
      if(node1.val != node2.val) {
        return false;
      }
      TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
      if(left1 == null ^ left2 == null) {
        return false;
      }
      if(right1 == null ^ right2 == null){
        return false;
      }
      if(left1 != null) {
        q1.add(left1);
      }
      if(right1 != null) {
        q1.add(right1);
      }
      if (left2 != null) {
        q2.add(left2);
      }
      if (right2 != null) {
        q2.add(right2);
      }
    }
    return q1.isEmpty() && q2.isEmpty();
  }
}