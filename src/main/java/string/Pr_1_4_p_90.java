package string;

/*
    Palindrome permutation: Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
    The palindrome does not need to be limited to just dictionary words.

    EXAMPLE:
    Input: Tact Coa
    Output: True(permutations: "taco cat", "atco cta", etc.)

    #106: You should not have to - and should not - generate all permutations. This would be very inefficient.
    #121: What characteristics would a string that is a permutation of a palindrome have?
    #134: Have you tried a hash table? You should be able to get this down to O(n) time.
    #136: Can you reduce the space usage using a bit vector?
 */
public class Pr_1_4_p_90 {
    public static void main(String[] args) {
        System.out.print(checkMaxOneOdd(buildCharFrequencyTable("tact Coa")));
    }

    // Check that no more than one character has an odd count
    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }

    /*
        Map each character to a number. a -> 0, b -> 1, c -> 2, etc.
        This is case insensitive. Non-letter characters map to -1.
     */
    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }

        return -1;
    }

    // Count how many times each character appears.
    private static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }

        return table;
    }
}
