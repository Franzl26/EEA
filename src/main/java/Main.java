import java.math.BigInteger;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import static Funktionen.Funktionen.*;

public class Main {
    public static void main(String[] args) {
        // test();
        // speedTest();
        uebung5();
        // System.out.println(Arrays.toString(getAllPrimitiveElements(1151)));
        // System.out.println(Arrays.toString(getAllPrimitiveElements(1163)));
        // System.out.println(testPrimitiveElement(22, 1151));
    }

    public static void uebung5() {
        // Aufgabe 2
        System.out.println("Aufgabe 2:");
        System.out.println("2002: " + faktorisieren(2002));
        System.out.println("1004716607: " + faktorisieren(1004716607)); // ist Prim!
        System.out.println("1004716608: " + faktorisieren(1004716608));

        // Aufgabe 3
        System.out.println("\nAufgabe 3: "); // 55=5*11 phi(55)=4*10=40
        for (int i = 1; i < 40; i++) {
            if (ggt(i, 40).longValue() == 1) System.out.print(i + ", ");
        }

        // Aufgabe 4
        System.out.println("\n\nAufgabe 4: "); // phi(21) = (3-1)*(7-1) = 12
        System.out.println("5^-1 mod 12: " + inverseBerechnen(5, 12));
        BigInteger[] ergebnis = rsaCrypt(new long[]{3, 1, 13, 4, 7, 0, 4, 11, 6, 1, 8, 13, 4, 10}, 5, 21);
        System.out.println("a: " + Arrays.toString(ergebnis));
        ergebnis = rsaCrypt(new long[]{18, 1, 2, 3, 18, 16, 19, 3, 11, 6, 0, 17, 16, 3, 7, 11, 6, 13, 16, 13, 14}, 5, 21);
        System.out.println("b: " + Arrays.toString(ergebnis));
        // System.out.println("b^-1: " + Arrays.toString(rsaCrypt(ergebnis, 5, 21)));

        // Aufgabe 5
        System.out.println("\nAufgabe 5:");
        System.out.println("22663 faktorisiert: " + faktorisieren(22663));
        System.out.println("d=e^-1 mod phi(n): " + inverseBerechnen(14907, 22360));
        BigInteger[] a5 = rsaCrypt(new long[]{3595, 10898, 2212, 4379, 1736, 14519, 6584, 2489, 21854, 15215, 4972, 12974}, 3, 22663);
        System.out.println("blockarray: " + Arrays.toString(a5));
        for (BigInteger i : a5) {
            System.out.print(i.longValue() / 27 + ":" + i.longValue() % 27 + ";  "); //Kryptographie ist klasse
        }
        System.out.println();

        // Aufgabe 6
        System.out.println("\nAufgabe 6:");
        System.out.println("alpha: " + modPow(2, 6, 11));
        System.out.println("betta: " + modPow(2, 7, 11));
        System.out.println("k-Alice: " + modPow(7, 6, 11));
        System.out.println("k - Bob: " + modPow(9, 7, 11));
        for (int i = 1; i < 11; i++) {
            System.out.print(modPow(10, i, 11) + ", ");
        }
        System.out.println();

        // Aufgabe 7
        System.out.println("\nAufgabe 7:");
        System.out.println("k: " + modPow(25, 22, 2017));

        // Aufgabe 8
        System.out.println("\nAufgabe 8:");
        System.out.println("betta: " + modPow(2, 6, 11));
        System.out.println("c1: " + modPow(2, 7, 11));
        System.out.println("c2: " + modPow((long) (Math.pow(9, 7) * 5), 1, 11));
        System.out.println("x: " + modPow(7, 6, 11));
        System.out.println("x^-1: " + inverseBerechnen(4, 11));
        System.out.println("m: " + modPow(3 * 9, 1, 11));

        // Aufgabe Z1
        System.out.println("\nAufgabe Z1:");
        for (int i = 1; i < 50; i++) {
            System.out.printf("%2d: %2d, ", i, modPow(19, i, 29));
            if (i % 10 == 0)
                System.out.println();
        }
        System.out.println();

        // Aufgabe Z2
        System.out.println("\nAufgabe Z2:");
        System.out.println(squareAndMultiply(14, 24, 55));
        System.out.println(modPow(14, 14, 55));

        // Aufgabe Z3
        System.out.println("\nAufgabe Z3:");
        for (int i = 1; i < 2017; i++) {
            if (modPow(5, i, 2017).longValue() == 3) System.out.println("a = " + i);
            if (modPow(5, i, 2017).longValue() == 288) System.out.println("b = " + i);
        }
        System.out.println("k: " + modPow(5, 1030 * 194, 2017));

        // Aufgabe Z4
        System.out.println("\nAufgabe Z4:");
        System.out.println("Fakt 1151: " + faktorisieren(1151));
        long betta = 76;
        long s = 22;
        long mod = 1151;
        System.out.println("betta: " + betta);
        long b = 1;
        SortedSet<Long> list = new TreeSet<>();
        for (int i = 1; i < mod; i++) {
            long tmp = modPow(s, i, mod).longValue();
            //System.out.print(i + ": " + tmp + " \n");
            list.add(tmp);
            System.out.print(tmp + " ");
            if (i == 575) System.out.println();
            if (tmp == 76) {
                System.out.println("b = " + i);
                b = i;
            }
        }
        System.out.println("\nelemente: " + list.size());
        long[] r = new long[]{74, 75, 13};
        long[] m = new long[]{69, 105, 115};
        long[] c1 = new long[3]; //{836, 274, 178};
        long[] c2 = new long[3]; //{475, 475, 475};
        for (int i = 0; i < 3; i++) {
            c1[i] = modPow(s, r[i], mod).longValue();
            c2[i] = modPow((long) (Math.pow(betta, r[i]) * m[i]), 1, mod).longValue();
            c2[i] = modPow(modPow(betta,r[i], mod).longValue() * m[i], 1, mod).longValue();
            System.out.print("c" + i + "1: " + c1[i]);
            System.out.println("   c" + i + "2: " + c2[i]);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("m: " + modPow(c2[i] * inverseBerechnen(modPow(c1[i], b, mod).longValue(), mod).longValue(), 1, 1131));
        }
    }

    public static void test() {
        System.out.println(euklidischerAlgorithmus(973, 301, true));
        System.out.println(Arrays.toString(erweiterterEuklidischerAlgorithmus(973, 301, true)));
        System.out.println(Arrays.toString(erweiterterEuklidischerAlgorithmus(67, 12, true)));
        System.out.println(inverseBerechnen(7, 12));
        System.out.println(inverseBerechnen(12, 67));
        System.out.println(faktorisieren(976));
    }

    public static void speedTest() {
        int anz = 10000;
        long modulus = 7 * anz / 2;
        long start = System.currentTimeMillis();
        for (int i = 1; i < anz; i++) modPow(2L, i, modulus);
        long mitte = System.currentTimeMillis();
        for (int i = 1; i < anz; i++) squareAndMultiply(2L, i, modulus);
        long ende = System.currentTimeMillis();
        System.out.println(mitte - start);
        System.out.println(ende - mitte);

    }
}
