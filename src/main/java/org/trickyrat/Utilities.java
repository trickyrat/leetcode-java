package org.trickyrat;

import java.util.*;
import java.util.stream.Stream;

public class Utilities {
    /**
     * Create a ListNode by array.
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

    public static TreeNode createTreeNodeIteratively(String data) {
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

//    public static TreeNode createTreeNodeIteratively(List<OptionalInt> nums) {
//        if (nums.get(0) == null) {
//            return null;
//        }
//        TreeNode root = new TreeNode(nums.get(0).getAsInt());
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int index = 1;
//        int n = nums.size();
//        while (index < n) {
//            TreeNode node = queue.poll();
//            if (index > n - 1 || nums.get(index) == null) {
//                node.left = null;
//            } else {
//                TreeNode leftNode = new TreeNode(nums.get(index) .getAsInt());
//                if (node != null) {
//                    node.left = leftNode;
//                }
//                queue.add(leftNode);
//            }
//            if (index + 1 > n - 1 || nums.get(index + 1) == null) {
//                node.right = null;
//            } else {
//                TreeNode rightNode = new TreeNode(nums.get(index + 1).getAsInt());
//                if (node != null) {
//                    node.right = rightNode;
//                }
//                queue.add(rightNode);
//            }
//            index += 2;
//        }
//        return root;
//    }

    public static List<OptionalInt> createOptionalArray(Object[] data) {
        List<OptionalInt> res = new ArrayList<>();
        for(Object ele : data) {
            if (ele == null) {
                res.add(null);
            } else {
                res.add(OptionalInt.of((int)ele));
            }
        }
        return res;
    }

    public static TreeNode createTreeNodeWithDFS(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return dfs(dataList);
    }

    private static TreeNode dfs(List<String> dataList) {
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
