import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    * 38. Count And Say
    * */
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
            while(p < result.length() && result.charAt(p) == val) {
                p++;
                count++;
            }
            builder.append(count);
            builder.append(val);
        }
        return builder.toString();
    }

    /*
    * 39. Combination Sum
    * */
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
}
