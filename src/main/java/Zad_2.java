import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Zad_2 {

    public void zad2() {

        //Zastosowanie typów prostych uniemożliwiłoby otrzymanie tak dużej wartości silni.

        int n = 100000;
        BigInteger silnia = BigInteger.ONE;
        long startTime = System.nanoTime();
        for (int i = 1; i <= n; i++) {

            BigInteger t = BigInteger.valueOf(i);
            silnia = silnia.multiply(t);
        }

        long estimatedTime = System.nanoTime() - startTime;
        NumberFormat formatter = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT));
        String str = formatter.format(silnia);

        System.out.println("Silnia o n: " + n + " wynosi: " + str);
        System.out.println("wyznaczona w czasie: " + estimatedTime);
    }

}
