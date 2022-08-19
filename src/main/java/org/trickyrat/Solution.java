package org.trickyrat;

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
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = 2 * r - 2;
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < n - i; j += t) {
                ans.append(s.charAt(j + i));
                if (0 < i && i < r - 1 && j + t - i < n) {
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
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
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
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetNum);
        dfs(root.right, targetNum);
        path.pollLast();
    }

    /**
     * 357. Count Numbers with Unique Digits
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
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; ++i) {
            ret.add(num);
            if(num * 10 <= n) {
                num *= 10;
            } else {
                while(num % 10 == 9 || num + 1 > n) {
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
        for (int i = 0; i < data.length; i++) {
            if (n > 0) {
                if (data[i] >> 6 != 2) return false;
                n--;
            } else if (data[i] >> 7 == 0) {
                n = 0;
            } else if (data[i] >> 5 == 0b110) {
                n = 1;
            } else if (data[i] >> 4 == 0b1110) {
                n = 2;
            } else if (data[i] >> 3 == 0b11110) {
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
     * 467. Unique Substrings in Wraparound String
     * @param p
     * @return
     */
    public int findSubstringInWraparoundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for(int i = 0; i < p.length(); ++i) {
            if(i>0&&(p.charAt(i) - p.charAt(i-1) + 26) % 26 == 1) {
                ++k;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
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
        StringBuffer digits = new StringBuffer();
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
        String[] complex1 = num1.split("\\+|i");
        String[] complex2 = num2.split("\\+|i");
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
            return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        }
        StringBuffer res = new StringBuffer();
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
        return ret.toArray(new String[ret.size()]);
    }

    /**
     * 654. Maximum Binary Tree
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
            if(!stack.isEmpty()) {
                tree[stack.get(stack.size() - 1)].right = tree[i];
            }
            stack.add(i);
        }
        return tree[stack.get(0)];
    }

    /**
     * 682. Baseball Game
     *
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int ret = 0;
        List<Integer> points = new ArrayList<Integer>();
        for (String op : ops) {
            int n = points.size();
            switch (op.charAt(0)) {
                case '+':
                    ret += points.get(n - 1) + points.get(n - 2);
                    points.add(points.get(n - 1) + points.get(n - 2));
                    break;
                case 'D':
                    ret += 2 * points.get(n - 1);
                    points.add(2 * points.get(n - 1));
                    break;
                case 'C':
                    ret -= points.get(n - 1);
                    points.remove(n - 1);
                    break;
                default:
                    ret += Integer.parseInt(op);
                    points.add(Integer.parseInt(op));
                    break;
            }
        }
        return ret;
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
     * 804. Unique Morse Code Words
     *
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};
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
        return new int[]{lines, width};
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
     * 819. Most Common Word
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        int maxFrequency = 0;
        Map<String, Integer> frequencies = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        int length = paragraph.length();
        for (int i = 0; i <= length; ++i) {
            if(i < length && Character.isLetter(paragraph.charAt(i))) {
                sb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else if(sb.length() > 0) {
                String word = sb.toString();
                if(!bannedSet.contains(word)) {
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
     * 905. Sort Array By Parity
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            while(left < right && nums[left] % 2 == 0) {
                left++;
            }
            while(left < right && nums[right] % 2 == 1) {
                right++;
            }
            if(left < right) {
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
     * 944. Delete Columns to Make Sorted
     * @param strs
     * @return
     */
    public int minDeletionSize(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        int ans = 0;
        for (int j = 0; j < col; ++j) {
            for (int i = 1; i < row; ++i) {
                if(strs[i-1].charAt(j) > strs[i].charAt(j)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 961. N-Repeated Element in Size 2N Array
     * @param nums
     * @return
     */
    public int repeatedNTimes(int[] nums) {
        Set<Integer> found = new HashSet<Integer>();
        for(int num : nums) {
            if(!found.add(num)) {
                return num;
            }
        }
        return -1;
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
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; ++i) {
            for(int j = 0; j < words.length; ++j) {
                if(i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
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
     * 1823. Find the Winner of the Circular Game
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
        int ans = 0, n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ans += cnt.getOrDefault(nums[i] - k, 0) + cnt.getOrDefault(nums[i] + k, 0);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        return ans;
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
}
