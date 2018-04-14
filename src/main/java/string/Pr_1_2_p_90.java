package string;

/*
    Given two strings, write a method to determine if one is a permutation of the other.
 */
public class Pr_1_2_p_90 {

    public static void main(String[] args) {
        System.out.println(isPermutation("vlad", "abcd"));
        System.out.println(isPermutation("vlad", "abcd"));

        System.out.println(isPermutation_better("vlad", "dalv"));
        System.out.println(isPermutation_better("vlad", "abcd"));
    }

    private static boolean isPermutation(String a, String b) {
        if (isEmpty(a) || isEmpty(b) || a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            boolean found = false;
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    // Assume that characters are encoded in ASCII
    // Time Complexity O(n), Space Complexity O(n)
    private static boolean isPermutation_better(String a, String b) {
        if (isEmpty(a) || isEmpty(b) || a.length() != b.length()) return false;

        int[] letters = new int[128];
        for (int i = 0; i < a.length(); i++) {
            letters[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            letters[b.charAt(i)]--;
            if (letters[b.charAt(i)] < 0) return false;
        }

        return true;
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

}
