package string;

/*
    One Array: There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if they are one edit
    (or zero) away.
 */
public class Pr_1_5_p_90 {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "ple"));
        System.out.println(isOneEditAway("ple", "pale"));
        System.out.println(isOneEditAway("a", "aaab"));
        System.out.println(isOneEditAway("pale", "pale"));
        System.out.println(isOneEditAway("pales", "pale"));
        System.out.println(isOneEditAway("pale", "bale"));
        System.out.println(isOneEditAway("pale", "bake"));
        System.out.println(isOneEditAway("cake", "take"));
        System.out.println(isOneEditAway("cake", "taake"));
    }

    private static boolean isOneEditAway(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();

        if (firstLen - secondLen == 1) {
            System.out.println("Is calling isRemove for " + first + " " + second);
            return isAddOrRemove(first, second);
        } else if (firstLen - secondLen == -1) {
            System.out.println("Is calling isAdd for " + first + " " + second);
            return isAddOrRemove(second, first);
        } else if (firstLen == secondLen) {
            return isReplace(first, second);
        }

        System.out.println("No need to bother for " + first + " " + second);
        return false;
    }

    private static boolean isAddOrRemove(String first, String second) {
        int i = 0;
        int j = 0;
        boolean found = false;
        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();
        while (i < firstArr.length && j < secondArr.length) {
            if (firstArr[i] != secondArr[j]) {
                if (found) return false;
                found = true;
                i++;
            } else {
                i++;
                j++;
            }
        }

        return true;
    }

    private static boolean isReplace(String first, String second) {
        System.out.println("Is calling isReplace for " + first + " " + second);
        // Remember that first and second are equal in size
        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();
        int i = 0;
        boolean found = false;
        while (i < firstArr.length) {
            if (firstArr[i] != secondArr[i]) {
                if (found) return false;
                found = true;
            }
            i++;
        }
        return true;
    }
}
