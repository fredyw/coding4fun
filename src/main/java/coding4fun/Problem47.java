package coding4fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Finds the longest increasing subsequence.
 *
 * <pre>
 * Input : [2, 4, 4, 5, 6, 1, 2, 7, 6, 10]
 * Output: [2, 4, 5, 6, 7, 10]
 *
 * Input : [4, 4, 4, 5, 6, 1, 2, 3, 4, 7, 6, 10]
 * Output: [1, 2, 3, 4, 7, 10]
 *
 * Input : [1, 2, 13, 16, 6, 7, 10]
 * Output: [1, 2, 6, 7, 10]
 * </pre>
 */
public class Problem47 {
    private static List<Integer> longestIncreasingSubsequence(List<Integer> nums) {
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = longestIncreasingSubsequence(nums, i, new HashMap<>());
            list.add(nums.get(i));
            Collections.reverse(list);
            if (max.size() < list.size()) {
                max = list;
            }
        }
        return max;
    }

    private static List<Integer> longestIncreasingSubsequence(List<Integer> nums, int idx,
                                                              Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        List<Integer> max = new ArrayList<>();
        int num = nums.get(idx);
        for (int i = idx + 1; i < nums.size(); i++) {
            if (num < nums.get(i)) {
                List<Integer> list = longestIncreasingSubsequence(nums, i, memo);
                List<Integer> newList = new ArrayList<>(list);
                newList.add(nums.get(i));
                if (max.size() < newList.size()) {
                    max = newList;
                }
            }
        }
        memo.put(idx, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(
            Arrays.asList(2, 4, 4, 5, 6, 1, 2, 7, 6, 10))); // [2, 4, 5, 6, 7, 10]
        System.out.println(longestIncreasingSubsequence(
            Arrays.asList(4, 4, 4, 5, 6, 1, 2, 3, 4, 7, 6, 10))); // [1, 2, 3, 4, 7, 10]
        System.out.println(longestIncreasingSubsequence(
            Arrays.asList(1, 2, 13, 16, 6, 7, 10))); // [1, 2, 6, 7, 10]
    }
}
