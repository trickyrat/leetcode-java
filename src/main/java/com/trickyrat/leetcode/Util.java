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
      if(index > nums.length - 1 || nums[index].equals("null")) {
        node.left = null;
      } else {
        TreeNode leftNode = new TreeNode(Integer.parseInt(nums[index]));
        if (node != null) {
          node.left = leftNode;
        }
        queue.add(leftNode);
      }
      if(index + 1 > nums.length - 1 || nums[index+1].equals("null")) {
        node.right = null;
      } else {
        TreeNode rightNode = new TreeNode(Integer.parseInt(nums[index+1]));
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
