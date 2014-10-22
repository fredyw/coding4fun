package coding4fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Print all possible words from phone digits.
 * 
 * <pre>
 * 2 => ('A', 'B', 'C')
 * 3 => ('D', 'E', 'F')
 * 4 => ('G', 'H', 'I')
 * 5 => ('J', 'K', 'L')
 * 6 => ('M', 'N', 'O')
 * 7 => ('P', 'Q', 'R', 'S')
 * 8 => ('T', 'U', 'V')
 * 9 => ('W', 'X', 'Y', 'Z')
 * </pre>
 * 
 * <pre>
 * Input: 8
 * Output: T, U, V
 * 
 * Input: 23
 * Output: AD, BD, CD, AE, BE, CE, AF, BF, CF
 * 
 * Input: 234
 * Output: ADG, BDG, CDG, AEG, BEG, CEG, AFG, BFG, CFG,
 *         ADH, BDH, CDH, AEH, BEH, CEH, AFH, BFH, CFH,
 *         ADI, BDI, CDI, AEI, BEI, CEI, AFI, BFI, CFI
 * </pre>
 */
public class Problem10 {
    private static final Map<Integer, List<Character>> CHARS = new HashMap<>();
    static {
        CHARS.put(2, Arrays.asList('A', 'B', 'C'));
        CHARS.put(3, Arrays.asList('D', 'E', 'F'));
        CHARS.put(4, Arrays.asList('G', 'H', 'I'));
        CHARS.put(5, Arrays.asList('J', 'K', 'L'));
        CHARS.put(6, Arrays.asList('M', 'N', 'O'));
        CHARS.put(7, Arrays.asList('P', 'Q', 'R', 'S'));
        CHARS.put(8, Arrays.asList('T', 'U', 'V'));
        CHARS.put(9, Arrays.asList('W', 'X', 'Y', 'Z'));
    }
    
    private static List<String> getAllPossibleWords(String numbers) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            getAllPossibleWords(numbers,
                Integer.parseInt(numbers.substring(i, i+1)), result);
        }
        return result;
    }
    
    private static void getAllPossibleWords(String numbers, int number,
        List<String> result) {
        List<Character> chars = CHARS.get(number);
        List<String> newWords = new ArrayList<>();
        for (Character c : chars) {
            if (result.isEmpty()) {
                newWords.add(Character.toString(c));
            } else {
                for (String word : result) {
                    newWords.add(word + c);
                }
            }
        }
        result.clear();
        result.addAll(newWords);
    }
    
    public static void main(String[] args) {
        Consumer<String> c = (e) -> {
            System.out.println(" - " + e);
        };
        String numbers = "8";
        System.out.println(numbers + ":");
        getAllPossibleWords(numbers).stream().forEach(c);
        numbers = "23";
        System.out.println(numbers + ":");
        getAllPossibleWords(numbers).stream().forEach(c);
        numbers = "234";
        System.out.println(numbers + ":");
        getAllPossibleWords(numbers).stream().forEach(c);
        numbers = "2637";
        System.out.println(numbers + ":");
        getAllPossibleWords(numbers).stream().forEach(c);
        numbers = "33495";
        System.out.println(numbers + ":");
        getAllPossibleWords(numbers).stream().forEach(c);
    }
}
