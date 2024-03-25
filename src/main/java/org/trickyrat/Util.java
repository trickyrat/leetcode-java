package org.trickyrat;

import java.util.*;

public class Util {
    /**
     * Create a ListNode by array.
     *
     * @param nums input array
     * @return the head node
     */
    public static ListNode generateListNode(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode dummyHead = head;
        for (int num : nums) {
            dummyHead.next = new ListNode(num);
            dummyHead = dummyHead.next;
        }
        return head.next;
    }

    private static ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static boolean containsTree(List<TreeNode> trees, TreeNode targetTree) {
		for (TreeNode treeNode : trees) {
			if (treeNode.equals(targetTree)) {
				return true;
			}
		}
		return false;
	}

    public static String convertListNodeToString(ListNode head, String separator) {
        StringBuilder ret = new StringBuilder();
        ListNode cycleNode = detectCycle(head);

        ListNode dummy = head;
        while (dummy != null) {
            ret.append(dummy.val);
            if (dummy.next != null) {
                ret.append(separator);
            }
            dummy = dummy.next;
            if (cycleNode != null && dummy == cycleNode) {
                ret.append(cycleNode.val)
                        .append(separator)
                        .append("...");
                break;
            }
        }
        return ret.toString();
    }

    public static TreeNode generateTreeNode(String data) {
        String[] nums = data.split(",");
        if (nums[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean fillLeft = true;
        for (int i = 1; i < nums.length; i++) {
            TreeNode node = nums[i].equals("null") ? null : new TreeNode(Integer.parseInt(nums[i]));
            if (fillLeft) {
                queue.peek().left = node;
                fillLeft = false;
            } else {
                queue.peek().right = node;
                fillLeft = true;
            }

            if (node != null) {
                queue.add(node);
            }

            if (fillLeft) {
                queue.poll();
            }
        }
        return root;
    }

    public static Node generateNTreeNode(String data) {
        if (data == null) {
            return null;
        }

        String[] nums = data.split(",");
        if (nums.length == 0 || nums[0].equals("null")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(nums[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < nums.length; i++) {
            if (!nums[i].equals("null")) {
                Node parent = queue.peek();
                Node child = new Node(Integer.parseInt(nums[i]));
                parent.children.add(child);
                queue.add(child);
            } else if (nums[i].equals("null") && queue.size() < 2) {
            } else {
                queue.poll();
            }
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
