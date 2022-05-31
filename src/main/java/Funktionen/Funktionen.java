package Funktionen;

import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;

public class Funktionen {
    public static BigInteger ggt(long r0, long r1) {
        return ggt(Long.toString(r0), Long.toString(r1));
    }

    public static BigInteger ggt(String r0, String r1) {
        return new BigInteger(r0).gcd(new BigInteger(r1));
    }

    public static long euklidischerAlgorithmus(long r0, long r1) {
        return euklidischerAlgorithmus(r0, r1, false);
    }

    public static long euklidischerAlgorithmus(long r0, long r1, boolean ausgabe) {
        if (r0 < 1 || r1 < 1)
            throw new IllegalArgumentException("r0 und r1 muessen positive ganze Zahlen sein");
        if (r0 < r1) {
            long tmp = r0;
            r0 = r1;
            r1 = tmp;
        }
        long stellen = (int) (Math.log10(r0) + 1);

        do {
            long tmp = r0 % r1;
            if (ausgabe) System.out.printf("%" + stellen + "d = %d * %" + stellen + "d + %d\n", r0, r0 / r1, r1, tmp);
            r0 = r1;
            r1 = tmp;
        } while (r1 != 0);
        return r0;
    }

    public static BigInteger[] erweiterterEuklidischerAlgorithmus(long r0, long r1) {
        return erweiterterEuklidischerAlgorithmus(Long.toString(r0), Long.toString(r1), false);
    }

    public static BigInteger[] erweiterterEuklidischerAlgorithmus(long r0, long r1, boolean ausgabe) {
        return erweiterterEuklidischerAlgorithmus(Long.toString(r0), Long.toString(r1), ausgabe);
    }

    public static BigInteger[] erweiterterEuklidischerAlgorithmus(String r0, String r1) {
        return erweiterterEuklidischerAlgorithmus(r0, r1, false);
    }

    /**
     * @param ausgabe Erweiterte Ausgabe / Lösungsweg
     * @return Integer-Array mit 3 Werten: ggT(r0,r1); s; t mit 1 = s * r0 + t * r1
     */
    public static BigInteger[] erweiterterEuklidischerAlgorithmus(String r0in, String r1in, boolean ausgabe) {
        BigInteger r0 = new BigInteger(r0in);
        BigInteger r1 = new BigInteger(r1in);
        BigInteger r0alt = r0;
        BigInteger r1alt = r1;
        BigInteger s0 = BigInteger.valueOf(1);
        BigInteger s1 = BigInteger.valueOf(0);
        BigInteger t0 = BigInteger.valueOf(0);
        BigInteger t1 = BigInteger.valueOf(1);
        long stellen = (int) (Math.log10(r0.longValue()) + 1);
        do {
            // neue Variablen Berechnen
            BigInteger r2 = r0.remainder(r1);
            BigInteger q = r0.divide(r1);
            BigInteger s2 = s0.subtract(q.multiply(s1));
            BigInteger t2 = t0.subtract(q.multiply(t1));

            if (ausgabe)
                System.out.printf("%" + stellen + "d = %d * %" + stellen + "d + %" + stellen + "d", r0, r0.divide(r1), r1, r2);
            if (ausgabe && !r2.equals(BigInteger.ZERO))
                System.out.printf("  |  %" + stellen + "d = %3d * %d + %3d * %d\n", r2, s2, r0alt, t2, r1alt);
            else if (ausgabe) System.out.print("\n");
            // Variablen verschieben
            r0 = r1;
            r1 = r2;
            s0 = s1;
            s1 = s2;
            t0 = t1;
            t1 = t2;
        } while (!r1.equals(BigInteger.valueOf(0)));
        return new BigInteger[]{r0, s0, t0};
    }

    public static BigInteger inverseBerechnen(long zahl, long moduloRaum) {
        return inverseBerechnen(Long.toString(zahl), Long.toString(moduloRaum));
    }

    public static BigInteger inverseBerechnen(String zahl, String moduloRaum) {
        return new BigInteger(zahl).modInverse(new BigInteger(moduloRaum));
    }

    public static String faktorisieren(long zahl) {
        return faktorisieren(Long.toString(zahl));
    }

