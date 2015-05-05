package coding4fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * http://codereview.stackexchange.com/questions/51547/missing-level-of-technical-depth-common-ancestor
 */
public class Problem15 {
    public static String findCommmonAncestor(String[] commitHashes, String[][] parentHashes,
        String commitHash1, String commitHash2) {
        // the key is the commit hash, the value is the index
        // this is for fast lookup
        Map<String, Integer> commitMap = new HashMap<>();
        for (int i = 0; i < commitHashes.length; i++) {
            commitMap.put(commitHashes[i], i);
        }
        List<List<String>> paths = new ArrayList<>();
        List<String> accu1 = new ArrayList<>();
        accu1.add(commitHash1);
        getPaths(commitMap, parentHashes, commitHash1, accu1, paths);
        List<String> accu2 = new ArrayList<>();
        accu2.add(commitHash2);
        getPaths(commitMap, parentHashes, commitHash2, accu2, paths);
        return getCommonAncenstor(paths);
    }
    
    private static String getCommonAncenstor(List<List<String>> paths) {
        int size = Integer.MAX_VALUE;
        for (List<String> path : paths) {
            size = Math.min(size, path.size());
        }
        String result = null;
        for (int i = 1; i <= size; i++) {
            Set<String> set = new HashSet<>();
            for (List<String> path : paths) {
                if (path.size() - i < 0) {
                    continue;
                }
                String commit = path.get(path.size() - i);
                if (set.contains(commit)) {
                    result = commit;
                    break;
                } else {
                    set.add(commit);
                }
            }
        }
        return result;
    }
    
    private static void getPaths(Map<String, Integer> commitMap,
        String[][] parentHashes, String commitHash, List<String> accu,
        List<List<String>> result) {
        int idx = commitMap.get(commitHash);
        String[] parent = parentHashes[idx];
        if (parent == null) {
            result.add(accu);
            return;
        }
        for (String p : parent) {
            List<String> newAccu = new ArrayList<>();
            newAccu.addAll(accu);
            newAccu.add(p);
            getPaths(commitMap, parentHashes, p, newAccu, result);
        }
    }

    public static void main(String[] args) {
        String[] commits = {"G", "F", "E", "D", "C", "B", "A"};
        String[][] parents ={{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null}; 
        String commit1 = "D";
        String commit2 = "F";
        
        String result = findCommmonAncestor(commits, parents, commit1, commit2);
        System.out.println(result);
    }
}
