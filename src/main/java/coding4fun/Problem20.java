package coding4fun;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Build a relative path from the given source to the given destination.
 * <p>
 * For simplicity, assume that the file path separator is always /
 * <p>
 * <pre>
 * Input:
 *   - Source     : /a/b/c/d/e
 *   - Destination: /a/b/f/x/y/z
 * Output: ../../../f/x/y/z
 *
 * Input:
 *   - Source     : /a/b/c/d/e
 *   - Destination: /a/b/f
 * Output: ../../../f
 *
 * Input:
 *   - Source     : /a/b/c
 *   - Destination: /x/y/z
 * Output: ../../../x/y/z
 *
 * Input:
 *   - Source     : /a/b/c
 *   - Destination: /a/b/c
 * Output: c
 * </pre>
 */
public class Problem20 {
    public static String getRelativePath(String src, String dest) {
        String[] splitSrc = src.split("/");
        LinkedList<String> srcPath = new LinkedList<>();
        for (String path : splitSrc) {
            srcPath.add(path);
        }
        String[] splitDest = dest.split("/");
        LinkedList<String> destPath = new LinkedList<>();
        for (String path : splitDest) {
            destPath.add(path);
        }
        if (src.equals(dest)) {
            return destPath.peekLast();
        }
        String p1 = srcPath.peekFirst();
        String p2 = destPath.peekFirst();
        while (p1.equals(p2)) {
            srcPath.removeFirst();
            destPath.removeFirst();

            if (srcPath.isEmpty() || destPath.isEmpty()) {
                break;
            }
            p1 = srcPath.peekFirst();
            p2 = destPath.peekFirst();
        }
        StringBuilder relativePath = new StringBuilder();
        for (int i = 0; i < srcPath.size(); i++) {
            relativePath.append("../");
        }
        relativePath.append(destPath.stream().collect(Collectors.joining("/")));
        return relativePath.toString();
    }

    public static void main(String[] args) {
        System.out.println(getRelativePath("/a/b/c/d/e", "/a/b/f/x/y/z"));
        System.out.println(getRelativePath("/a/b/c/d/e", "/a/b/f"));
        System.out.println(getRelativePath("/a/b/c", "/x/y/z"));
        System.out.println(getRelativePath("/a/b/c", "/a/b/c"));
    }
}