    public static String faktorisieren(String zahlIn) {
        BigInteger zahl = new BigInteger(zahlIn);
        StringBuilder s = new StringBuilder();
        BigInteger ziel = zahl.sqrt();
        while (!zahl.equals(BigInteger.ONE)) {
            for (int i = 2; ; i++) {
                BigInteger iTmp = BigInteger.valueOf(i);
                if (zahl.remainder(iTmp).equals(BigInteger.ZERO)) {
                    if (!s.isEmpty()) s.append(" * ");
                    s.append(i);
                    zahl = zahl.divide(iTmp);
                    break;
                }
                if (iTmp.equals(ziel.max(iTmp))) {
                    if (!s.isEmpty()) s.append(" * ");
                    s.append(zahl);
                    zahl = BigInteger.ONE;
                    break;
                }
            }
        }

        return s.toString();
    }

    public static BigInteger[] rsaCrypt(long[] werte, long key, long modus) {
        return rsaCrypt(werte, Long.toString(key), Long.toString(modus));
    }

    public static BigInteger[] rsaCrypt(long[] werte, String keyIn, String modusIn) {
        BigInteger[] ergebnis = new BigInteger[werte.length];
        BigInteger key = new BigInteger(keyIn);
        BigInteger modus = new BigInteger(modusIn);
        for (int i = 0; i < werte.length; i++) {
            // System.out.println(Math.pow(werte[i], key));
            ergebnis[i] = BigInteger.valueOf(werte[i]).modPow(key, modus);
        }
        return ergebnis;
    }

    public static BigInteger modPow(long basis, long exponent, long modulus) {
        return BigInteger.valueOf(basis).modPow(BigInteger.valueOf(exponent), BigInteger.valueOf(modulus));
    }

    public static long mod(long wert, long modulus) {
        return BigInteger.valueOf(wert).mod(BigInteger.valueOf(modulus)).longValue();
    }

    public static BigInteger squareAndMultiply(long basis, long exponent, long modulus) {
        return squareAndMultiply(Long.toString(basis), Long.toString(exponent), Long.toString(modulus));
    }

    public static BigInteger squareAndMultiply(String basisIn, String exponentIn, String modulusIn) {
        BigInteger basis = new BigInteger(basisIn);
        BigInteger exponent = new BigInteger(exponentIn);
        BigInteger modulus = new BigInteger(modulusIn);

        int size = exponent.bitLength();
        BigInteger erg = BigInteger.ONE;
        for (int i = 1; i <= size; i++) {
            erg = erg.pow(2).mod(modulus);
            // System.out.print(i + ": " + erg + ", ");
            if (exponent.testBit(size - i)) {
                erg = erg.multiply(basis).mod(modulus);
                //System.out.println(erg);
            } /*else {
                System.out.println(erg);
            }*/
        }
        return erg;
    }

    public static long getPrimitiveElement(long modulus) {
        long basis = 2;
        while (basis < modulus) {
            SortedSet<Long> list = new TreeSet<>();
            for (int i = 1; i < modulus; i++) {
                list.add(modPow(basis, i, modulus).longValue());
            }
            if (list.size() == modulus - 1) return basis;
            basis++;
        }
        return -1;
    }

    public static boolean testPrimitiveElement(long element, long modulus) {
        long basis = 2;
        while (basis < modulus) {
            SortedSet<Long> list = new TreeSet<>();
            for (int i = 1; i < modulus; i++) {
                list.add(modPow(basis, i, modulus).longValue());
            }
            if (list.size() == modulus - 1) {
                if (basis == element) return true;
            }
            basis++;
        }
        return false;
    }

    public static long[] getAllPrimitiveElements(long modulus) {
        TreeSet<Long> ergebnis = new TreeSet<>();

        long basis = 2;
        while (basis < modulus) {
            SortedSet<Long> list = new TreeSet<>();
            for (int i = 1; i < modulus; i++) {
                list.add(modPow(basis, i, modulus).longValue());
            }
            if (list.size() == modulus - 1) ergebnis.add(basis);
            basis++;
        }
        Long[] tmp = ergebnis.toArray(new Long[0]);
        long[] x = new long[ergebnis.size()];
        for (int i = 0; i < ergebnis.size(); i++) {
            x[i] = tmp[i];
        }
        return x;
    }
}
