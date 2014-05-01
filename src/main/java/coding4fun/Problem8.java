package coding4fun;

/**
 * Reverse the order of the words in a string in-place.
 * <pre>
 * Input: hi there programming is such a fun activity
 * Output: activity fun a such is programming there hi
 * </pre>
 */
public class Problem8 {
    private static void reverse(char[] string) {
        reverse(string, 0, string.length);
        int beginIdx = 0;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                reverse(string, beginIdx, i);
                beginIdx = i + 1;
            }
        }
        reverse(string, beginIdx, string.length);
    }
    
    private static void reverse(char[] string, int beginIdx, int endIdx) {
        int mid = beginIdx + ((endIdx - beginIdx) / 2);
        for (int i = beginIdx, j = 0; i < mid; i++, j++) {
            char tmp = string[i];
            string[i] = string[endIdx-1-j];
            string[endIdx-1-j] = tmp;
        }
    }
    
    public static void main(String[] args) {
        String str = "hi there programming is such a fun activity";
        char[] chrArray = str.toCharArray();
        reverse(chrArray);
        System.out.println(chrArray);
    }
}
