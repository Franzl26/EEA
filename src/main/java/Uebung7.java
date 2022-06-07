import static Funktionen.Funktionen.*;
import static Funktionen.Funktionen.mod;

public class Uebung7 {
    public static void uebung7() {
        aufgabe1();
        aufgabe2();
        aufgabe3();
        aufgabe4();
        aufgabe5();
        aufgabeZ2();
    }

    public static void aufgabe1() {
        System.out.println("Aufgabe 1:");
        System.out.println(modPow(6292, 131, 9797) + " "
                + (modPow(6292, 131, 9797).longValue() == 123 ? "gültig" : "ungültig"));
        System.out.println(modPow(4768, 131, 9797) + " "
                + (modPow(4768, 131, 9797).longValue() == 4333 ? "gültig" : "ungültig"));
        System.out.println(modPow(1424, 131, 9797) + " "
                + (modPow(1424, 131, 9797).longValue() == 4333 ? "gültig" : "ungültig"));
    }

    public static void aufgabe2() {
        System.out.println("\nAufgabe 2:");
        System.out.println("s = 100\nm = " + modPow(100, 131, 9797));
        System.out.println("check s = " + modPow(9190, 131, 9797));
    }

    public static void aufgabe3() {
        System.out.println("\nAufgabe 3a:");
        long d = 67;
        long alpha = 23;
        long betta = 15;
        long p = 97;
        System.out.println("alpha ist primitiv in p: " + testPrimitiveElement(alpha, p));
        System.out.println("betta ist richtig berechnet: " + (modPow(alpha, d, p).longValue() == betta));
        long[] m = new long[]{17, 17, 85};
        long[] kE = new long[]{31, 49, 77};
        for (int i = 0; i < 3; i++) {
            long kEinv = inverseBerechnen(kE[i], p).longValue();
            long r = modPow(alpha, kE[i], p).longValue();
            long klammer = m[i] - d * r;
            long u = modPow(klammer * kEinv, 1, p - 1).longValue();
            //System.out.println("(" + (i + 1) + ") kEinv = " + kEinv + "  klammer = " + klammer + "  ");
            System.out.println("(" + (i + 1) + ") r = " + r + "   u = " + u);
        }
        System.out.println("3b:");
        m = new long[]{22, 82};
        long[] r = new long[]{37, 13};
        long[] u = new long[]{33, 65};
        for (int i = 0; i < 2; i++) {
            long t = modPow(modPow(betta, r[i], p).longValue() * modPow(r[i], u[i], p).longValue(), 1, p).longValue();
            long test = modPow(alpha, m[i], p).longValue();
            System.out.println(i + ": t = " + t + "  test = " + test + "  gültig: " + (t == test));
        }
    }

    public static void aufgabe4() {
        System.out.println("\nAufgabe 4a:");
        long m4 = 10;
        long p = 31;
        long alpha = 3;
        long betta = 6;
        System.out.println("alpha ist primitives element in p: " + testPrimitiveElement(alpha, p));
        long[] r = new long[]{17, 13};
        long[] u = new long[]{5, 15};
        for (int i = 0; i < 2; i++) {
            long t = modPow(modPow(betta, r[i], p).longValue() * modPow(r[i], u[i], p).longValue(), 1, p).longValue();
            long test = modPow(alpha, m4, p).longValue();
            System.out.println(i + ": t = " + t + "  test = " + test + "  gültig: " + (t == test));
        }
        System.out.println("4b");
        System.out.print("zulässige kE: ");
        for (int i = 0; i <= p - 2; i++) {
            if (ggt(i, p - 1).longValue() == 1) System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void aufgabe5() {
        System.out.println("\nAufgabe 5:");
        long p = 59;
        long q = 29;
        long alpha = 3;
        long d = 23;
        long betta = modPow(alpha, d, p).longValue();
        System.out.println("betta = " + betta);
        long[] h = new long[]{17, 2, 21};
        long[] kE = new long[]{25, 13, 8};
        String[] aufgabe = new String[]{"a)", "b)", "c)"};
        long[] r = new long[3];
        long[] u = new long[3];
        for (int i = 0; i < 3; i++) {
            r[i] = mod(modPow(alpha, kE[i], p).longValue(), q);
            long kEinv = inverseBerechnen(kE[i], q).longValue();
            long klammer = mod(h[i] + d * r[i], q);
            u[i] = mod(klammer * kEinv, q);
            System.out.println(aufgabe[i] + " kE^-1 = " + kEinv + "  r = " + r[i] + "   u = " + u[i]);
        }
        for (int i = 0; i < 3; i++) {
            long w = inverseBerechnen(u[i], q).longValue();
            long u1 = mod(w * h[i], q);
            long u2 = mod(w * r[i], q);
            long tmp1 = modPow(alpha, u1, p).longValue();
            long tmp2 = modPow(betta, u2, p).longValue();
            long v = mod(mod(tmp1 * tmp2, p), q);
            //System.out.println("tmp1 = " + tmp1 + "\ntmp2 = " + tmp2);
            System.out.println(aufgabe[i] + " w = " + w + "  u1 = " + u1 + "  u2 = " + u2 + "  v = " + v + "  gültig: " + (v == mod(r[i], q)));
        }
    }

    public static void aufgabeZ2() {
        System.out.println("\nAufgabe Z2:");
        long p = 97;
        long alpha = 23;
        long betta = 15;
        long i = 2;
        long j = 7;
        /*long p = 23;
        long alpha = 3;
        long betta = 13;
        long i = 2;
        long j = 5;*/
        System.out.println("i = " + i + "  j = " + j);
        long r = mod(modPow(alpha, i, p).longValue() * modPow(betta, j, p).longValue(), p);
        System.out.println("r = " + r);
        long u = mod(-r * inverseBerechnen(j, p - 1).longValue(), p - 1);
        System.out.println("u = " + u);
        long m = mod(u * i, p - 1);
        System.out.println("m = " + mod(i * u, p - 1));
        System.out.println("Verifizierung:");
        long t = mod(modPow(betta, r, p).longValue() * modPow(r, u, p).longValue(), p);
        System.out.println("t = " + t);
        long vergleich = modPow(alpha, m, p).longValue();
        System.out.println("vergleich = " + vergleich);
    }
}
