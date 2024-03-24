// SOURCE
// https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array

import java.util.Random;

public class Util {
    private static Random random;
    public static void shuffle(int[] array) {
        if (random == null) random = new Random();
        int count = array.length;
        for (int i = count; i > 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
