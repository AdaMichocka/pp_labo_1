import java.math.BigInteger;

public class Zad_2 {

    public static void main(String[] args) {

        //Zastosowanie typów prostych uniemożliwiłoby otrzymanie tak dużej wartości silni.
        //jeśli zawali ci kompa to zmniejsz n

        int n = 1000000;
        BigInteger silnia = BigInteger.ONE;
        long startTime = System.nanoTime();
        for (int i = 1; i < n; i++) {
            BigInteger t = BigInteger.valueOf(i);
            silnia = silnia.multiply(t);
        }

        long estimatedTime = System.nanoTime() - startTime;

        System.out.println("Silnia o n: " + n + " wynosi: " + silnia);
        System.out.println("wyznaczona w czasie: " + estimatedTime);
    }

}
