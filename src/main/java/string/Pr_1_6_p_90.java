package string;

/*
    String compression: Implement a method to perform basic string compression using the counts of repeated characters.
    For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not become smaller than
    the original, your method should return the original string. You can assume the string has only uppercase and lowercase
    letters (a-z)
 */
public class Pr_1_6_p_90 {

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("abcd"));
        System.out.println(compress(""));
        System.out.println(compress("a"));
    }

    private static String compress(String input) {
        StringBuilder result = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            counter++;

            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                result.append(input.charAt(i));
                result.append(counter);
                counter = 0;
            }
        }

        return result.length() >= input.length() ? input : result.toString();
    }
}
