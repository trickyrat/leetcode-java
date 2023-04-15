package org.trickyrat;

import java.util.*;

public class Utilities {
    /**
     * Create a ListNode by array.
     * 
     * @param nums input array
     * @return the head node
     */
    public static ListNode createListNode(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode dummyHead = head;
        for (int num : nums) {
            dummyHead.next = new ListNode(num);
            dummyHead = dummyHead.next;
        }
        return head.next;
    }

    public static TreeNode createTreeNode(String data) {
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
            if (index > nums.length - 1 || nums[index].equals("null")) {
                node.left = null;
            } else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nums[index]));
                if (node != null) {
                    node.left = leftNode;
                }
                queue.add(leftNode);
            }
            if (index + 1 > nums.length - 1 || nums[index + 1].equals("null")) {
                node.right = null;
            } else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nums[index + 1]));
                if (node != null) {
                    node.right = rightNode;
                }
                queue.add(rightNode);
            }
            index += 2;
        }
        return root;
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
