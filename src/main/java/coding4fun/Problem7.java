package coding4fun;

/**
 * Reverse a string in-place.
 * 
 * Input: Hi there, hello world
 * Output: dlrow olleh ,ereht iH
 */
public class Problem7 {
    private static void reverse(char[] string) {
        for (int i = 0; i < string.length/2; i++) {
            char tmp = string[i];
            string[i] = string[string.length-1-i];
            string[string.length-1-i] = tmp;
        }
    }
    
    public static void main(String[] args) {
        String str = "Hi there, hello world";
        char[] chrArray = str.toCharArray();
        reverse(chrArray);
        System.out.println(chrArray);
    }
}
