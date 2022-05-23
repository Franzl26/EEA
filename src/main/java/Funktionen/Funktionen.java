package Funktionen;

public class Funktionen {
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

    public static long[] erweiterterEuklidischerAlgorithmus(long r0, long r1) {
        return erweiterterEuklidischerAlgorithmus(r0, r1, false);
    }

    /**
     * @param ausgabe Erweiterte Ausgabe / Lösungsweg
     * @return Integer-Array mit 3 Werten: ggT(r0,r1); s; t mit 1 = s * r0 + t * r1
     */
    public static long[] erweiterterEuklidischerAlgorithmus(long r0, long r1, boolean ausgabe) {
        if (r0 < 1 || r1 < 1)
            throw new IllegalArgumentException("r0 und r1 muessen positive ganze Zahlen sein");
        if (r0 < r1)
            throw new IllegalArgumentException("r0 muss groesser als r1 sein");
        long r0alt = r0;
        long r1alt = r1;
        long s0 = 1, s1 = 0, t0 = 0, t1 = 1;
        long stellen = (int) (Math.log10(r0) + 1);
        do {
            // neue Variablen Berechnen
            long r2 = r0 % r1;
            long q = r0 / r1;
            long s2 = s0 - q * s1;
            long t2 = t0 - q * t1;

            if (ausgabe)
                System.out.printf("%" + stellen + "d = %d * %" + stellen + "d + %" + stellen + "d", r0, r0 / r1, r1, r2);
            if (ausgabe && r2 != 0) System.out.printf("  |  %" + stellen + "d = %3d * %d + %3d * %d\n", r2, s2, r0alt, t2, r1alt);
            else if (ausgabe) System.out.print("\n");
            // Variablen verschieben
            r0 = r1;
            r1 = r2;
            s0 = s1;
            s1 = s2;
            t0 = t1;
            t1 = t2;
        } while (r1 != 0);
        return new long[]{r0, s0, t0};
    }

    public static long inverseBerechnen(long zahl, long moduloRaum) {
        return inverseBerechnen(zahl, moduloRaum, false);
    }

    /**
     * @param ausgabe erweiterte Ausgabe / Lösungsweg
     * @return zahl^-1 mod moduloRaum
     */
    public static long inverseBerechnen(long zahl, long moduloRaum, boolean ausgabe) {
        if (zahl < 1 || moduloRaum < 1)
            throw new IllegalArgumentException("Beide Parameter muessen groesser 0 sein");
        if (zahl > moduloRaum)
            throw new IllegalArgumentException("Zahl muss groesser als der ModuloRaum sein");
        long[] ergebnis = erweiterterEuklidischerAlgorithmus(moduloRaum, zahl, ausgabe);
        if (ergebnis[0] != 1)
            throw new IllegalArgumentException("der GGT der Parameter ist nicht 1 und damit keine Inverse bestimmbar");
        if (ergebnis[2] < 0) ergebnis[2] += moduloRaum;
        return ergebnis[2];
    }

    public static String faktorisieren(long zahl) {
        StringBuilder s = new StringBuilder();
        while (zahl != 1) {
            for (int i = 2;; i++) {
                if (zahl % i == 0) {
                    if (!s.isEmpty()) s.append(" * ");
                    s.append(i);
                    zahl /= i;
                    break;
                }
                if (i > zahl / 2) {
                    if (!s.isEmpty()) s.append(" * ");
                    s.append(zahl);
                    zahl = 1;
                    break;
                }
            }
        }

        return s.toString();
    }

    public static long[] rsaCrypt(long[] werte, long key, long modus) {
        long[] ergebnis = new long[werte.length];
        for (int i = 0; i < werte.length; i++) {
            ergebnis[i] = (werte[i] ^ key) % modus;
        }
        return ergebnis;
    }
}
