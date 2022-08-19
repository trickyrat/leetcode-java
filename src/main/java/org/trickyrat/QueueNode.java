package org.trickyrat;

public class QueueNode {
    TreeNode node;
    int depth;

     public QueueNode(TreeNode node, int depth) {
         this.node = node;
         this.depth = depth;
     }
}
