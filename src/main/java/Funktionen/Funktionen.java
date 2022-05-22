package Funktionen;

public class Funktionen {
    public static int euklidischerAlgorithmus(int r0, int r1) {
        return euklidischerAlgorithmus(r0, r1, false);
    }

    public static int euklidischerAlgorithmus(int r0, int r1, boolean ausgabe) {
        if (r0 < 1 || r1 < 1)
            throw new IllegalArgumentException("r0 und r1 muessen positive ganze Zahlen sein");
        if (r0 < r1) {
            int tmp = r0;
            r0 = r1;
            r1 = tmp;
        }
        int stellen = (int) (Math.log10(r0) + 1);

        do {
            int tmp = r0 % r1;
            if (ausgabe) System.out.printf("%" + stellen + "d = %d * %" + stellen + "d + %d\n", r0, r0 / r1, r1, tmp);
            r0 = r1;
            r1 = tmp;
        } while (r1 != 0);
        return r0;
    }

    public static int[] erweiterterEuklidischerAlgorithmus(int r0, int r1) {
        return erweiterterEuklidischerAlgorithmus(r0, r1, false);
    }

    /**
     * @param ausgabe Erweiterte Ausgabe / Lösungsweg
     * @return Integer-Array mit 3 Werten: ggT(r0,r1); s; t mit 1 = s * r0 + t * r1
     */
    public static int[] erweiterterEuklidischerAlgorithmus(int r0, int r1, boolean ausgabe) {
        if (r0 < 1 || r1 < 1)
            throw new IllegalArgumentException("r0 und r1 muessen positive ganze Zahlen sein");
        if (r0 < r1)
            throw new IllegalArgumentException("r0 muss groesser als r1 sein");
        int r0alt = r0;
        int r1alt = r1;
        int s0 = 1, s1 = 0, t0 = 0, t1 = 1;
        int stellen = (int) (Math.log10(r0) + 1);
        do {
            // neue Variablen Berechnen
            int r2 = r0 % r1;
            int q = r0 / r1;
            int s2 = s0 - q * s1;
            int t2 = t0 - q * t1;

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
        return new int[]{r0, s0, t0};
    }

    public static int inverseBerechnen(int zahl, int moduloRaum) {
        return inverseBerechnen(zahl, moduloRaum, false);
    }

    /**
     * @param ausgabe erweiterte Ausgabe / Lösungsweg
     * @return zahl^-1 mod moduloRaum
     */
    public static int inverseBerechnen(int zahl, int moduloRaum, boolean ausgabe) {
        if (zahl < 1 || moduloRaum < 1)
            throw new IllegalArgumentException("Beide Parameter muessen groesser 0 sein");
        if (zahl > moduloRaum)
            throw new IllegalArgumentException("Zahl muss groesser als der ModuloRaum sein");
        int[] ergebnis = erweiterterEuklidischerAlgorithmus(moduloRaum, zahl, ausgabe);
        if (ergebnis[0] != 1)
            throw new IllegalArgumentException("der GGT der Parameter ist nicht 1 und damit keine Inverse bestimmbar");
        if (ergebnis[2] < 0) ergebnis[2] += moduloRaum;
        return ergebnis[2];
    }
}
