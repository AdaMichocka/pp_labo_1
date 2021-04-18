import java.util.Arrays;

public class Zad_5 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();

    }

    public static long insertionSort(int[] insert) {
        long startTime = System.nanoTime();

        for (int i = 1; i < insert.length; i++) {
            int temp = insert[i];
            int j = i - 1;
            while (j >= 0 && temp <= insert[j]) {
                insert[j + 1] = insert[j];
                j -= 1;
            }
            insert[j + 1] = temp;
        }
        //System.out.println(Arrays.toString(insert));

        return System.nanoTime() - startTime;

    }

    public static void mergeSort(int[] insert, int n) {
        n = insert.length;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = insert[i];
        }

        for (int i = mid; i < n; i++) {
            right[i - mid] = insert[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(insert, left, right, mid, n - mid);

        //System.out.println(Arrays.toString(insert));
    }

    public static void merge(int[] insert, int[] l, int[] r, int left, int rigth) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < rigth) {
            if (l[i] <= r[j]) {
                insert[k++] = l[i++];
            } else {
                insert[k++] = r[j++];
            }
        }
        while (i < left) {
            insert[k++] = l[i++];
        }
        while (j < rigth) {
            insert[k++] = r[j++];
        }
    }

    public static void test1() {
        int[] test1 = new int[100];
        for (int i = test1.length - 1; i >= 0; i--) {
            test1[i] = i;
        }

        System.out.println("Test 1");
        System.out.println("Sortowanie przez wstawianie: " + insertionSort(test1) + " nanosekund");
        long startTime = System.nanoTime();
        //mergeSort(test1, test1.length);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Sortowanie przez scalanie: " + estimatedTime + " nanosekund");
    }

    public static void test2() {
        int[] test2 = new int[100];
        for (int i = 0; i < test2.length; i++) {
            test2[i] = i;
        }

        System.out.println("Test 2");
        System.out.println("Sortowanie przez wstawianie: " + insertionSort(test2) + " nanosekund");
        long startTime = System.nanoTime();
       // mergeSort(test2, test2.length);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Sortowanie przez scalanie: " + estimatedTime + " nanosekund");
    }

    public static void test3() {
        int[] test3 = new int[100];
        for (int i = 0; i < test3.length; i++) {
            test3[i] = (int) (Math.random() * (1000) + 1);

        }

        System.out.println("Test 3");
        System.out.println("Sortowanie przez wstawianie: " + insertionSort(test3) + " nanosekund");
        long startTime = System.nanoTime();
       // mergeSort(test3, test3.length);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Sortowanie przez scalanie: " + estimatedTime + " nanosekund");
    }

}
