package org.trickyrat;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    /**
     * 1. Two Sum
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                break;
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    /**
     * 2. Add two numbers
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode resTemp = res;
        int nextSum = 0;
        int flag = 0;
        while (l1 != null & l2 != null) {
            int p;
            if (flag == 0) {
                p = l1.val + l2.val;
                res.val = p % 10;
                nextSum = p / 10;
                flag++;
            } else {
                p = l1.val + l2.val + nextSum;
                resTemp.next = new ListNode(p % 10);
                resTemp = resTemp.next;
                nextSum = p / 10;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int p = l1.val + nextSum;
            resTemp.next = new ListNode(p % 10);
            resTemp = resTemp.next;
            nextSum = p / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int p = l2.val + nextSum;
            resTemp.next = new ListNode(p % 10);
            resTemp = resTemp.next;
            nextSum = p / 10;
            l2 = l2.next;
        }
        if (nextSum != 0) {
            resTemp.next = new ListNode(nextSum);
        }
        return res;
    }

    /**
     * 3. Longest Substring Without Repeating Characters
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * 6. Zigzag Convert
     *
     * @param s
     * @param numRows
     * @return
     */
    public String zConvert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        int t = 2 * numRows - 2;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < n - i; j += t) {
                ans.append(s.charAt(j + i));
                if (0 < i && i < numRows - 1 && j + t - i < n) {
                    ans.append(s.charAt(j + t - i));
                }
            }
        }
        return ans.toString();
    }

    /**
     * 7. Reverse Integer
     *
     * @param x
     * @return
     */
    public int reverseInt(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            res = res * 10 + digit;
        }
        return res;
    }

    /**
     * 19. Remove Nth Node From End of List
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 21.Merge Two Sorted List
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    /**
     * 23. Merge K Sorted Lists
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            p.next = curr;
            if (curr.next != null) {
                pq.add(curr.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 26. Remove Duplicates from Sorted Array
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 33. Search in Rotated Sorted Array
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 35. Search Insert Position
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, res = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    /**
     * 38. Count And Say
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n < 0) {
            return "-1";
        }
        String result = "1";
        for (int i = 1; i < n; ++i) {
            result = build(result);
        }
        return result;
    }

    private String build(String result) {
        StringBuilder builder = new StringBuilder();
        int p = 0;
        while (p < result.length()) {
            char val = result.charAt(p);
            int count = 0;
            while (p < result.length() && result.charAt(p) == val) {
                p++;
                count++;
            }
            builder.append(count);
            builder.append(val);
        }
        return builder.toString();
    }

    /**
     * 39. Combination Sum
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates, target, ans, combine, idx + 1);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    /**
     * 86. Partition List
     *
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }

    /**
     * 111. Minimum Depth of Binary Tree
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left == null && curr.right == null) {
                return depth;
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            depth++;
        }
        return depth;
    }

    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    /**
     * 113. Path Sum II
     *
     * @param root
     * @param targetNum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetNum) {
        dfs(root, targetNum);
        return ret;
    }

    private void dfs(TreeNode root, int targetNum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetNum -= root.val;
        if (root.left == null && root.right == null && targetNum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, targetNum);
        dfs(root.right, targetNum);
        path.pollLast();
    }

    /**
     * 141. Linked List Cycle
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            Util.swap(nums, start, end);
            start++;
            end--;
        }
    }
    /**
     * 189. Rotate Array
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /**
     * 283. Move Zeroes
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    /**
     * 357. Count Numbers with Unique Digits
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }

    /**
     * 386. Lexicographical Numbers
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; ++i) {
            ret.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return ret;
    }

    /**
     * 393. UTF-8 Validation
     *
     * @param data
     * @return
     */
    public boolean validUtf8(int[] data) {
        int n = 0;
        for (int datum : data) {
            if (n > 0) {
                if (datum >> 6 != 2)
                    return false;
                n--;
            } else if (datum >> 7 == 0) {
                n = 0;
            } else if (datum >> 5 == 0b110) {
                n = 1;
            } else if (datum >> 4 == 0b1110) {
                n = 2;
            } else if (datum >> 3 == 0b11110) {
                n = 3;
            } else {
                return false;
            }
        }
        return n == 0;
    }

    /**
     * 434. Number of Segments in a String
     *
     * @param s
     * @return
     */
    public int countSegment(String s) {
        int segmentCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }
        return segmentCount;
    }

    /**
     * 453. Minimum Moves to Equal Array Elements
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

    /**
     * 467. Unique Substrings in Wraparound String
     *
     * @param p
     * @return
     */
    public int findSubstringInWraparoundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                ++k;
            } else {
                k = 1;
            }
            int index = p.charAt(i) - 'a';
            dp[index] = Math.max(dp[index], k);
        }
        return Arrays.stream(dp).sum();
    }

    /**
     * 504. Base 7
     *
     * @param num
     * @return
     */
    public String convertToBase7(Integer num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuilder digits = new StringBuilder();
        while (num > 0) {
            digits.append(num % 7);
            num /= 7;
        }
        if (negative) {
            digits.append('-');
        }
        return digits.reverse().toString();
    }

    /**
     * 521. Longest Uncommon Subsequence I
     *
     * @param a
     * @param b
     * @return
     */
    public Integer findLUTLength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    /**
     * 537. Complex Number Multiplication
     *
     * @param num1
     * @param num2
     * @return
     */
    public String complexNumberMultiply(String num1, String num2) {
        String[] complex1 = num1.split("[+i]");
        String[] complex2 = num2.split("[+i]");
        int real1 = Integer.parseInt(complex1[0]);
        int real2 = Integer.parseInt(complex1[0]);
        int imag1 = Integer.parseInt(complex1[1]);
        int imag2 = Integer.parseInt(complex2[1]);
        return String.format("%d+%di", real1 * real2 - imag2 * imag1, real1 * imag2 + imag1 * real2);
    }

    /**
     * 553. Optimal Division
     *
     * @param nums
     * @return
     */
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder res = new StringBuilder();
        res.append(nums[0]);
        res.append("/(");
        res.append(nums[1]);
        for (int i = 2; i < n; i++) {
            res.append("/");
            res.append(nums[i]);
        }
        res.append(")");
        return res.toString();
    }

    /**
     * 589. N-ary Tree Preorder Traversal
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        preorderHelper(root, ans);
        return ans;
    }

    void preorderHelper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node ch : root.children) {
            preorderHelper(ch, list);
        }
    }

    /**
     * 590. N-ary Tree Postorder Traversal
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postorderHelper(root, ans);
        return ans;
    }

    void postorderHelper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node ch : root.children) {
            postorderHelper(ch, list);
        }
        list.add(root.val);
    }

    /**
     * 599. Minimum Index Sum of Two Lists
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
        }
        List<String> ret = new ArrayList<>();
        int indexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (index.containsKey(list2[i])) {
                int j = index.get(list2[i]);
                if (i + j < indexSum) {
                    ret.clear();
                    ret.add(list2[i]);
                    indexSum = i + j;
                } else if (i + j == indexSum) {
                    ret.add(list2[i]);
                }
            }
        }
        return ret.toArray(new String[0]);
    }

    /**
     * 646. Maximum Length of Pair Chain
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int curr = Integer.MIN_VALUE, res = 0;
        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }
        return res;
    }

    private Map<String, Pair<TreeNode, Integer>> seen = new HashMap<>();
    private Set<TreeNode> repeat = new HashSet<>();
    private int findDuplicateSubtreesIndex = 0;

    private int findDuplicateSubtreesDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] triple = { root.val, findDuplicateSubtreesDfs(root.left), findDuplicateSubtreesDfs(root.right) };
        String hash = Arrays.toString(triple);
        if (seen.containsKey(hash)) {
            Pair<TreeNode, Integer> pair = seen.get(hash);
            repeat.add(pair.getKey());
            return pair.getValue();
        } else {
            seen.put(hash, new Pair<>(root, ++findDuplicateSubtreesIndex));
            return findDuplicateSubtreesIndex;
        }
    }

    /**
     * 652. Find Duplicate Subtrees
     * 
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDuplicateSubtreesDfs(root);
        return new ArrayList<>(repeat);
    }

    /**
     * 654. Maximum Binary Tree
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        List<Integer> stack = new ArrayList<>();
        TreeNode[] tree = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.get(stack.size() - 1)]) {
                tree[i].left = tree[stack.get(stack.size() - 1)];
                stack.remove(stack.size() - 1);
            }
            if (!stack.isEmpty()) {
                tree[stack.get(stack.size() - 1)].right = tree[i];
            }
            stack.add(i);
        }
        return tree[stack.get(0)];
    }

    class Tuple {
        TreeNode node;
        int row;
        int column;

        public Tuple(TreeNode node, int row, int column) {
            this.node = node;
            this.row = row;
            this.column = column;
        }
    }

    /**
     * 655. Print Binary Tree
     *
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        int height = calculateDepth(root);
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                row.add("");
            }
            res.add(row);
        }
        Queue<Tuple> queue = new ArrayDeque<>();
        queue.offer(new Tuple(root, 0, (n - 1) / 2));
        while (!queue.isEmpty()) {
            Tuple temp = queue.poll();
            TreeNode node = temp.node;
            int row = temp.row;
            int column = temp.column;
            res.get(row).set(column, Integer.toString(node.val));
            if (node.left != null) {
                queue.offer(new Tuple(node.left, row + 1, column - (1 << (height - row - 1))));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, row + 1, column + (1 << (height - row - 1))));
            }
        }
        return res;
    }

    /**
     * Calculate the depth of a binary tree
     *
     * @param root
     * @return
     */
    private int calculateDepth(TreeNode root) {
        int res = -1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            res++;
            while (len > 0) {
                len--;
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return res;
    }

    /**
     * 658. Find K Closest Elements
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        int n = arr.length;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= n || x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    private int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    Map<Integer, Integer> levelMin = new HashMap<>();

    private int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index);
        return Math.max(index - levelMin.get(depth) + 1,
                Math.max(
                        dfs(node.left, depth + 1, index * 2),
                        dfs(node.right, depth + 1, index * 2 + 1)));
    }

    /**
     * 662. Maximum Width of Binary Tree
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    /**
     * 665. Non-decreasing Array
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }

    /**
     * 667. Beautiful Arrangement II
     *
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int index = 0;
        for (int i = 1; i < n - k; i++) {
            res[index++] = i;
        }
        for (int i = n - k, j = n; i <= j; i++, j--) {
            res[index++] = i;
            if (i != j) {
                res[index++] = j;
            }
        }
        return res;
    }

    /**
     * 669. Trim a Binary Search Tree
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if (root == null) {
            return null;
        }
        for (TreeNode node = root; node.left != null;) {
            if (node.left.val < low) {
                node.left = node.left.right;
            } else {
                node = node.left;
            }
        }
        for (TreeNode node = root; node.right != null;) {
            if (node.right.val > high) {
                node.right = node.right.left;
            } else {
                node = node.right;
            }
        }
        return root;
    }

    /**
     * 670. Maximum Swap
     *
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int maxIndex = n - 1;
        int index1 = -1, index2 = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (chars[i] > chars[maxIndex]) {
                maxIndex = i;
            } else if (chars[i] < chars[maxIndex]) {
                index1 = i;
                index2 = maxIndex;
            }
        }
        if (index1 >= 0) {
            Util.swap(chars, index1, index2);
            return Integer.parseInt(new String(chars));
        }
        return num;
    }

    /**
     * 672. Bulb Switcher II
     *
     * @param n
     * @param presses
     * @return
     */
    public int flipLights(int n, int presses) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 1 << 4; i++) {
            int[] pressArray = new int[4];
            for (int j = 0; j < 4; j++) {
                pressArray[j] = i >> j & 1;
            }
            int sum = Arrays.stream(pressArray).sum();
            if (sum % 2 == presses % 2 && sum <= presses) {
                int status = pressArray[0] ^ pressArray[1] ^ pressArray[3];
                if (n >= 2) {
                    status |= (pressArray[0] ^ pressArray[1]) << 1;
                }
                if (n >= 3) {
                    status |= (pressArray[0] ^ pressArray[2]) << 2;
                }
                if (n >= 4) {
                    status |= status << 3;
                }
                seen.add(status);
            }
        }
        return seen.size();
    }

    /**
     * 682. Baseball Game
     *
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int ret = 0;
        List<Integer> points = new ArrayList<>();
        for (String op : ops) {
            int n = points.size();
            switch (op.charAt(0)) {
                case '+' -> {
                    ret += points.get(n - 1) + points.get(n - 2);
                    points.add(points.get(n - 1) + points.get(n - 2));
                }
                case 'D' -> {
                    ret += 2 * points.get(n - 1);
                    points.add(2 * points.get(n - 1));
                }
                case 'C' -> {
                    ret -= points.get(n - 1);
                    points.remove(n - 1);
                }
                default -> {
                    ret += Integer.parseInt(op);
                    points.add(Integer.parseInt(op));
                }
            }
        }
        return ret;
    }

    private int longestUnivaluePathDfsRes;

    private int longestUnivaluePathDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestUnivaluePathDfs(root.left), right = longestUnivaluePathDfs(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        longestUnivaluePathDfsRes = Math.max(longestUnivaluePathDfsRes, left1 + right1);
        return Math.max(left1, right1);
    }

    /**
     * 687. Longest Univalue Path
     *
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePathDfsRes = 0;
        longestUnivaluePathDfs(root);
        return longestUnivaluePathDfsRes;
    }

    /**
     * 720. Longest Word in Dictionary
     *
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        String longest = "";
        for (String word : words) {
            if (trie.search(word)) {
                if (word.length() > longest.length()
                        || (word.length() == longest.length() && word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }
        return longest;
    }

    /**
     * 769. Max Chunks To Make Sorted
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int m = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                res++;
            }
        }
        return res;
    }

    /**
     * 777. Swap Adjacent in LR String
     *
     * @param start
     * @param end
     * @return
     */
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                char c = start.charAt(i);
                if (c != end.charAt(j)) {
                    return false;
                }
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }

    /**
     * 779. K-th Symbol in Grammar
     *
     * @param n
     * @param k
     * @return
     */
    public int kthGrammar(int n, int k) {
        k--;
        int res = 0;
        while (k > 0) {
            k &= k - 1;
            res ^= 1;
        }
        return res;
    }

    private long zeta(long x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }

    private long nx(int x) {
        long left = 0, right = 5L * x;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (zeta(mid) < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }

    /**
     * 793. Preimage Size of Factorial Zeroes Function
     *
     * @param k
     * @return
     */
    public int preimageSizeFZF(int k) {
        return (int) (nx(k + 1) - nx(k));
    }

    /**
     * 801. Minimum Swaps To Make Sequences Increasing
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                a = Math.min(a, at);
                b = Math.min(b, bt + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }
        return Math.min(a, b);
    }

    /**
     * 804. Unique Morse Code Words
     *
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.." };
        Set<String> seen = new HashSet<>();
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                code.append(MORSE[c - 'a']);
            }
            seen.add(code.toString());
        }
        return seen.size();
    }

    /**
     * 806. Number of Lines To Write String
     *
     * @param widths
     * @param s
     * @return
     */
    public int[] numberOfLines(int[] widths, String s) {
        final int MAX_WIDTH = 100;
        int lines = 1, width = 0;
        for (char c : s.toCharArray()) {
            int need = widths[c - 'a'];
            width += need;
            if (width > MAX_WIDTH) {
                width = need;
                lines++;
            }
        }
        return new int[] { lines, width };
    }

    /**
     * 807.Max Increase to Keep City Skyline
     *
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return ans;
    }

    /**
     * 811. Subdomain Visit Count
     *
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> counter = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int space = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, space));
            String domain = cpdomain.substring(space + 1);
            counter.put(domain, counter.getOrDefault(domain, 0) + count);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    counter.put(subdomain, counter.getOrDefault(subdomain, 0) + count);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            String subdomain = entry.getKey();
            int count = entry.getValue();
            res.add(count + " " + subdomain);
        }
        return res;
    }

    /**
     * 817. Linked List Components
     *
     * @param head
     * @param nums
     * @return
     */
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        boolean inSet = false;
        int res = 0;
        while (head != null) {
            if (numsSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    res++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return res;
    }

    /**
     * 819. Most Common Word
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        int maxFrequency = 0;
        Map<String, Integer> frequencies = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int length = paragraph.length();
        for (int i = 0; i <= length; ++i) {
            if (i < length && Character.isLetter(paragraph.charAt(i))) {
                sb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else if (sb.length() > 0) {
                String word = sb.toString();
                if (!bannedSet.contains(word)) {
                    int frequency = frequencies.getOrDefault(word, 0) + 1;
                    frequencies.put(word, frequency);
                    maxFrequency = Math.max(maxFrequency, frequency);
                }
                sb.setLength(0);
            }
        }
        String mostCommon = "";
        Set<Map.Entry<String, Integer>> entries = frequencies.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            if (frequency == maxFrequency) {
                mostCommon = word;
                break;
            }
        }
        return mostCommon;
    }

    /**
     * 828. Count Unique Characters of All Substrings of a Given String
     *
     * @param s
     * @return
     */
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }

    /**
     * 838. Push Dominoes
     *
     * @param dominoes
     * @return
     */
    public String PushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int n = s.length, i = 0;
        char left = 'L';
        while (i < n) {
            int j = i;
            while (j < n && s[j] == '.') {
                j++;
            }
            char right = j < n ? s[j] : 'R';
            if (left == right) {
                while (i < j) {
                    s[i++] = right;
                }
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    s[i++] = 'R';
                    s[k--] = 'L';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(s);
    }

    /**
     * 846. Hand of Straights
     *
     * @param hand
     * @param groupSize
     * @return
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int x : hand) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (int x : hand) {
            if (!count.containsKey(x)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int num = x + j;
                if (!count.containsKey(num)) {
                    return false;
                }
                count.put(num, count.get(num) - 1);
                if (count.get(num) == 0) {
                    count.remove(num);
                }
            }
        }
        return true;
    }

    /**
     * 856. Score of Parentheses
     *
     * @param s
     * @return
     */
    public int scoreOfParentheses(String s) {
        int bal = 0, n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                res += 1 << bal;
            }
        }
        return res;
    }

    /**
     * 857. Minimum Cost to Hire K Workers
     *
     * @param quality
     * @param wage
     * @param k
     * @return
     */
    public double minCostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] hire = new Integer[n];
        for (int i = 0; i < n; i++) {
            hire[i] = i;
        }
        Arrays.sort(hire, (a, b) -> quality[b] * wage[a] - quality[a] * wage[b]);
        double res = 1e9;
        double totalQuality = 0.0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            totalQuality += quality[hire[i]];
            pq.offer(quality[hire[i]]);
        }
        for (int i = k - 1; i < n; i++) {
            int index = hire[i];
            totalQuality += quality[index];
            pq.offer(quality[index]);
            double totalc = ((double) wage[index] / quality[index]) * totalQuality;
            res = Math.min(res, totalc);
            totalQuality -= pq.poll();
        }
        return res;
    }

    /**
     * 870. Advantage Shuffle
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] index1 = new Integer[n];
        Integer[] index2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            index1[i] = i;
            index2[i] = i;
        }
        Arrays.sort(index1, Comparator.comparingInt(i -> nums1[i]));
        Arrays.sort(index2, Comparator.comparingInt(i -> nums2[i]));

        int[] res = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[index1[i]] > nums2[index2[left]]) {
                res[index2[left]] = nums1[index1[i]];
                left++;
            } else {
                res[index2[right]] = nums1[index1[i]];
                right--;
            }
        }
        return res;
    }

    /**
     * 876. Middle of the Linked List
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 886. Possible Bipartition
     *
     * @param n
     * @return
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        for (int i = 1; i <= n; ++i) {
            if (color[i] == 0) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int t = queue.poll();
                    for (int next : g[t]) {
                        if (color[next] > 0 && color[next] == color[t]) {
                            return false;
                        }
                        if (color[next] == 0) {
                            color[next] = 3 ^ color[t];
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 902. Numbers At Most N Given Digit Set
     *
     * @param digits
     * @param n
     * @return
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = Integer.toString(n);
        int m = digits.length, k = s.length();
        List<Integer> bits = new ArrayList<>();
        boolean isLimit = true;
        for (int i = 0; i < k; i++) {
            if (!isLimit) {
                bits.add(m - 1);
            } else {
                int selectIndex = -1;
                for (int j = 0; j < m; j++) {
                    if (digits[j].charAt(0) <= s.charAt(i)) {
                        selectIndex = j;
                    } else {
                        break;
                    }
                }
                if (selectIndex >= 0) {
                    bits.add(selectIndex);
                    if (digits[selectIndex].charAt(0) < s.charAt(i)) {
                        isLimit = false;
                    }
                } else {
                    int len = bits.size();
                    while (!bits.isEmpty() && bits.get(bits.size() - 1) == 0) {
                        bits.remove(bits.size() - 1);
                    }
                    if (!bits.isEmpty()) {
                        bits.set(bits.size() - 1, bits.get(bits.size() - 1) - 1);
                    } else {
                        len--;
                    }
                    while (bits.size() <= len) {
                        bits.add(m - 1);
                    }
                    isLimit = false;
                }
            }
        }
        int res = 0;
        for (Integer bit : bits) {
            res = res * m + (bit + 1);
        }
        return res;
    }

    /**
     * 904. Fruit Into Baskets
     *
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> counter = new HashMap<>();
        int left = 0, res = 0;
        for (int right = 0; right < n; ++right) {
            counter.put(fruits[right], counter.getOrDefault(fruits[right], 0) + 1);
            while (counter.size() > 2) {
                counter.put(fruits[left], counter.get(fruits[left]) - 1);
                if (counter.get(fruits[left]) == 0) {
                    counter.remove(fruits[left]);
                }
                ++left;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    /**
     * 905. Sort Array By Parity
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 1) {
                right++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    /**
     * 915. Partition Array into Disjoint Intervals
     *
     * @param nums
     * @return
     */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curr = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curr = Math.max(curr, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curr;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }

    /**
     * 921. Minimum Add to Make Parentheses Valid
     *
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        int res = 0;
        int leftCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftCount++;
            } else {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    res++;
                }
            }
        }
        res += leftCount;
        return res;
    }

    /**
     * 927. Three Equal Parts
     *
     * @param arr
     * @return
     */
    public int[] threeEqualParts(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int[] errorArray = new int[] { -1, -1 };
        if (sum % 3 != 0) {
            return errorArray;
        }
        if (sum == 0) {
            return new int[] { 0, 2 };
        }
        int partial = sum / 3;
        int first = 0, second = 0, third = 0, curr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (curr == 0) {
                    first = i;
                } else if (curr == partial) {
                    second = i;
                } else if (curr == 2 * partial) {
                    third = i;
                }
                curr++;
            }
        }
        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (third + i < arr.length) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return errorArray;
                }
                i++;
            }
            return new int[] { first + len - 1, second + len };
        }
        return errorArray;
    }

    /**
     * 940. Distinct Subsequences II
     *
     * @param s
     * @return
     */
    public int distinctSubseqII(String s) {
        final int MOD = 1000000007;
        int[] alphas = new int[26];
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            int oi = s.charAt(i) - 'a';
            int prev = alphas[oi];
            alphas[oi] = (res + 1) % MOD;
            res = ((res + alphas[oi] - prev) % MOD + MOD) % MOD;
        }
        return res;
    }

    /**
     * 944. Delete Columns to Make Sorted
     *
     * @param strs
     * @return
     */
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        int ans = 0;
        for (int j = 0; j < col; ++j) {
            for (int i = 1; i < row; ++i) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 946. Validate Stack Sequences
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; ++i) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 961. N-Repeated Element in Size 2N Array
     *
     * @param nums
     * @return
     */
    public int repeatedNTimes(int[] nums) {
        Set<Integer> found = new HashSet<>();
        for (int num : nums) {
            if (!found.add(num)) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 998. Maximum Binary Tree II
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode curr = root;
        while (curr != null) {
            if (val > curr.val) {
                if (parent == null) {
                    return new TreeNode(val, root, null);
                }
                parent.right = new TreeNode(val, curr, null);
                return root;
            } else {
                parent = curr;
                curr = curr.right;
            }
        }
        parent.right = new TreeNode(val);
        return root;
    }

    /**
     * 1380. Lucky Numbers in a Matrix
     *
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] minRow = new int[m];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        int[] maxCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }

    /**
     * 1403. Minimum Subsequence in Non-Increasing Order
     *
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int curr = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            curr += nums[i];
            ans.add(nums[i]);
            if (total - curr < curr) {
                break;
            }
        }
        return ans;
    }

    /**
     * 1408. String Matching in an Array
     *
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words.length; ++j) {
                if (i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 1441. Build an Array With Stack Operations
     *
     * @param target
     * @param n
     * @return
     */
    public List<String> buildArray(int[] target, int n) {
        int prev = 0;
        List<String> res = new ArrayList<>();
        for (int number : target) {
            for (int i = 0; i < number - prev - 1; i++) {
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");
            prev = number;
        }
        return res;
    }

    /**
     * 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
     *
     * @param sentence
     * @param searchWord
     * @return
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        int n = sentence.length(), index = 1, start = 0, end = 0;
        while (start < n) {
            while (end < n && sentence.charAt(end) != ' ') {
                end++;
            }
            if (isPrefix(sentence, start, end, searchWord)) {
                return index;
            }
            index++;
            end++;
            start = end;
        }
        return -1;
    }

    private boolean isPrefix(String sentence, int start, int end, String searchWord) {
        for (int i = 0; i < searchWord.length(); ++i) {
            if (start + i >= end || sentence.charAt(start + i) != searchWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1460. Make Two Arrays Equal by Reversing Sub-arrays
     *
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    /**
     * 1464. Maximum Product of Two Elements in an Array
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int a = nums[0], b = nums[1];
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
            } else if (nums[i] > b) {
                b = nums[i];
            }
        }
        return (a - 1) * (b - 1);
    }

    /**
     * 1470. Shuffle the Array
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[n * 2];
        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[i + n];
        }
        return res;
    }

    /**
     * 1475. Final Prices With a Special Discount in a Shop
     *
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return res;
    }

    /**
     * 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
     *
     * @param s
     * @return
     */
    public String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ch++) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }

    /**
     * 1582. Special Positions in a Binary Matrix
     *
     * @param mat
     * @return
     */
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (i == 0) {
                count--;
            }
            if (count > 0) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        mat[0][j] += count;
                    }
                }
            }
        }
        int sum = 0;
        for (int num : mat[0]) {
            if (num == 1) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 1592. Rearrange Spaces Between Words
     *
     * @param text
     * @return
     */
    public String reorderSpaces(String text) {
        int length = text.length();
        String[] words = text.trim().split("\\s+");
        int spaceCount = length;
        for (String word : words) {
            spaceCount -= word.length();
        }
        StringBuilder sb = new StringBuilder();
        if (words.length == 1) {
            sb.append(words[0]);
            sb.append(" ".repeat(Math.max(0, spaceCount)));
            return sb.toString();
        }
        int perSpace = spaceCount / (words.length - 1);
        int restSpace = spaceCount % (words.length - 1);
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                sb.append(" ".repeat(Math.max(0, perSpace)));
            }
            sb.append(words[i]);
        }
        sb.append(" ".repeat(Math.max(0, restSpace)));
        return sb.toString();
    }

    /**
     * 1598. Crawler Log Folder
     *
     * @param logs
     * @return
     */
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if ("./".equals(log)) {
                continue;
            } else if ("../".equals(log)) {
                if (depth > 0) {
                    depth--;
                }
            } else {
                depth++;
            }
        }
        return depth;
    }

    /**
     * 1608. Special Array With X Elements Greater Than or Equal X
     *
     * @param nums
     * @return
     */
    public int specialArray(int[] nums) {
        Arrays.stream(nums).boxed().sorted((a, b) -> b - a).mapToInt(x -> x).toArray();
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 1619. Mean of Array After Removing Some Elements
     *
     * @param arr
     * @return
     */
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = n / 20; i < (19 * n / 20); i++) {
            sum += arr[i];
        }
        return sum / (n * 0.9);
    }

    /**
     * 1624. Largest Substring Between Two Equal Characters
     *
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] dic = new int[26];
        Arrays.fill(dic, -1);
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (dic[c] < 0) {
                dic[c] = i;
            } else {
                res = Math.max(res, i - dic[c] - 1);
            }
        }
        return res;
    }

    /**
     * 1636. Sort Array by Increasing Frequency
     *
     * @param nums
     * @return
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((a, b) -> {
            int count1 = count.get(a), count2 = count.get(b);
            return count1 != count2 ? count1 - count2 : b - a;
        });
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    /**
     * 1658. Minimum Operations to Reduce X to Zero
     *
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum < x) {
            return -1;
        }

        int right = 0;
        int left_sum = 0, right_sum = sum;
        int res = n + 1;

        for (int left = -1; left < n; ++left) {
            if (left != -1) {
                left_sum += nums[left];
            }
            while (right < n && left_sum + right_sum > x) {
                right_sum -= nums[right];
                ++right;
            }
            if (left_sum + right_sum == x) {
                res = Math.min(res, (left + 1) + (n - right));
            }
        }

        return res > n ? -1 : res;
    }

    /**
     * 1694. Reformat Phone Number
     *
     * @param number
     * @return
     */
    public String reformatNumber(String number) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < number.length(); ++i) {
            char ch = number.charAt(i);
            if (Character.isDigit(ch)) {
                digits.append(ch);
            }
        }
        int n = digits.length();
        int pt = 0;
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            if (n > 4) {
                res.append(digits.substring(pt, pt + 3)).append("-");
                pt += 3;
                n -= 3;
            } else {
                if (n == 4) {
                    res.append(digits.substring(pt, pt + 2)).append("-").append(digits.substring(pt + 2, pt + 4));
                } else {
                    res.append(digits.substring(pt, pt + n));
                }
                break;
            }
        }
        return res.toString();
    }

    /**
     * 1700. Number of Students Unable to Eat Lunch
     *
     * @param students
     * @param sandwiches
     * @return
     */
    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int sandwich : sandwiches) {
            if (sandwich == 0 && s0 > 0) {
                s0--;
            } else if (sandwich == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }

    /**
     * 1750. Minimum Length of String After Deleting Similar Ends
     *
     * @param s
     * @return
     */
    public int minimumLength(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char c = s.charAt(left);
            while (left <= right && s.charAt(left) == c) {
                left++;
            }
            while (left <= right && s.charAt(right) == c) {
                right--;
            }
        }
        return right - left + 1;
    }

    /**
     * 1768. Merge Strings Alternately
     *
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                res.append(word1.charAt(i));
                i++;
            }
            if (j < n) {
                res.append(word2.charAt(j));
                j++;
            }
        }
        return res.toString();
    }

    /**
     * 1784. Check if Binary String Has at Most One Segment of Ones
     *
     * @param s
     * @return
     */
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    /**
     * 1790. Check if One String Swap Can Make Strings Equal
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff.size() >= 2) {
                    return false;
                }
                diff.add(i);
            }
        }
        if (diff.isEmpty()) {
            return true;
        }
        if (diff.size() != 2) {
            return false;
        }
        return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) && s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
    }

    /**
     * 1802. Maximum Value at a Given Index in a Bounded Array
     *
     * @param n
     * @param index
     * @param maxSum
     * @return
     */
    public int maxValue(int n, int index, int maxSum) {
        double left = index;
        double right = n - index - 1;
        if (left > right) {
            double temp = left;
            left = right;
            right = temp;
        }

        double v = ((left + 1) * (left + 1) - 3 * (left + 1)) / 2;
        double upper = v + left + 1 + (left + 1) + v + right + 1;
        if (upper >= maxSum) {
            double a = 1;
            double b = -2;
            double c = left + right + 2 - maxSum;
            return (int) Math.floor((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
        }

        upper = ((double) 2 * (right + 1) - left - 1) * left / 2 + (right + 1)
                + ((right + 1) * (right + 1) - 3 * (right + 1)) / 2 + right + 1;
        if (upper >= maxSum) {
            double a = 1.0 / 2;
            double b = left + 1 - 3.0 / 2;
            double c = right + 1 + (-left - 1) * left / 2 - maxSum;
            return (int) Math.floor((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
        } else {
            double a = left + right + 1;
            double b = (-left * left - left - right * right - right) / 2 - maxSum;
            return (int) Math.floor(-b / a);
        }
    }

    /**
     * 1823. Find the Winner of the Circular Game
     *
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner(int n, int k) {
        int winner = 1;
        for (int i = 2; i <= n; ++i) {
            winner = (k + winner - 1) % i + 1;
        }
        return winner;
    }

    /**
     * 1991. Find the Middle Index in Array
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    /**
     * 2006. Count Number of Pairs With Absolute Difference K
     *
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            ans += cnt.getOrDefault(num - k, 0) + cnt.getOrDefault(num + k, 0);
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        return ans;
    }

    /**
     * 2011. Final Value of Variable After Performing Operations
     *
     * @param operations
     * @return
     */
    public int finalValueAfterOperations(String[] operations) {
        return Arrays.stream(operations)
                .mapToInt(op -> 44 - op.charAt(1))
                .sum();
    }

    /**
     * 2027. Minimum Moves to Convert String
     *
     * @param s
     * @return
     */
    public int minimumMoves(String s) {
        int count = -1, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X' && i > count) {
                res++;
                count = i + 2;
            }
        }
        return res;
    }

    /**
     * 2032. Two Out of Three
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @return
     */
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) | 2);
        }
        for (int i : nums3) {
            map.put(i, map.getOrDefault(i, 0) | 4);
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            if ((v & (v - 1)) != 0) {
                res.add(k);
            }
        }
        return res;
    }

    /**
     * 2037. Minimum Number of Moves to Seat Everyone
     *
     * @param seats
     * @param students
     * @return
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }

    /**
     * 2042. Check if Numbers Are Ascending in a Sentence
     *
     * @param s
     * @return
     */
    public boolean areNumberAscending(String s) {
        int prev = 0, pos = 0, n = s.length();
        while (pos < n) {
            if (Character.isDigit(s.charAt(pos))) {
                int curr = 0;
                while (pos < n && Character.isDigit(s.charAt(pos))) {
                    curr = curr * 10 + s.charAt(pos) - '0';
                    pos++;
                }
                if (curr <= prev) {
                    return false;
                }
                prev = curr;
            } else {
                pos++;
            }
        }
        return true;
    }

    /**
     * 2044. Count Number of Maximum Bitwise-OR Subsets
     *
     * @param nums
     * @return
     */
    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        this.maxOr = 0;
        this.cnt = 0;
        dfs(0, 0);
        return cnt;
    }

    int[] nums;
    int maxOr, cnt;

    private void dfs(int pos, int orVal) {
        if (pos == nums.length) {
            if (orVal > maxOr) {
                maxOr = orVal;
                cnt = 1;
            } else if (orVal == maxOr) {
                cnt++;
            }
            return;
        }
        dfs(pos + 1, orVal | nums[pos]);
        dfs(pos + 1, orVal);
    }

    /**
     * 2055. Plates Between Candles
     *
     * @param s
     * @param queries
     * @return
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }

    /**
     * 2180. Count Integers With Even Digit Sum
     *
     * @param num
     * @return
     */
    public int countEven(int num) {
        int y = num / 10, x = num % 10;
        int res = y * 5, ySum = 0;
        while (y > 0) {
            ySum += y % 10;
            y /= 10;
        }
        if (ySum % 2 == 0) {
            res += x / 2 + 1;
        } else {
            res += (x + 1) / 2;
        }
        return res - 1;
    }

    /**
     * 2185. Counting Words With a Given Prefix
     *
     * @param words
     * @param pref
     * @return
     */
    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words)
                .filter(word -> word.startsWith(pref))
                .count();
    }

    /**
     * 2351. First Letter to Appear Twice
     *
     * @param s
     * @return
     */
    public char repeatedCharacter(String s) {
        int seen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if ((seen & (1 << index)) > 0) {
                return ch;
            }
            seen |= 1 << index;
        }
        return ' ';
    }
}
