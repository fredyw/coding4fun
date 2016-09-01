package coding4fun;

/**
 * Find the maximum count of the sum of consecutive elements in the array that is divisible
 * by k.
 *
 * <pre>
 * Input:  [1, 2, 3, 4, 1]
 * Output: 4
 * Explanation:
 * 1 + 2
 * 1 + 2 + 3
 * 3
 * 2 + 3 + 4
 *
 * Input:  [1, 2, 3, 4, 1]
 * Output: 4
 * Explanation
 * 1 + 2 + 3 + 4
 * 2 + 3
 * 2 + 3 + 4 + 1
 * 4 + 1
 * </pre>
 */
public class Problem46 {
    private static int kSub(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(kSub(new int[]{1, 2, 3, 4, 1}, 3)); // 4
        System.out.println(kSub(new int[]{1, 2, 3, 4, 1}, 5)); // 4
    }
}
