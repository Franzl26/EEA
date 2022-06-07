package Funktionen;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

import static Funktionen.Funktionen.mod;

public class ECGleichung {
    public final long a;
    public final long b;
    public final long p;

    public ECGleichung(long a, long b, long p) {
        if (a >= p || b >= p) throw new IllegalArgumentException("a und b müssen Element von Zp (kleiner p) sein");
        long test = 4 * a * a * a + 27 * b * b; // 4*a^3 + 27*b^2
        if (test == 0) throw new IllegalArgumentException("a und b erfüllen nicht 4*a^3 + 27*b^2 != 0");
        this.a = a;
        this.b = b;
        this.p = p;
    }

    public boolean isEqual(ECGleichung gleichung) {
        if (this.a != gleichung.a) return false;
        if (this.b != gleichung.b) return false;
        return this.p == gleichung.p;
    }

    @Override
    public String toString() {
        return "y^2 = x^3 + " + a + "x + " + b + " mod " + p;
    }

    public ArrayList<ECPunkt> printAllElements() {
        ArrayList<ECPunkt> c = new ArrayList<>();
        int count = 0;
        for (long x = 0; x < p; x++) {
            long tmp = mod(x * x * x + a * x + b, p);


            for (long y = 0; y < p; y++) {
                if (mod(y * y, p) == tmp) {
                    System.out.print("(" + x + ", " + y + "), ");
                    count++;
                    c.add(new ECPunkt(this, x, y));
                }
            }
        }
        count++;
        c.add(new ECPunkt(this, -1, -1));
        System.out.println("O\nAnzahl: " + count);
        return c;
    }
}
