import Funktionen.ECGleichung;
import Funktionen.ECPunkt;

import static Funktionen.Funktionen.*;

public class Uebung8 {
    public static void uebung8() {
        aufgabe1();
        //aufgabe2();
        aufgabe3();
        aufgabe5();
        aufgabe6();
        aufgabe7();
    }

    public static void aufgabe1() {
        System.out.println("Aufgabe 1:");
        ECGleichung g = new ECGleichung(2, 5, 7);
        g.printAllElements();
    }

    public static void aufgabe2() {
        System.out.println("\nAufgabe 2:");
        ECGleichung gleichung = new ECGleichung(2, 2, 17);
        ECPunkt p1 = new ECPunkt(gleichung, 2, 7);
        ECPunkt p2 = new ECPunkt(gleichung, 8, 2);
        System.out.println("a) (2, 7) + (5, 2) = " + p1.add(p2));
        ECPunkt p3 = new ECPunkt(gleichung, 3, 6);
        System.out.println("a) (3, 6) * 2 = " + (new ECPunkt(gleichung, 3, 6).verdoppeln()));
    }

    public static void aufgabe3() {
        System.out.println("\nAufgabe 3:");
        ECGleichung g = new ECGleichung(2, 6, 7);
        g.printAllElements();
        System.out.println("2 * (2, 2) = " + g.verdoppeln(2, 2));
        System.out.println("(2, 2) + (3, 5) = " + g.add(2, 2, 3, 5));
        System.out.println("5 * (2, 2) = " + g.mult(2, 2, 5));
    }

    public static void aufgabe5() {
        System.out.println("\nAufgabe 5:");
        ECGleichung g = new ECGleichung(3, 2, 7);
        g.printAllElements();
        System.out.println("(0, 3) ist primitiv: " + new ECPunkt(g, 0, 3).isPrimitive(true));
    }

    public static void aufgabe6() {
        System.out.println("\nAufgabe 6:");
        ECGleichung g = new ECGleichung(1, 6, 11);
        System.out.println("k = 6 * (5, 9) = " + g.mult(5, 9, 6));
    }

    public static void aufgabe7() {
        System.out.println("\nAufgabe 7:");
        ECGleichung g = new ECGleichung(2, 2, 17);
        ECPunkt G = new ECPunkt(g, 5, 1);
        long[] H = new long[]{12, 4, 9};
        int[] kE = new int[]{11, 13, 8};
        long q = 19;
        long d = 10;
        int n = 19;
        long[] r = new long[3];
        ECPunkt[] A = new ECPunkt[3];
        ECPunkt Q = G.mult(10);
        long[] s = new long[3];
        long[] w = new long[3];
        long[] u1 = new long[3];
        long[] u2 = new long[3];
        ECPunkt[] test = new ECPunkt[3];
        System.out.println("Q = " + Q);
        for (int i = 0; i < 3; i++) {
            A[i] = G.mult(kE[i]);
            r[i] = mod(A[i].x, n);
            s[i] = mod(inverseBerechnenLong(kE[i], n) * (H[i] + r[i] * d), n);
            System.out.print("A = " + A[i] + "  r = " + r[i] + "  s = " + s[i]);
            w[i] = inverseBerechnenLong(s[i], n);
            u1[i] = mod(H[i]*w[i], n);
            u2[i] = mod(r[i] * w[i], n);
            test[i] = G.mult(u1[i]).add(Q.mult(u2[i]));
            System.out.print("  n*Q = " + Q.mult(n) + "  w = " + w[i] + "  u1 = " + u1[i] + "  u2 = " + u2[i]);
            System.out.print("  (xA, yA) = " + test[i] + "  gültig: " + (r[i] == test[i].x));
            System.out.println();
        }
    }
}
