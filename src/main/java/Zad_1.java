import java.util.ArrayList;
import java.util.LinkedList;

public class Zad_1 {
    //czas tworzenia
    //tablic
    //kolekcji ArrayList
    //ArrayList z podaniem max rozmiaru
    //LinkedList

    public static void main(String[] args) {
        int n = Integer.MAX_VALUE / 20;
        System.out.println("Rozmiar listy: " + n);
        System.out.println("a) tablica: " + a(n) + " nanosekund");
        System.out.println("b) ArrayList: " + b(n) + " nanosekund");
        System.out.println("c) ArrayList z rozm " + c(n) + " nanosekund");
        System.out.println("d) LinkedList: " + d(n) + " nanosekund");


        //Najszybciej utworzyła się lista za pomocą tablicy, później za pomocą ArrayListy
        // , która jest dynamiczną tablicą. Ta, która miała podany rozmiar na początku utworzyła się szyciej.
        //Najdłuzej tworzyła się lista za pomocą LinkedListy, ponieważ to tablica dwukierunkowa.
    }

    public static long a(int n) {
        long startTime = System.nanoTime();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return System.nanoTime() - startTime;
    }

    public static long b(int n) {
        long startTime = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        return System.nanoTime() - startTime;
    }

    public static long c(int n) {
        long startTime = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        return System.nanoTime() - startTime;
    }

    public static long d(int n) {
        long startTime = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        return System.nanoTime() - startTime;
    }
}
