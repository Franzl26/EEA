import java.util.Arrays;

import static Funktionen.Funktionen.*;

public class Main {
    public static void main(String[] args) {
        // test();
        uebung5();
    }

    public static void uebung5() {
        // Aufgabe 2
        System.out.println("Aufgabe 2:");
        System.out.println("2002: " + faktorisieren(2002));
        // System.out.println("1004716607: " + faktorisieren(1004716607)); // ist Prim!
        System.out.println("1004716607: " + "1004716607");
        System.out.println("1004716608: " + faktorisieren(1004716608));

        // Aufgabe 3
        System.out.println("\nAufgabe 3: ");

        // Aufgabe 4
        System.out.println("\nAufgabe 4: "); // phi(21) = (3-1)*(7-1) = 12
        System.out.println("5^-1 mod 12: " + inverseBerechnen(5, 12));
        long[] ergebnis = rsaCrypt(new long[]{3, 1, 13, 4, 7, 0, 4, 11, 6, 1, 8, 13, 4, 10}, 5, 21);
        System.out.println("a: " + Arrays.toString(ergebnis));
        ergebnis = rsaCrypt(new long[]{18, 1, 2, 3, 18, 16, 19, 3, 11, 6, 0, 17, 16, 3, 7, 11, 6, 13, 16, 13, 14}, 5, 21);
        System.out.println("b: " + Arrays.toString(ergebnis));
    }

    public static void test() {
        System.out.println(euklidischerAlgorithmus(973, 301, true));
        System.out.println(Arrays.toString(erweiterterEuklidischerAlgorithmus(973, 301, true)));
        System.out.println(Arrays.toString(erweiterterEuklidischerAlgorithmus(67, 12, true)));
        System.out.println(inverseBerechnen(7, 12, true));
        System.out.println(faktorisieren(976));
    }
}
