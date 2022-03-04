package com.trickyrat.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Util {
  public TreeNode createTreeNodeWithBFS(String data) {
    String[] nums = data.split(",");
    if (nums[0].equals("null")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int index = 1;
    while (index < nums.length) {
      TreeNode node = queue.poll();
      String leftValue = nums[index];
      String rightValue = nums[index + 1];
      if (!leftValue.equals("null")) {
        TreeNode leftNode = new TreeNode(Integer.parseInt(leftValue));
        if (node != null) {
          node.left = leftNode;
        }
        queue.add(leftNode);
      }
      if (!rightValue.equals("null")) {
        TreeNode rightNode = new TreeNode(Integer.parseInt(rightValue));
        if (node != null) {
          node.right = rightNode;
        }
        queue.add(rightNode);
      }
      index += 2;
    }
    return root;
  }

  public TreeNode createTreeNodeWithDFS(String data) {
    String[] dataArray = data.split(",");
    List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
    return dfs(dataList);
  }

  private TreeNode dfs(List<String> dataList) {
    if (dataList.get(0).equals("null")) {
      dataList.remove(0);
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
    dataList.remove(0);
    root.left = dfs(dataList);
    root.right = dfs(dataList);
    return root;
  }
}
