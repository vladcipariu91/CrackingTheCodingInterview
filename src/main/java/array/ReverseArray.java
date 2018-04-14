package array;

import reader.Readers;

public class ReverseArray {

    public static void main(String[] args) {
        int count = Readers.readInt();
        int[] intArray = Readers.readInts(count);

        for (int i = 0; i < (intArray.length / 2); i++) {
            int aux = intArray[i];
            int oppositeIndex = intArray.length - i - 1;
            intArray[i] = intArray[oppositeIndex];
            intArray[oppositeIndex] = aux;
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.toString();
    }
}
