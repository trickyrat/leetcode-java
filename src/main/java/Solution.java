import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

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
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
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
}
