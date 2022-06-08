package Funktionen;

import java.math.BigInteger;

import static Funktionen.Funktionen.*;

public class ECPunkt {
    // neutrales Element = "Punkt im Unendlichen" bei x = y = -1
    public final ECGleichung gleichung;
    public long x;
    public long y;

    public ECPunkt(ECGleichung gleichung, long x, long y) {
        if (!testPunkt(x, y, gleichung))
            throw new IllegalArgumentException("Die Koordinaten (" + x + ", " + y
                    + ") erfüllen die Gleichung: " + gleichung + " nicht");
        this.gleichung = gleichung;
        this.x = x;
        this.y = y;
    }

    public static boolean testPunkt(long x, long y, ECGleichung g) {
        if (x == -1 && y == -1) return true;
        return (mod(y * y, g.p) == mod(x * x * x + g.a * x + g.b, g.p));
    }

    public boolean equals(ECPunkt punkt) {
        if (this.x != punkt.x) return false;
        if (this.y != punkt.y) return false;
        return this.gleichung.isEqual(punkt.gleichung);
    }

    public ECPunkt verdoppeln() {
        // bei neutralem Element
        if (x == -1) return this;

        long s = mod((3 * x * x + gleichung.a) * inverseBerechnenLong(2 * y, gleichung.p), gleichung.p);
        long newX = mod(s * s - x - x, gleichung.p);
        long newY = mod(s * (x - newX) - y, gleichung.p);
        return new ECPunkt(gleichung, newX, newY);
    }

    public ECPunkt add(ECPunkt punkt) {
        if (!gleichung.isEqual(punkt.gleichung)) {
            throw new IllegalArgumentException("Die Beiden Punkte gehören nicht zur selben Elliptischen Kurve");
        }
        if (x == punkt.x && y == (gleichung.p - punkt.y)) return new ECPunkt(gleichung, -1, -1);
        if (equals(punkt)) return verdoppeln();

        // bei neutralem Element
        if (x == -1) return punkt;
        if (punkt.x == -1) return this;
        try {
            long s = mod((punkt.y - y) * inverseBerechnenLong(punkt.x - x, gleichung.p), gleichung.p);
            long newX = mod(s * s - punkt.x - x, gleichung.p);
            long newY = mod(s * (x - newX) - y, gleichung.p);
            return new ECPunkt(gleichung, newX, newY);
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
            throw new ArithmeticException("this: " + this + " punkt: " + punkt);
        }
    }

    public ECPunkt mult(long anz) {
        if (anz <= 0) throw new IllegalArgumentException("d muss >= 1 sein");

        BigInteger d = BigInteger.valueOf(anz);
        ECPunkt erg = this;

        int size = d.bitLength();
        for (int i = 2; i <= size; i++) {
            erg = erg.verdoppeln();
            if (d.testBit(size - i)) {
                erg = erg.add(this);
            }
        }
        return erg;
    }

    @Override
    public String toString() {
        if (x == -1) return "O";
        return "(" + x + ", " + y + ")";
    }

    public boolean isPrimitive() {
        return isPrimitive(false);
    }

    public boolean isPrimitive(boolean printElements) {
        if (y == 0) {
            System.out.println(this + " skipped because y = 0");
            return false;
        }
        ECPunkt tmp = new ECPunkt(gleichung, x, y);
        int i;
        for (i = 1; ; i++) {
            tmp = tmp.add(this);
            if (printElements) System.out.println(i + ": " + tmp);
            if (tmp.equals(this)) break;
        }
        return (i > (gleichung.p + 1 - 2 * Math.sqrt(gleichung.p)) && i < (gleichung.p + 1 + 2 * Math.sqrt(gleichung.p)));

    }
}
