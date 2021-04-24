import java.util.Arrays;

public class Zad_5 {
    public void zad5() {
        test1();
        System.out.println();
        test2();
        System.out.println();
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

    public static void merge(int array[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = array[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = array[q + 1 + j];

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int array[], int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    public static void test1() {
        int[] test1 = new int[100];
        for (int i = test1.length - 1; i >= 0; i--) {
            test1[i] = i;
        }

        System.out.println("Test 1: tablica posortowana malejąco (sortujemy rosnąco)");
        System.out.println("Sortowanie przez wstawianie: " + insertionSort(test1) + " nanosekund");
        long startTime = System.nanoTime();
        mergeSort(test1, test1.length, test1.length);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Sortowanie przez scalanie: " + estimatedTime + " nanosekund");
    }

    public static void test2() {
        int[] test2 = new int[100];
        for (int i = 0; i < test2.length; i++) {
            test2[i] = i;
        }

        System.out.println("Test 2: tablica posortowana rosnąco (sortujemy rosnąco)");
        System.out.println("Sortowanie przez wstawianie: " + insertionSort(test2) + " nanosekund");
        long startTime = System.nanoTime();
        mergeSort(test2, test2.length, test2.length);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Sortowanie przez scalanie: " + estimatedTime + " nanosekund");
    }

    public static void test3() {
        int[] test3 = new int[100];
        for (int i = 0; i < test3.length; i++) {
            test3[i] = (int) (Math.random() * (1000) + 1);

        }

        System.out.println("Test 3: tablica wypełniona losowymi danymi (sortujemy rosnąco)");
        System.out.println("Sortowanie przez wstawianie: " + insertionSort(test3) + " nanosekund");
        long startTime = System.nanoTime();
        mergeSort(test3, test3.length, test3.length);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Sortowanie przez scalanie: " + estimatedTime + " nanosekund");
    }

}
