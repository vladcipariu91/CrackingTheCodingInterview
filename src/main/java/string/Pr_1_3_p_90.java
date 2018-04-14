package string;

/*
    Write a method to replace all spaces in a string with '%20'. You may assume that the string
    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    length of the string. (Note: If implementing in Java, please use a character array so that you can
    perform this operation in place.)

    EXAMPLE:
    Input: "Mr John Smith      ", 13
    Output:  "Mr%20John%20Smith"

    #53: It is often easiest to modify strings by going from the end of the string to the beginning.
    #118: You might find you need to know the number of spaces. Can you count them?
 */
public class Pr_1_3_p_90 {

    public static void main(String[] args) {
        char[] str = new char[]{'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ', ' ', ' '};
        urlify(13, str);
    }

    /*
        Time Complexity O(n) Space Complexity O(1)
     */
    private static char[] urlify(int trueLength, char[] input) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (input[i] == ' ') spaceCount++;
        }

        int index = trueLength + 2 * spaceCount;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[index - 1] = '0';
                input[index - 2] = '2';
                input[index - 3] = '%';
                index = index - 3;
            } else {
                input[index - 1] = input[i];
                index--;
            }

            print(input, index, i);
        }

        return input;
    }

    private static void print(char[] input, int index, int j) {
        for (char anInput : input) {
            System.out.print(anInput);
        }
        System.out.print(" index: " + index + " i: " + j);
        System.out.println();
    }
}
