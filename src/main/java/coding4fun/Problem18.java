package coding4fun;

/**
 * Find the contiguous subarray within an array which has the largest sum.
 * 
 * <pre>
 * Input : -2, 1, -3, 4, -1, 2, 1, -5, 4
 * Output: start = 3, end = 6, max = 6
 * 
 * Input : 4, -1, 2, 1
 * Output: start = 0, end = 3, max = 10
 * </pre>
 */
public class Problem18 {
    public static class Result {
        public final int start;
        public final int end;
        public final int max;
        
        public Result(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.max = value;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Result [start=");
            builder.append(start);
            builder.append(", end=");
            builder.append(end);
            builder.append(", max=");
            builder.append(max);
            builder.append("]");
            return builder.toString();
        }
    }
    
    public static Result maxSubArray(int[] nums) {
        int tmpMax = nums[0];
        int max = nums[0];
        int startIdx = 0;
        int endIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmpMax + nums[i] < nums[i]) {
                startIdx = i;
                tmpMax = nums[i];
            } else {
                tmpMax = tmpMax + nums[i];
            }
            if (max < tmpMax) {
                endIdx = i;
                max = tmpMax;
            }
        }
        return new Result(startIdx, endIdx, max);
    }
    
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{4, -1, 2, 1}));
    }
}
