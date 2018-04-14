package string;

/*
    Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structures?

    Is the string an ASCII or a Unicode string?
 */
public class Pr_1_1_p_90 {

    public static void main(String[] args) {
        System.out.println(isEveryLetterUnique_extraDS("vlad"));
        System.out.println(isEveryLetterUnique_extraDS("vladd"));
        System.out.println(isEveryLetterUnique_extraDS("Vvlad"));

        System.out.println(isEveryLetterUniqueFrom_aToz("vlad"));
        System.out.println(isEveryLetterUniqueFrom_aToz("vladd"));

        System.out.println(isEveryLetterUnique_Ascii("vlad"));
        System.out.println(isEveryLetterUnique_Ascii("vladd"));
        System.out.println(isEveryLetterUnique_Ascii("%vlad%"));
    }

    /*
       Runs under the assumption that the string is encoded with ASCII
    */
    private static boolean isEveryLetterUnique_extraDS(String str) {
        boolean[] checker = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int character = str.charAt(i);
            if (checker[character]) {
                return false;
            }
            checker[character] = true;
        }

        return true;
    }

    private static boolean isEveryLetterUniqueFrom_aToz(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a'; // 'a' = 97
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
        }

        return true;
    }

    private static boolean isEveryLetterUnique_Ascii(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) % 128;
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
        }

        return true;
    }
}
