package org.trickyrat;

import org.trickyrat.DataStructures.TreeNode;

public class QueueNode {
    TreeNode node;
    int depth;

     public QueueNode(TreeNode node, int depth) {
         this.node = node;
         this.depth = depth;
     }
}
