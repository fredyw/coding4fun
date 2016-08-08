package coding4fun;

/**
 * Given a string and a number, and print the string diagonally filling in
 * empty space with periods and going down as many lines as the given number.
 * <p>
 * So "Peter piper picked a peck of pickled peppers" becomes
 * <pre>
 * P.........r......... .........i.........p...
 * .e......... .........p.........c.........e..
 * ..t.........p.........e.........k.........r.
 * ...e.........i.........c.........l.........s
 * ....r.........c.........k.........e.........
 * ..... .........k......... .........d........
 * ......P.........e.........o......... .......
 * .......i.........d.........f.........P......
 * ........p......... ......... .........e.....
 * .........e.........a.........p.........p....
 * </pre>
 */
public class Problem2 {
    public static void main(String[] args) {
        String str = "Peter piper picked a peck of pickled peppers";
        int n = 10;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(".");
            }
            for (int j = 0; j < str.length() - i; j++) {
                if (j % n == 0 && j + i < str.length()) {
                    System.out.print(str.charAt(j + i));
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
