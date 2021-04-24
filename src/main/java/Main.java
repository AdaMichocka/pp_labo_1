import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Zad_1 zad_1 = new Zad_1();
        Zad_2 zad_2 = new Zad_2();
        Zad_3 zad_3 = new Zad_3();
        Zad_4 zad_4 = new Zad_4();
        Zad_5 zad_5 = new Zad_5();
        Scanner scanner = new Scanner(System.in);


        boolean war = false;
        while (!war) {
            System.out.println("------------------------------------------");
            System.out.println("Wpisz numer zadania 1-5");
            System.out.println("(Żeby zakończyć program wpisz 0)");
            System.out.println("------------------------------------------");
            System.out.println();

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    zad_1.zad1();
                    break;
                case 2:
                    zad_2.zad2();
                    break;
                case 3:
                    zad_3.zad3();
                    break;
                case 4:
                    zad_4.zad4();
                    break;
                case 5:
                    zad_5.zad5();
                    break;
                case 0:
                    war = true;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
