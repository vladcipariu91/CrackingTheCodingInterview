package reader;

import java.util.Scanner;

public class Readers {

    public static int readInt() {
        return readInts(1)[0];
    }

    public static int[] readInts(int count) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = scanner.nextInt();
        }
        scanner.nextLine();

        return ints;
    }
}
